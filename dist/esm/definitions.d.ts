declare module "@capacitor/core" {
    interface PluginRegistry {
        NFCTagReader: nfcreaderPlugin;
    }
}
export interface nfcreaderPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    writeNfcTag(options: {
        data: string;
    }): Promise<{
        value: string;
    }>;
    startNfcReading(data: any): Promise<any>;
    stopNfcReading(data: any): Promise<any>;
    setNfcDataCallback(data: any): Promise<any>;
}
