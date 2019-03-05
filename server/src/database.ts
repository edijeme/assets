import mysql from 'promise-mysql';
import keys from './keys';

const pool = mysql.createPool(keys.datbase);

pool.getConnection().then(connection => {
    pool.releaseConnection(connection);
    console.log('DB ON');
});

export default pool;