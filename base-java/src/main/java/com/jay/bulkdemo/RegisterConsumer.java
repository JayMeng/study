package com.jay.bulkdemo;

/**
 * 开户消费者
 *
 * @author jay
 * @create 2019-11-15 9:03
 **/

public class RegisterConsumer {

    public void process(String mobile, String bulkTaskId) {
        if (registerSuccess(mobile)) {
            BulkTaskCounter.getInstance().addSuccCount(bulkTaskId);
        } else {
            BulkTaskCounter.getInstance().addErrCount(bulkTaskId);
        }
    }

    //  开户是否成功
    private Boolean registerSuccess(String mobile) {
        //  TODO 业务开户
        return true;
    }

}
