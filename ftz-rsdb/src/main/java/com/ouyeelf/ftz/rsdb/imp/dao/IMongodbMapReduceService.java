package com.ouyeelf.ftz.rsdb.imp.dao;

import com.mongodb.DB;
import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;


/**
 * The Interface IMongodbMapReduceService.
 */
public interface IMongodbMapReduceService {
    
    /**
     * Gets the source coll ection name.
     *
     * @return the source coll ection name
     */
    public String getSourceCollEctionName();

    /**
     * Gets the target collection name.
     *
     * @return the target collection name
     */
    public String getTargetCollectionName();

    /**
     * Gets the db.
     *
     * @return the db
     */
    public DB getDB();

    /**
     * Map reduce.
     *
     * @param verbose the verbose
     * @throws ResourceException the resource exception
     */
    public void mapReduce(boolean verbose) throws ResourceException;

    /**
     * Map reduce.
     *
     * @throws ResourceException the resource exception
     */
    public void mapReduce() throws ResourceException;
}
