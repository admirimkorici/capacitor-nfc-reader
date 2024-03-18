import { WebPlugin } from '@capacitor/core';
export class nfcreaderWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async writeNfcTag(options) {
        return { value: options.data };
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