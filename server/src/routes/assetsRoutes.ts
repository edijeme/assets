import { Router } from 'express';

class AssestsRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    config(): void {
        this.router.get('/', (req, res) => res.send('AssestsRoutes'));
    }
}

const assestsRoutes = new AssestsRoutes();
export default assestsRoutes.router;