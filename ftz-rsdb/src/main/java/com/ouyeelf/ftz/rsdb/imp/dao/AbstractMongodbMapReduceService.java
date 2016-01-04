package com.ouyeelf.ftz.rsdb.imp.dao;

import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;

/**
 * The Class AbstractMongodbMapReduceService.
 */
public abstract class AbstractMongodbMapReduceService
    implements IMongodbMapReduceService {
    
    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.IMongodbMapReduceService#mapReduce()
     */
    public void mapReduce() throws ResourceException {
        this.mapReduce(false);
    }

    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.IMongodbMapReduceService#mapReduce(boolean)
     */
    public void mapReduce(boolean verbose) throws ResourceException {
        this.handleSl2MapReduce();
        this.handleDLMapReduce();
    }

    /**
     * Handle dl map reduce.
     *
     * @throws ResourceException the resource exception
     */
    abstract public void handleDLMapReduce() throws ResourceException;

    /**
     * Handle sl2 map reduce.
     *
     * @throws ResourceException the resource exception
     */
    abstract public void handleSl2MapReduce() throws ResourceException;
}
