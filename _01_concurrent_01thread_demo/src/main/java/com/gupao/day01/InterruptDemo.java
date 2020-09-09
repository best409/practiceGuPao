package com.gupao.day01;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            //默认情况下isInterrupted 返回false, 通过thread.interrupt变成了true
            while(!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Num:" + i);
        },"interruptDemo");

        thread.start();
        TimeUnit.SECONDS.sleep(1);

        thread.interrupt(); //加和不加的效果    ;  中断，设置isInterrupted为true
        System.out.println(thread.isInterrupted());  //true


    }
}
