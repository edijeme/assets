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
        this.router.get('/', assetsCtrls_1.default.index);
    }
}
const assestsRoutes = new AssestsRoutes();
exports.default = assestsRoutes.router;
