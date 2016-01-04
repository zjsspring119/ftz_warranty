package com.ouyeelf.ftz.rsdb.imp.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.model.mdbean.WarrantySearchHisBean;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.dao.WarrantySearchHisBeanDao;
import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;


public class SynImportWarrantySearchHis<T> extends Thread {
    private final static int BATCH = 1000; //批量插入条数
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private IByteBuffer<T> rbb;
    private Operation operation;
    private NSynchroImport<T> ns;
    private List<WarrantySearchHisBean> list = new ArrayList<WarrantySearchHisBean>();

    public SynImportWarrantySearchHis(IByteBuffer<T> rbb, Operation operation,
        NSynchroImport<T> ns) {
        this.rbb = rbb;
        this.operation = operation;
        this.ns = ns;
    }

    public void run() {
        List<String> unsuccessful = new ArrayList<String>();
        List<String> successful = new ArrayList<String>();
        boolean bool = true;
        WarrantySearchHisBeanDao warrantySearchHisBeanDao = new WarrantySearchHisBeanDao();
        logger.info("chuck {} is running", Thread.currentThread().getName());

        try {
            rbb.flip();
            warrantySearchHisBeanDao.start();

            switch (operation) {
            case INSERT:

                while (rbb.hasRemaining()) {
                	WarrantySearchHisBean res = (WarrantySearchHisBean) rbb.get();
                    list.add(res);

                    if (list.size() >= BATCH) {
                        bool = warrantySearchHisBeanDao.addResourceAll(list);

                        if (!bool) {
                            for (WarrantySearchHisBean res2 : list) {
                                unsuccessful.add(res2.getId());
                            }
                        } else {
                            for (WarrantySearchHisBean res2 : list) {
                                successful.add(res2.getId());
                            }
                        }

                        list.clear();
                    }
                }

                if (list.size() > 0) {
                    bool = warrantySearchHisBeanDao.addResourceAll(list);

                    if (!bool) {
                        for (WarrantySearchHisBean res2 : list) {
                            unsuccessful.add(res2.getId());
                        }
                    } else {
                        for (WarrantySearchHisBean res2 : list) {
                            successful.add(res2.getId());
                        }
                    }

                    list.clear();
                }

                break;

            case REMOVE:

                while (rbb.hasRemaining()) {
                	WarrantySearchHisBean res = (WarrantySearchHisBean) rbb.get();
                    bool = warrantySearchHisBeanDao.removeResourcePhysics(res);

                    if (!bool) {
                        unsuccessful.add(res.getId());
                    } else {
                        successful.add(res.getId());
                    }
                }

                break;

            case UPDATE:

                while (rbb.hasRemaining()) {
                	WarrantySearchHisBean res = (WarrantySearchHisBean) rbb.get();
                    bool = warrantySearchHisBeanDao.updateResource(res);

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
        	warrantySearchHisBeanDao.done();
            rbb.clear();
            ns.callBack(unsuccessful, successful);
            logger.info("chuck {} is completed",
                Thread.currentThread().getName());
        }
    }
}
