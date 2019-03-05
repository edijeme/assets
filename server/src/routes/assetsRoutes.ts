import { Router } from 'express';

import assetsCtrls from '../controllers/assetsCtrls';
class AssestsRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    config(): void {
        this.router.get('/', assetsCtrls.index);
    }
}

const assestsRoutes = new AssestsRoutes();
export default assestsRoutes.router;