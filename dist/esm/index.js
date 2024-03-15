import { registerPlugin } from '@capacitor/core';
const nfcreader = registerPlugin('nfcreader', {
    web: () => import('./web').then(m => new m.nfcreaderWeb()),
});
export * from './definitions';
export { nfcreader };
//# sourceMappingURL=index.js.map