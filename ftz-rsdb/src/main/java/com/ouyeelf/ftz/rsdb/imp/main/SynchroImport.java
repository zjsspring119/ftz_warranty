package com.ouyeelf.ftz.rsdb.imp.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.dao.WarrantyBeanDao;
import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;


public class SynchroImport<T> extends Thread {
    private final static int BATCH = 1000; //批量插入条数
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private IByteBuffer<T> rbb;
    private Operation operation;
    private NSynchroImport<T> ns;
    private List<WarrantyBean> list = new ArrayList<WarrantyBean>();

    public SynchroImport(IByteBuffer<T> rbb, Operation operation,
        NSynchroImport<T> ns) {
        this.rbb = rbb;
        this.operation = operation;
        this.ns = ns;
    }

    public void run() {
        List<String> unsuccessful = new ArrayList<String>();
        List<String> successful = new ArrayList<String>();
        boolean bool = true;
        WarrantyBeanDao warrantyBeanDao = new WarrantyBeanDao();
        logger.info("chuck {} is running", Thread.currentThread().getName());

        try {
            rbb.flip();
            warrantyBeanDao.start();

            switch (operation) {
            case INSERT:

                while (rbb.hasRemaining()) {
                	WarrantyBean res = (WarrantyBean) rbb.get();
                    list.add(res);

                    if (list.size() >= BATCH) {
                        bool = warrantyBeanDao.addResourceAll(list);

                        if (!bool) {
                            for (WarrantyBean res2 : list) {
                                unsuccessful.add(res2.getWarrantyNo());
                            }
                        } else {
                            for (WarrantyBean res2 : list) {
                                successful.add(res2.getWarrantyNo());
                            }
                        }

                        list.clear();
                    }
                }

                if (list.size() > 0) {
                    bool = warrantyBeanDao.addResourceAll(list);

                    if (!bool) {
                        for (WarrantyBean res2 : list) {
                            unsuccessful.add(res2.getWarrantyNo());
                        }
                    } else {
                        for (WarrantyBean res2 : list) {
                            successful.add(res2.getWarrantyNo());
                        }
                    }

                    list.clear();
                }

                break;

            case REMOVE:

                while (rbb.hasRemaining()) {
                	WarrantyBean res = (WarrantyBean) rbb.get();
                    bool = warrantyBeanDao.removeResourcePhysics(res);

                    if (!bool) {
                        unsuccessful.add(res.getWarrantyNo());
                    } else {
                        successful.add(res.getWarrantyNo());
                    }
                }

                break;

            case UPDATE:

                while (rbb.hasRemaining()) {
                	WarrantyBean res = (WarrantyBean) rbb.get();
                    bool = warrantyBeanDao.updateResource(res);

                    if (!bool) {
                        unsuccessful.add(res.getWarrantyNo());
                    } else {
                        successful.add(res.getWarrantyNo());
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
        	warrantyBeanDao.done();
            rbb.clear();
            ns.callBack(unsuccessful, successful);
            logger.info("chuck {} is completed",
                Thread.currentThread().getName());
        }
    }
}
