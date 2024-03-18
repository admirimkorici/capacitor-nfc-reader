import { WebPlugin } from '@capacitor/core';
import type { nfcreaderPlugin } from './definitions';
export declare class nfcreaderWeb extends WebPlugin implements nfcreaderPlugin {
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
