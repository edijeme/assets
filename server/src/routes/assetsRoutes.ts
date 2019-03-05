import { Router } from 'express';

import assetsCtrls from '../controllers/assetsCtrls';
class AssestsRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    config(): void {
        this.router.get('/', assetsCtrls.list);
        this.router.get('/:id', assetsCtrls.search);
        this.router.post('/', assetsCtrls.create);
        this.router.put('/:id', assetsCtrls.update);
    }
}

const assestsRoutes = new AssestsRoutes();
export default assestsRoutes.router;