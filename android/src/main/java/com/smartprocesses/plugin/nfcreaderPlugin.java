package com.smartprocesses.plugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "nfcreader")
public class nfcreaderPlugin extends Plugin {

    private nfcreader implementation = new nfcreader();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod()
    public void ReadNFCTag(PluginCall call){
        String value = call.getString("msg") + " Test Test 1234";
        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }

    @PluginMethod()
    public void WriteNFCTag(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", 12345);
        call.resolve(ret);
    }
}
