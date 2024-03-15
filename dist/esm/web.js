import { WebPlugin } from '@capacitor/core';
export class nfcreaderWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async ReadNFCTag(options) {
        return { value: options.msg };
    }
    async WriteNFCTag(number) {
        return { value: number };
        ;
    }
}
//# sourceMappingURL=web.js.map