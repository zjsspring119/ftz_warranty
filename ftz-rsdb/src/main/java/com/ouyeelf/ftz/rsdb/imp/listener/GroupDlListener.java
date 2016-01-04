package com.ouyeelf.ftz.rsdb.imp.listener;

import java.util.EventListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.rsdb.imp.event.GroupDlEvent;


public class GroupDlListener implements EventListener {
    private final static ReentrantLock lock = new ReentrantLock();
    private static GroupDlListener groupDlListener;
    private AtomicInteger counter = new AtomicInteger(1);
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private volatile boolean isRunning = false;

    public static GroupDlListener getInstance() {
        if (null == groupDlListener) {
            try {
                lock.lock();

                if (null == groupDlListener) {
                    groupDlListener = new GroupDlListener();
                }
            } finally {
                lock.unlock();
            }
        }

        return groupDlListener;
    }

    // 这里是当事件发生后的响应过程
    public void EventActivated(GroupDlEvent me) {
        try {
            lock.lock();

            if (isRunning) {
                counter.incrementAndGet();

                if (logger.isInfoEnabled()) {
                    logger.info("wait...................." + counter.get());
                }

                return;
            }

            isRunning = true;
        } finally {
            lock.unlock();
        }

        try {
            while (true) {
                Thread.sleep(100);
                counter.set(0);

                if (logger.isInfoEnabled()) {
                    logger.info("execute....................start");
                }

                /**统计相同资源号下面的吨位数*/
//                WarrantyDao warrantyDao = new WarrantyDao();
//                warrantyDao.executeMapReduce();

                try {
                    lock.lock();

                    if (counter.get() == 0) {
                        isRunning = false;

                        break;
                    }
                } finally {
                    lock.unlock();
                }
            }

            if (logger.isInfoEnabled()) {
                logger.info("execute....................end");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            isRunning = false;
        }
    }
}
