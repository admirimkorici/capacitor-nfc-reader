declare module "@capacitor/core" {
    interface PluginRegistry {
        NFCTagReader: nfcreaderPlugin;
    }
}

export interface nfcreaderPlugin {
    echo(options: { value: string }): Promise<{ value: string }>;
    ReadNFCTag(options: { msg: string }): Promise<{ value: string }>;
    WriteNFCTag(number: number): Promise<{ value: number }>;
}
