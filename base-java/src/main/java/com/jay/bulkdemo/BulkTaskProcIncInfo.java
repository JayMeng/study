package com.jay.bulkdemo;

import java.util.Timer;

/**
 * 批量任务增量执行信息
 *
 * @author jay
 * @create 2019-11-06 9:48
 **/

public class BulkTaskProcIncInfo {

    private String bulkTaskId;

    private Timer timer;

    // 成功数量
    private Integer succCount = 0;

    //  失败数量
    private Integer errCount = 0;

    //  非法数据数量
    private Integer invalidCount = 0;

    public String getBulkTaskId() {
        return bulkTaskId;
    }

    public void setBulkTaskId(String bulkTaskId) {
        this.bulkTaskId = bulkTaskId;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Integer getSuccCount() {
        return succCount;
    }

    public void setSuccCount(Integer succCount) {
        this.succCount = succCount;
    }

    public Integer getErrCount() {
        return errCount;
    }

    public void setErrCount(Integer errCount) {
        this.errCount = errCount;
    }

    public Integer getInvalidCount() {
        return invalidCount;
    }

    public void setInvalidCount(Integer invalidCount) {
        this.invalidCount = invalidCount;
    }
}
