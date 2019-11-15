package com.jay.bulkdemo.dao;

import java.util.Date;
import java.util.List;

/**
 * @author jay
 * 批量解析任务主体
 * @create 2019-11-06 9:29
 **/
public class BulkTask {

    //  批量任务id
    private String bulkTaskId;

    //  文件存储地址
    private String url;

    //  类型，1=开户，2=销户
    private Integer type;

    // -1 = 待解析， 0 = 解析中， 1 = 解析完成 ，2 = 解析异常
    private Integer status;

    //  创建时间
    private Date createTime;

    //  任务开始时间
    private Date startTime;

    private Date lastUpdateTime;

    //  总数量
    private Integer countAll;

    //  任务信息列表
    private List<BulkTaskInfo> bulkTaskInfos;

    public String getBulkTaskId() {
        return bulkTaskId;
    }

    public void setBulkTaskId(String bulkTaskId) {
        this.bulkTaskId = bulkTaskId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getCountAll() {
        return countAll;
    }

    public void setCountAll(Integer countAll) {
        this.countAll = countAll;
    }

    public List<BulkTaskInfo> getBulkTaskInfos() {
        return bulkTaskInfos;
    }

    public void setBulkTaskInfos(List<BulkTaskInfo> bulkTaskInfos) {
        this.bulkTaskInfos = bulkTaskInfos;
    }
}
