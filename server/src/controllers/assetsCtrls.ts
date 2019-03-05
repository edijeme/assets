import { Request, Response } from 'express';
import pool from '../database';
import { request } from 'http';

class AsstesCtrls {

    public list(req: Request, res: Response) {
        res.send('list')
    }

    public search(req: Request, res: Response) {
        res.send('search')
    }

    public create(req: Request, res: Response) {
        res.json({ code: 200, text: 'create' });
    }

    public update(req: Request, res: Response) {
        req.params.id;
        res.json({ code: 200, text: 'update' });
    }
}

const asstesCtrls = new AsstesCtrls();
export default asstesCtrls;