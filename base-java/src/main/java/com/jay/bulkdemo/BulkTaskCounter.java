package com.jay.bulkdemo;

import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 批量任务单例计数器,每个节点都一个单例 增量计数器。
 * ( 饿汉式 )
 *
 * @author jay
 * @create 2019-11-15 9:06
 **/

public class BulkTaskCounter {

    private static final BulkTaskCounter instance = new BulkTaskCounter();

    private Map<String, BulkTaskProcIncInfo> bulkTaskProcCounter = new ConcurrentHashMap<>();

    private static Object lock = new Object();

    private BulkTaskCounter() {
    }

    public static BulkTaskCounter getInstance() {
        return instance;
    }

    public void addSuccCount(String bulkTaskId) {
        synchronized (lock) {
            BulkTaskProcIncInfo info = bulkTaskProcCounter.get(bulkTaskId);
            if (null == info) {
                info = initBulkTaskProcIncInfo(bulkTaskId);
                bulkTaskProcCounter.put(bulkTaskId, info);
            }
            info.setSuccCount(info.getSuccCount() + 1);
        }
    }


    public void addErrCount(String bulkTaskId) {
        synchronized (lock) {
            BulkTaskProcIncInfo info = bulkTaskProcCounter.get(bulkTaskId);
            if (null == info) {
                info = initBulkTaskProcIncInfo(bulkTaskId);
                bulkTaskProcCounter.put(bulkTaskId, info);
            }
            info.setErrCount(info.getErrCount() + 1);
        }
    }

    public void addInvalidCount(String bulkTaskId) {
        synchronized (lock) {
            BulkTaskProcIncInfo info = bulkTaskProcCounter.get(bulkTaskId);
            if (null == info) {
                info = initBulkTaskProcIncInfo(bulkTaskId);
                bulkTaskProcCounter.put(bulkTaskId, info);
            }
            info.setErrCount(info.getInvalidCount() + 1);
        }
    }

    public void deleteBulkTaskProcIncInfo(String bulkTaskId) {
        synchronized (lock) {
            bulkTaskProcCounter.remove(bulkTaskId);
        }
    }

    public void closeTimer(String bulkTaskId) {
        BulkTaskProcIncInfo info = bulkTaskProcCounter.get(bulkTaskId);
        if (null != info) {
            Timer timer = info.getTimer();
            if (null != timer) {
                timer.cancel();
            }
        }
    }


    public BulkTaskProcIncInfo getAndClearBulkTaskProcIncInfo(String bulkTaskId) {
        synchronized (lock) {
            BulkTaskProcIncInfo info = bulkTaskProcCounter.get(bulkTaskId);
            BulkTaskProcIncInfo newInfo = new BulkTaskProcIncInfo();
            if (null != info) {
                newInfo.setSuccCount(info.getSuccCount());
                newInfo.setErrCount(info.getErrCount());
                //  timerTask调用改方法后，后续可能会继续增加count，若手动清除可能会发生问题（多清除数据），故取完直接清0,TODO 此处是精华
                info.setSuccCount(0);
                info.setErrCount(0);
            }
            return newInfo;
        }
    }


    public BulkTaskProcIncInfo initBulkTaskProcIncInfo(String bulkTaskId) {
        BulkTaskProcIncInfo info = new BulkTaskProcIncInfo();
        Timer timer = new Timer();
        // 设置TimerTask，TODO 此处考虑替换成sheludTimerTask
        ImpTimerTask timerTask = new ImpTimerTask(bulkTaskId);
        // 启动Timer,5s 后执行，每隔10s 执行
        timer.schedule(timerTask, 5000L, 10000L);
        info.setTimer(timer);
        return info;
    }
}
