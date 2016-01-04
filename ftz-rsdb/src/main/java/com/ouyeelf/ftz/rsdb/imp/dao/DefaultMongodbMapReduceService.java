package com.ouyeelf.ftz.rsdb.imp.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.QueryBuilder;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;
import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;
import com.ouyeelf.ftz.rsdb.imp.utils.IOUtils;


/**
 * The Class DefaultMongodbMapReduceService.
 */
public class DefaultMongodbMapReduceService
    extends AbstractMongodbMapReduceService {
    
    /** The Constant logger. */
    private static final Log logger = LogFactory.getLog(DefaultMongodbMapReduceService.class);
    
    /** The Constant DEFAULT_GROUP_BY. */
    public final static String DEFAULT_GROUP_BY = "Group";
    
    /** The Constant DEFAULT_SL2_MAP_SCRIPT. */
    public final static String DEFAULT_SL2_MAP_SCRIPT = "sl2-map.js";
    
    /** The Constant DEFAULT_SL2_REDUCE_SCRIPT. */
    public final static String DEFAULT_SL2_REDUCE_SCRIPT = "sl2-reduce.js";
    
    /** The Constant DEFAULT_SL2_FINALIZE_SCRIPT. */
    public final static String DEFAULT_SL2_FINALIZE_SCRIPT = "sl2-finalize.js";
    
    /** The Constant DEFAULT_DL_MAP_SCRIPT. */
    public final static String DEFAULT_DL_MAP_SCRIPT = "dl-map.js";
    
    /** The Constant DEFAULT_DL_REDUCE_SCRIPT. */
    public final static String DEFAULT_DL_REDUCE_SCRIPT = "dl-reduce.js";
    
    /** The Constant DEFAULT_DL_FINALIZE_SCRIPT. */
    public final static String DEFAULT_DL_FINALIZE_SCRIPT = "dl-finalize.js";
    
    /** The Constant DEFAULT_SOURCE_COLLECTION_NAME. */
    public final static String DEFAULT_SOURCE_COLLECTION_NAME = "Resource";
    
    /** The Constant DEFAULT_SL2_TARGET_COLLECTION_NAME. */
    public final static String DEFAULT_SL2_TARGET_COLLECTION_NAME = "SL2" +
        DEFAULT_GROUP_BY;
    
    /** The Constant DEFAULT_DL_TARGET_COLLECTION_NAME. */
    public final static String DEFAULT_DL_TARGET_COLLECTION_NAME = "DL" +
        DEFAULT_GROUP_BY;
    
    /** The processing number. */
    private int processingNumber=0;
    
    /** The db. */
    private DB db;
    
    /** The verbose. */
    private boolean verbose;

    /**
     * Instantiates a new default mongodb map reduce service.
     *
     * @param db the db
     */
    public DefaultMongodbMapReduceService(DB db) {
        this.db = db;
    }

    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.IMongodbMapReduceService#getSourceCollEctionName()
     */
    public String getSourceCollEctionName() {
        return DEFAULT_SOURCE_COLLECTION_NAME;
    }

    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.IMongodbMapReduceService#getTargetCollectionName()
     */
    public String getTargetCollectionName() {
        return DEFAULT_DL_TARGET_COLLECTION_NAME;
    }

    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.IMongodbMapReduceService#getDB()
     */
    public DB getDB() {
        return db;
    }

    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.AbstractMongodbMapReduceService#handleDLMapReduce()
     */
    public void handleDLMapReduce() throws ResourceException {
        DBCollection collection = getDB()
                                      .getCollection(DEFAULT_SOURCE_COLLECTION_NAME);

        MapReduceCommand cmd = new MapReduceCommand(collection,
                buildMap(DEFAULT_DL_MAP_SCRIPT),
                buildReduce(DEFAULT_DL_REDUCE_SCRIPT),
                DEFAULT_DL_TARGET_COLLECTION_NAME,
                MapReduceCommand.OutputType.MERGE, null);
        cmd.setVerbose(verbose);
        cmd.setFinalize(buildFinalizefun(DEFAULT_DL_FINALIZE_SCRIPT));
        cmd.setReadPreference(ReadPreference.secondaryPreferred());

        MapReduceOutput out = collection.mapReduce(cmd);

        if (logger.isInfoEnabled()) {
            for (DBObject o : out.results()) {
                logger.info(o.toString());
            }
        }
    }

    /* (non-Javadoc)
     * @see com.bsteel.pacific.imp.dao.AbstractMongodbMapReduceService#handleSl2MapReduce()
     */
    public void handleSl2MapReduce() throws ResourceException {
        DBCollection collection = getDB()
                                      .getCollection(DEFAULT_SOURCE_COLLECTION_NAME);
        MapReduceCommand cmd = new MapReduceCommand(collection,
                buildMap(DEFAULT_SL2_MAP_SCRIPT),
                buildReduce(DEFAULT_SL2_REDUCE_SCRIPT),
                DEFAULT_SL2_TARGET_COLLECTION_NAME,
                MapReduceCommand.OutputType.INLINE, null);
        cmd.setFinalize(buildFinalizefun(DEFAULT_SL2_FINALIZE_SCRIPT));
        cmd.setVerbose(verbose);
        cmd.setReadPreference(ReadPreference.secondaryPreferred());

        MapReduceOutput out = collection.mapReduce(cmd);
        String idKey = "_id";
        String zyhId="zyh";
        String valueKey = "value";
        String asscustomerIdKey="asscustomerId";
        String flag1key="flag1";
        String zyhsResourceKey = "zyhsResource";

        if (logger.isInfoEnabled()) {
            for (DBObject o : out.results()) {
                logger.info(o.toString());
            }
        }

        for (DBObject o : out.results()) {
            if (o.containsField(idKey) && o.containsField(valueKey)) {
            	BasicDBObject key= (BasicDBObject)o.get(idKey);
                String zyh = (String) key.get(zyhId);
                String asscustomerId = (String) key.get(asscustomerIdKey);
                String flag1=(String)key.get(flag1key);
                BasicDBObject zysResource = (BasicDBObject) o.get(valueKey);
                BasicDBList zyhsResource = (BasicDBList) zysResource.get(zyhsResourceKey);
                updateResourceRelatedByZYH(zyh,asscustomerId,flag1, zyhsResource);
            }
        }
        if (logger.isInfoEnabled()) {
        	logger.info("MapReduce is Number of processing----------:"+processingNumber);
        }
        
    }

    /**
     * Update resource related by zyh.
     *
     * @param zyh the zyh
     * @param asscustomerId the asscustomer id
     * @param flag1 the flag1
     * @param sl2s the sl2s
     */
    public void updateResourceRelatedByZYH(String zyh, String asscustomerId,String flag1,BasicDBList sl2s) {
        DBObject query = new BasicDBObject();
        query.put("zyh", zyh);
        query.put("flag1",flag1);
        query.put("asscustomerId", asscustomerId);
        DBObject update = new BasicDBObject();
        update.put("zyhResource", sl2s);

        DBObject updateValue = new BasicDBObject("$set", update);
        WriteResult wr=getDB().getCollection(DEFAULT_SOURCE_COLLECTION_NAME)
            .update(query, updateValue, false, true);
        
        if (logger.isInfoEnabled()) {
            logger.info(zyh+":update resource............size."+sl2s.size()+";sl2s:" + sl2s+";number:"+wr.getN());
        }
        processingNumber+=wr.getN();
    }

    /**
     * Builds the map.
     *
     * @param scriptFileName the script file name
     * @return the string
     * @throws ResourceException the resource exception
     */
    public static String buildMap(String scriptFileName)
    		throws ResourceException {
        return readScriptForFileName(scriptFileName);
    }

    /**
     * Builds the reduce.
     *
     * @param scriptFileName the script file name
     * @return the string
     * @throws ResourceException the resource exception
     */
    public static String buildReduce(String scriptFileName)
    		throws ResourceException {
        return readScriptForFileName(scriptFileName);
    }

    /**
     * Builds the finalizefun.
     *
     * @param scriptFileName the script file name
     * @return the string
     * @throws ResourceException the resource exception
     */
    public static String buildFinalizefun(String scriptFileName)
    		throws ResourceException {
        return readScriptForFileName(scriptFileName);
    }

    /**
     * Builds the query.
     *
     * @return the dB object
     */
    @Deprecated
    public static DBObject buildQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        DBObject query = queryBuilder.or(new BasicDBObject("mark", "new"),
                new BasicDBObject("mark", "delete")).get();

        return query;
    }

    /**
     * Read script for file name.
     *
     * @param fileName the file name
     * @return the string
     * @throws ResourceException the resource exception
     */
    private static String readScriptForFileName(String fileName)
    		throws ResourceException {
        ClassLoader loader = DefaultMongodbMapReduceService.class.getClassLoader();

        if (loader == null) {
            loader = Thread.currentThread().getContextClassLoader();
        }

        InputStream in = loader.getResourceAsStream(
                "com/bsteel/pacific/imp/utils/script/" + fileName);

        try {
            return IOUtils.toString(in, "UTF-8");
        } catch (IOException e) {
            logger.error("readScriptForFileName Execution failed fileName:" +
                fileName, e);
        }

        throw new ResourceException();
    }
}
