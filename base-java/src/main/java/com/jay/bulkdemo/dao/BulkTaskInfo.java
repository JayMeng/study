package com.jay.bulkdemo.dao;

import java.util.Date;

/**
 * 批量任务详情信息
 *
 * @author jay
 * @create 2019-11-06 9:48
 **/

public class BulkTaskInfo {

    private String bulkTaskId;

    // 成功数量
    private Integer count;

    //  1 成功，0 失败，2非法数据
    private Integer status;

    //  最后更新时间
    private Date lastUpdateTime;

    //  创建时间
    private Date createTime;

    public String getBulkTaskId() {
        return bulkTaskId;
    }

    public void setBulkTaskId(String bulkTaskId) {
        this.bulkTaskId = bulkTaskId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
