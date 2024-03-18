'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

core.registerPlugin("nfcreader");

const nfcreader = core.registerPlugin('nfcreader', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.nfcreaderWeb()),
});

class nfcreaderWeb extends core.WebPlugin {
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

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    nfcreaderWeb: nfcreaderWeb
});

exports.nfcreader = nfcreader;
//# sourceMappingURL=plugin.cjs.js.map
