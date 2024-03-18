import { registerPlugin } from "@capacitor/core";

export interface nfcreaderPlugin {
    echo(options: { value: string }): Promise<{ value: string }>;
    writeNfcTag(options: { data: string }): Promise<{ value: string }>;
    startNfcReading(data: any): Promise<any>;
    stopNfcReading(data: any): Promise<any>;
    setNfcDataCallback(data: any): Promise<any>;
    checkNfcAvailability(options: { available: boolean }): Promise<{ available: boolean }>;
    readNfcTag(options: { data: string }): Promise<{ data: string }>;
}

const NFCTagReader = registerPlugin("nfcreader");

export default NFCTagReader;