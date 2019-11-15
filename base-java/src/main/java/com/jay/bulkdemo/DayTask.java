package com.jay.bulkdemo;

/**
 * 批量任务定时任务
 * 避免未知异常，导致 成功数+失败数+异常数 >= 总数 不成立，批量任务一直处于执行中状态无法结束，故设置定时检查机制
 *
 * @author jay
 * @create 2019-11-15 14:18
 **/

public class DayTask {

    public void check() {
        //  TODO 查询主表状态处于执行中且最后更新时间已经间隔超过1天的数据，并将状态修改为异常
    }
}
