import { Request, Response } from 'express';

class IndexCtrls {
    public index(req: Request, res: Response) {
        res.json({ text: 'asdasd' })
    }
}

const indexCtrls = new IndexCtrls();
export default indexCtrls;