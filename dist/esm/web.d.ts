import { WebPlugin } from '@capacitor/core';
import type { nfcreaderPlugin } from './definitions';
export declare class nfcreaderWeb extends WebPlugin implements nfcreaderPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    ReadNFCTag(options: {
        msg: string;
    }): Promise<{
        value: string;
    }>;
    WriteNFCTag(number: number): Promise<{
        value: number;
    }>;
}
