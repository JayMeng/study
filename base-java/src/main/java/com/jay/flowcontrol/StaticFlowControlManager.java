package com.jay.flowcontrol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态流控管理器
 *
 * @author jay
 * @create 2019-11-15 15:26
 **/

public final class StaticFlowControlManager {

    private static StaticFlowControlManager instance = new StaticFlowControlManager();

    //  静态流控的tps阈值.TODO 可扩展为每个api 对应自己的阈值
    private static Integer tpsThreshold = 100;

    // 流控计数器
    private Map<String, Integer> flowCtrlCounter = new ConcurrentHashMap<>();

    //  上次执行静态流控的时间 ，System.currentTimeMills/1000
    private long lastExexTime = 0;

    private StaticFlowControlManager() {

    }

    public static StaticFlowControlManager getInstance() {
        return instance;
    }

    /**
     * @return java.lang.Boolean
     * @Author mj
     * @Description 是否静态流控
     * @Date 2019/11/15 16:04
     * @Param []
     **/
    public synchronized Boolean staticFlowCtrl(String path, String methodName) {
        long currentTime = System.currentTimeMillis() / 1000;
        checkTimeInterval(currentTime);
        String apiName = path + "." + methodName;
        //  判断是否达到阈值
        boolean isReachThreshold = isTpsCountReachThreshold(apiName, tpsThreshold);
        return isReachThreshold;
    }

    /**
     * @return boolean
     * @Author mj
     * @Description 计算判断TPS值是否已达到阈值，如果该api的TPS累积值小于阈值，则累积计数器/如果该api的TPS累积值大于等于阈值，则报错
     * @Date 2019/11/15 16:15
     * @Param [apiName, tpsThreshold]
     **/
    private boolean isTpsCountReachThreshold(String apiName, Integer tpsThreshold) {
        Integer tpsCount = flowCtrlCounter.get(apiName);
        tpsCount = null == tpsCount ? 0 : tpsCount;
        if (tpsCount < tpsThreshold) {
            tpsCount++;
            flowCtrlCounter.put(apiName, tpsCount);
            return false;
        } else {
            System.out.println("The tps of " + apiName + "reach the Threshold, The threshold is " + tpsThreshold);
            return true;
        }
    }

    /**
     * @return void
     * @Author mj
     * @Description 若当前时间与上次执行时间间隔超过1秒，则清空静态流控计数器，并更新lastExecTime
     * @Date 2019/11/15 16:23
     * @Param [currentTime]
     **/
    private void checkTimeInterval(long currentTime) {
        if ((currentTime - lastExexTime) >= 1) {
            flowCtrlCounter.clear();
            lastExexTime = currentTime;
        }
    }
}
