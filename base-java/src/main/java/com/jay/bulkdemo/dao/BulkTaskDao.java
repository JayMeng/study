package com.jay.bulkdemo.dao;

/**
 * @author jay
 * @create 2019-11-07 16:29
 **/

public class BulkTaskDao {

    //  更新主表信息
    public static void updateBulkTask(BulkTask bulkTask) {

    }

    //  插入批量任务信息表
    public static void insertInfo(BulkTaskInfo bulkTaskInfo){

    }

    //  更新状态表信息，并返回批量任务状态
    public static Integer updateBulkTaskInfo(BulkTaskInfo bulkTaskInfo) {
        // TODO  每个节点统计增量数据，所以数据库采用增量更新的方式
        //  update bulkTaskInfo set count =  = count + #{count} where status = #{status}

        //  更新信息表后，查询信息表的 成功数 + 失败数 + 数据异常数 >= 主表的总数量 ? 状态 = 完成 : 状态 = 解析中
        //  select sum(count) from bulkTaskInfo where bulkTaskId = #{bulkTaskId}
        //  select countAll from bulkTask where bulkTaskId = #{bulkTaskId}
        return 1;
    }
}
