package com.jay.bulkdemo;

import com.jay.bulkdemo.dao.BulkTaskDao;
import com.jay.bulkdemo.dao.BulkTaskInfo;

import java.util.Date;
import java.util.TimerTask;

/**
 * 定时更新info 表的TimerTask
 *
 * @author jay
 * @create 2019-11-15 9:32
 **/

public class ImpTimerTask extends TimerTask {

    //  批量任务id
    private String bulkTaskId;

    public ImpTimerTask(String bulkTaskId) {
        this.bulkTaskId = bulkTaskId;
    }

    @Override
    public void run() {
        //  定时查询当前节点的增量 解析数量，并将增量数据update 到 信息表，并根据返回的status 判断是否停止当前的任务
        BulkTaskProcIncInfo info = BulkTaskCounter.getInstance().getAndClearBulkTaskProcIncInfo(bulkTaskId);
        Integer status = null;
        if (0 < info.getSuccCount()) {
            status = BulkTaskDao.updateBulkTaskInfo(buildBulkTaskInfo(1, info.getSuccCount()));
        }
        if (0 < info.getErrCount()) {
            status = BulkTaskDao.updateBulkTaskInfo(buildBulkTaskInfo(0, info.getErrCount()));
        }
        if (0 < info.getInvalidCount()) {
            status = BulkTaskDao.updateBulkTaskInfo(buildBulkTaskInfo(2, info.getInvalidCount()));
        }
        //  主表状态已完成或者是异常,停止timer任务,删除计数器
        if (1 == status || 2 == status) {
            BulkTaskCounter.getInstance().closeTimer(bulkTaskId);
            BulkTaskCounter.getInstance().deleteBulkTaskProcIncInfo(bulkTaskId);
        }
    }

    private BulkTaskInfo buildBulkTaskInfo(Integer status, Integer count) {
        BulkTaskInfo bulkTaskInfo = new BulkTaskInfo();
        bulkTaskInfo.setCount(count);
        bulkTaskInfo.setStatus(status);
        bulkTaskInfo.setBulkTaskId(bulkTaskId);
        bulkTaskInfo.setLastUpdateTime(new Date());
        return bulkTaskInfo;
    }
}
