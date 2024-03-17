import { WebPlugin } from '@capacitor/core';

import type { nfcreaderPlugin } from './definitions';

export class nfcreaderWeb extends WebPlugin implements nfcreaderPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

    async ReadNFCTag(options: { msg: string }): Promise<{ value: string }> {
        return { value: options.msg };
    }

    async WriteNFCTag(number: number): Promise<{ value: number }> {
        return { value: number };
    }

    async startNfcReading(data: any): Promise<any> {
        return data;
    }

    async stopNfcReading(data: any): Promise<any> {
        return data;
    }

    async setNfcDataCallback(data: any): Promise<any> {
        return data;
    }
}
