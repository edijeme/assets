import { Router } from 'express';

import indexCtrls from '../controllers/indexCtrls';

class IndexRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    config(): void {
        this.router.get('/', indexCtrls.index);
    }
}

const indexRoutes = new IndexRoutes();
export default indexRoutes.router;