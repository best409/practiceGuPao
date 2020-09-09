package com.gupao.day01;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class ExceptionThreadResetDemo {

    private static int i;
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() ->{
            while (! Thread.currentThread().isInterrupted()) {//默认是false  _interrupted state?
                try{
                    TimeUnit.SECONDS.sleep(1);//中断一个处于阻塞状态的线程。join/wait/queue.take..
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            System.out.println("Num:" + i);
        },"interruptDemo");


        thread1.start();
        TimeUnit.SECONDS.sleep(1);

        thread1.interrupt();//把isInterrupted设置成true

        System.out.println(thread1.isInterrupted());

    }
}
