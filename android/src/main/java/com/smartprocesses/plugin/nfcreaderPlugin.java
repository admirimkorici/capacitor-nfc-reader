package com.smartprocesses.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.Ndef;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@CapacitorPlugin(name = "nfcreader")
public class nfcreaderPlugin extends Plugin {
    private NfcAdapter nfcAdapter;
    private Tag mytag;
    private Context context;
    private nfcreader implementation = new nfcreader();
    private PendingIntent nfcPendingIntent;
    private static final String TAG = "NFCPlugin";
    interface NfcDataCallback {
        void onDataReceived(String nfcData);
    }

    @Override
    public void load() {
        context = getContext();
        nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        // Initialize NFC pending intent
        Intent nfcIntent = new Intent(getContext(), getActivity().getClass());
        nfcIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        nfcPendingIntent = PendingIntent.getActivity(getContext(), 0, nfcIntent, PendingIntent.FLAG_IMMUTABLE);
        if (nfcAdapter == null) {
            Toast.makeText(context, "This device does not support NFC", Toast.LENGTH_SHORT).show();
        }
    }
    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void startNfcReading(PluginCall call) {
        if (nfcAdapter != null) {
            // Create an IntentFilter for NFC tech discovered action
            IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
            tagDetected.addCategory(Intent.CATEGORY_DEFAULT);

            // Add the IntentFilter to the activity's intent filter
            getActivity().registerReceiver(mNfcReceiver, tagDetected);

            // Create a PendingIntent for NFC tag discovery
            PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0,
                    new Intent(getContext(), getActivity().getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
                    PendingIntent.FLAG_UPDATE_CURRENT);

            // Enable foreground dispatch for NFC
            nfcAdapter.enableForegroundDispatch(getActivity(), pendingIntent, null, null);

            // Success callback
            call.resolve();
        } else {
            call.reject("NFC not supported on this device");
        }
    }

    // BroadcastReceiver to handle NFC tag discovery
    private final BroadcastReceiver mNfcReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                    || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                    || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
                // Process NFC tag data here
                // For example, read and display the tag's content
                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                String tagContent = readTagContent(tag);
                if (nfcDataCallback != null) {
                    nfcDataCallback.onDataReceived(tagContent);
                }
                Toast.makeText(context, "NFC Tag Content: " + tagContent, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private NfcDataCallback nfcDataCallback;

    // Method to set the NFC data callback
    public void setNfcDataCallback(NfcDataCallback callback) {
        this.nfcDataCallback = callback;
    }

    private String readTagContent(Tag tag) {
        Ndef ndef = Ndef.get(tag);
        if (ndef == null) {
            // Tag is not NDEF formatted or does not support NDEF
            return "Unsupported Tag";
        }

        NdefMessage ndefMessage = ndef.getCachedNdefMessage();
        if (ndefMessage == null) {
            // Tag does not contain NDEF message
            return "Empty Tag";
        }

        NdefRecord[] records = ndefMessage.getRecords();
        StringBuilder sb = new StringBuilder();

        for (NdefRecord record : records) {
            if (record.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(record.getType(), NdefRecord.RTD_TEXT)) {
                try {
                    // Extract language code and text from NDEF record
                    byte[] payload = record.getPayload();
                    String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
                    int languageCodeLength = payload[0] & 0063;
                    String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
                    String text = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);

                    // Append extracted text to StringBuilder
                    sb.append(text);
                } catch (UnsupportedEncodingException e) {
                    // Handle encoding error
                    return "Encoding Error";
                }
            }
        }

        return sb.toString();
    }


    @PluginMethod
    public void stopNfcReading(PluginCall call) {
        if (nfcAdapter != null) {
            // Disable foreground dispatch for NFC
            nfcAdapter.disableForegroundDispatch(getActivity());

            // Unregister the BroadcastReceiver used for NFC tag discovery
            try {
                getActivity().unregisterReceiver(mNfcReceiver);
            } catch (IllegalArgumentException e) {
                // Receiver not registered, do nothing
            }

            // Success callback indicating NFC reading stopped
            call.resolve();
        } else {
            call.reject("NFC not supported on this device");
        }
    }

    @PluginMethod
    public void writeNfcTag(PluginCall call) {
        String data = call.getString("data");

        // Check if NFC is available on the device
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(getContext());
        if (nfcAdapter == null) {
            call.reject("NFC not supported on this device");
            return;
        }

        try {
            // Create an NDEF message with the data to write
            NdefRecord record = NdefRecord.createTextRecord(null, data);
            NdefMessage message = new NdefMessage(new NdefRecord[]{record});

            // Write the NDEF message to the NFC tag using foreground dispatch
            nfcAdapter.enableForegroundDispatch(getActivity(), nfcPendingIntent, null, null);
            nfcAdapter.setNdefPushMessage(message, getActivity());
            Toast.makeText(context, TAG + "This device does not support NFC", Toast.LENGTH_SHORT).show();
            call.resolve();
        } catch (Exception e) {
            Toast.makeText(context, TAG + "Error writing NFC tag", Toast.LENGTH_SHORT).show();
            call.reject("Error writing NFC tag: " + e.getMessage());
        }
    }

    private void write(String text,Tag tag) throws IOException, FormatException {
        NdefRecord[] records = {createRecord(text)};
        NdefMessage message = new NdefMessage(records);
        Ndef ndef = Ndef.get(tag);
        ndef.connect();
        ndef.writeNdefMessage(message);
        ndef.close();

    }


    private NdefRecord createRecord(String text) throws UnsupportedEncodingException
    {
        String lang = "en";
        byte[] textBytes = text.getBytes();
        byte[] langBytes = lang.getBytes("US-ASCII");
        int langLength = langBytes.length;
        int textLength = textBytes.length;
        byte[] payload = new byte[1+langLength + textLength];

        payload[0] = (byte) langLength;

        System.arraycopy(langBytes,0,payload,1,langLength);
        System.arraycopy(textBytes,0,payload,1 + langLength,textLength);

        NdefRecord recordNFC = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,NdefRecord.RTD_TEXT,new byte[0],payload);
        return recordNFC;
    }

    @PluginMethod
    public void checkNfcAvailability(PluginCall call) {
        // Check NFC availability and send result back to the Ionic app
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(getContext());
        boolean isNfcAvailable = (nfcAdapter != null); // Check NFC availability
        JSObject result = new JSObject();
        result.put("available", isNfcAvailable);
        call.resolve(result);
    }

    @PluginMethod
    public void readNfcTag(PluginCall call) {
        // Read NFC tag and send data back to the Ionic app
        Tag tag = mytag; // Get the NFC tag
        String data = readFromNfcTag(tag); // Call your readFromNfcTag method
        JSObject result = new JSObject();
        result.put("data", data);
        call.resolve(result);
    }

    private String readFromNfcTag(Tag tag) {
        if (tag == null) {
            Toast.makeText(context, "No NFC tag detected", Toast.LENGTH_SHORT).show();
            return "";
        }

        Ndef ndef = Ndef.get(tag);
        if (ndef == null) {
            Toast.makeText(context, "Tag is not NDEF formatted", Toast.LENGTH_SHORT).show();
            return "";
        }

        NdefMessage ndefMessage = ndef.getCachedNdefMessage();
        if (ndefMessage != null) {
            // Get the NDEF message content
            String message = new String(ndefMessage.getRecords()[0].getPayload());
            Toast.makeText(context, "NFC Tag Content: " + message, Toast.LENGTH_SHORT).show();
            return message;
        } else {
            Toast.makeText(context, "Empty NDEF message", Toast.LENGTH_SHORT).show();
            return "";
        }
    }
}
