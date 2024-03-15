import { registerPlugin } from '@capacitor/core';

import type { nfcreaderPlugin } from './definitions';

const nfcreader = registerPlugin<nfcreaderPlugin>('nfcreader', {
  web: () => import('./web').then(m => new m.nfcreaderWeb()),
});

export * from './definitions';
export { nfcreader };
