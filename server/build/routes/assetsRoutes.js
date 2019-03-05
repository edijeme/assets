"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const assetsCtrls_1 = __importDefault(require("../controllers/assetsCtrls"));
class AssestsRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', assetsCtrls_1.default.list);
        this.router.get('/:id', assetsCtrls_1.default.search);
        this.router.post('/', assetsCtrls_1.default.create);
        this.router.put('/:id', assetsCtrls_1.default.update);
    }
}
const assestsRoutes = new AssestsRoutes();
exports.default = assestsRoutes.router;
