"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class AsstesCtrls {
    list(req, res) {
        res.send('list');
    }
    search(req, res) {
        res.send('search');
    }
    create(req, res) {
        res.json({ code: 200, text: 'create' });
    }
    update(req, res) {
        req.params.id;
        res.json({ code: 200, text: 'update' });
    }
}
const asstesCtrls = new AsstesCtrls();
exports.default = asstesCtrls;
