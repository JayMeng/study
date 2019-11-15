package com.jay.flowcontrol;

/**
 * @author jay
 * @create 2019-11-15 16:31
 **/

public class Demo {
    public static void main(String[] args) {
        //  静态流控
        boolean isReachStaticThreshold =
                StaticFlowControlManager.getInstance().staticFlowCtrl("/app/index", "index");
        if (isReachStaticThreshold) {

        } else {

        }
    }
}
