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
    }
    async startNfcReading(data) {
        return data;
    }
    async stopNfcReading(data) {
        return data;
    }
    async setNfcDataCallback(data) {
        return data;
    }
}
//# sourceMappingURL=web.js.map