import { WebPlugin } from '@capacitor/core';

import type { nfcreaderPlugin } from './definitions';

export class nfcreaderWeb extends WebPlugin implements nfcreaderPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
