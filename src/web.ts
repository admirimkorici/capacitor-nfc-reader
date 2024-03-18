import { WebPlugin } from '@capacitor/core';

import type { nfcreaderPlugin } from './definitions';

export class nfcreaderWeb extends WebPlugin implements nfcreaderPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

    async writeNfcTag(options: { data: string }): Promise<{ value: string }> {
        return { value: options.data };
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
