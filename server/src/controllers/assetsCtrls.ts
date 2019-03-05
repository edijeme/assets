import { Request, Response } from 'express';
import pool from '../database';
class AsstesCtrls {
    public index(req: Request, res: Response) {
        pool.query('SELECT * FROM city');
        res.send('CRUS')
    }
}

const asstesCtrls = new AsstesCtrls();
export default asstesCtrls;