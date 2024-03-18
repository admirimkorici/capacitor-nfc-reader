var capacitornfcreader = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
