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
    async checkNfcAvailability(options) {
        return { available: options.available };
    }
    async readNfcTag(options) {
        return { data: options.data };
    }
}
//# sourceMappingURL=web.js.map