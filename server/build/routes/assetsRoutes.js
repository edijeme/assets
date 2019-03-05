"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
class AssestsRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', (req, res) => res.send('AssestsRoutes'));
    }
}
const assestsRoutes = new AssestsRoutes();
exports.default = assestsRoutes.router;
