declare module "@capacitor/core" {
    interface PluginRegistry {
        NFCTagReader: nfcreaderPlugin;
    }
}

export interface nfcreaderPlugin {
    echo(options: { value: string }): Promise<{ value: string }>;
    ReadNFCTag(options: { msg: string }): Promise<{ value: string }>;
    WriteNFCTag(number: number): Promise<{ value: number }>;
    startNfcReading(data: any): Promise<any>;
    stopNfcReading(data: any): Promise<any>;
    setNfcDataCallback(data: any): Promise<any>;
}
