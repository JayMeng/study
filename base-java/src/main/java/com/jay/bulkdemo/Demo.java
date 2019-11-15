package com.jay.bulkdemo;

import com.jay.bulkdemo.dao.BulkTask;
import com.jay.bulkdemo.dao.BulkTaskDao;
import com.jay.bulkdemo.dao.BulkTaskInfo;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jay
 * @create 2019-11-07 9:35
 **/

public class Demo {

    public static void main(String[] args) {
        BulkTask bulkTask = buildBulkTask();

        //  读取并解析 待解析的文件
        Integer countAll = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(bulkTask.getUrl()), Charset.forName("utf-8"));
            bulkTask.setCountAll(lines.size());
            bulkTask.setStatus(0);//解析中
            bulkTask.setStartTime(new Date());
            //  TODO 更新主表的总数里/开始时间等信息
            updateBulkTask(bulkTask);
            //  插入状态表基本信息
            insertBulkTaskInfo(bulkTask.getBulkTaskId());
            //   读取文件，并解析，传统的流程是逐行解析，阻塞等待业务流程返回，
            //   即使通过服务的方式调用可以负载，但是实际流程卡在调用方，只有调用一次结束才能进行下一次，所以即使服务提供方提供集群也没有用，性能依然较差
            lines.forEach(line -> register(line));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertBulkTaskInfo(String bulkTaskId) {
        for (int i = 0; i < 3; i++) {
            BulkTaskInfo bulkTaskInfo = new BulkTaskInfo();
            bulkTaskInfo.setBulkTaskId(bulkTaskId);
            bulkTaskInfo.setCreateTime(new Date());
            bulkTaskInfo.setStatus(i);
            bulkTaskInfo.setCount(0);
            BulkTaskDao.insertInfo(bulkTaskInfo);
        }
    }

    //  解析文件，并更新主表的总数量和开始时间
    private static void updateBulkTask(BulkTask bulkTask) {
        BulkTaskDao.updateBulkTask(bulkTask);
    }

    //  TODO 这里执行对应的业务流程，比如开户,同时对每条数据进行业务校验，是否合法，不合法的话同时 调用BulkTaskCounter.addInvalidCount
    //  修改为 每解析一条，直接将数据丢到mq,这样业务流程不阻塞，同时mq消费者集群部署，充分发挥性能优势
    private static void register(String mobile) {

    }

    public static BulkTask buildBulkTask() {
        BulkTask bulkTask = new BulkTask();
        bulkTask.setBulkTaskId(UUID.randomUUID().toString());
        bulkTask.setUrl("D:\\register.txt");
        bulkTask.setCreateTime(new Date());
        bulkTask.setType(1);//开户
        bulkTask.setStatus(-1);//待解析
        return bulkTask;
    }

    public static BulkTaskInfo buildBulkTaskInfo(String buildTaskId, Integer status) {
        BulkTaskInfo info = new BulkTaskInfo();
        info.setBulkTaskId(buildTaskId);
        info.setCreateTime(new Date());
        return info;
    }
}
