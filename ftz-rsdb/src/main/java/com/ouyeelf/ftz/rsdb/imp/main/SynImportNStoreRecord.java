package com.ouyeelf.ftz.rsdb.imp.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.model.mdbean.NStoreRecordBean;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.dao.NStoreRecordBeanDao;
import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;


public class SynImportNStoreRecord<T> extends Thread {
    private final static int BATCH = 1000; //批量插入条数
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private IByteBuffer<T> rbb;
    private Operation operation;
    private NSynchroImport<T> ns;
    private List<NStoreRecordBean> list = new ArrayList<NStoreRecordBean>();

    public SynImportNStoreRecord(IByteBuffer<T> rbb, Operation operation,
        NSynchroImport<T> ns) {
        this.rbb = rbb;
        this.operation = operation;
        this.ns = ns;
    }

    public void run() {
        List<String> unsuccessful = new ArrayList<String>();
        List<String> successful = new ArrayList<String>();
        boolean bool = true;
        NStoreRecordBeanDao nStoreRecordBeanDao = new NStoreRecordBeanDao();
        logger.info("chuck {} is running", Thread.currentThread().getName());

        try {
            rbb.flip();
            nStoreRecordBeanDao.start();

            switch (operation) {
            case INSERT:

                while (rbb.hasRemaining()) {
                	NStoreRecordBean res = (NStoreRecordBean) rbb.get();
                    list.add(res);

                    if (list.size() >= BATCH) {
                        bool = nStoreRecordBeanDao.addResourceAll(list);

                        if (!bool) {
                            for (NStoreRecordBean res2 : list) {
                                unsuccessful.add(res2.getId());
                            }
                        } else {
                            for (NStoreRecordBean res2 : list) {
                                successful.add(res2.getId());
                            }
                        }

                        list.clear();
                    }
                }

                if (list.size() > 0) {
                    bool = nStoreRecordBeanDao.addResourceAll(list);

                    if (!bool) {
                        for (NStoreRecordBean res2 : list) {
                            unsuccessful.add(res2.getId());
                        }
                    } else {
                        for (NStoreRecordBean res2 : list) {
                            successful.add(res2.getId());
                        }
                    }

                    list.clear();
                }

                break;

            case REMOVE:

                while (rbb.hasRemaining()) {
                	NStoreRecordBean res = (NStoreRecordBean) rbb.get();
                    bool = nStoreRecordBeanDao.removeResourcePhysics(res);

                    if (!bool) {
                        unsuccessful.add(res.getId());
                    } else {
                        successful.add(res.getId());
                    }
                }

                break;

            case UPDATE:

                while (rbb.hasRemaining()) {
                	NStoreRecordBean res = (NStoreRecordBean) rbb.get();
                    bool = nStoreRecordBeanDao.updateResource(res);

                    if (!bool) {
                        unsuccessful.add(res.getId());
                    } else {
                        successful.add(res.getId());
                    }
                }

                break;

            default:
                throw new ResourceException("unsupported operation: " +
                    operation);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
        	nStoreRecordBeanDao.done();
            rbb.clear();
            ns.callBack(unsuccessful, successful);
            logger.info("chuck {} is completed",
                Thread.currentThread().getName());
        }
    }
}
