package com.gupao.day01;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class ThreadResetDemo {


    public static void main(String[] args) throws InterruptedException {
        //线程复位
        //1. Thread.interrupted()
        //2. InterruptedException

        Thread thread2 = new Thread(() -> {
            while (true) { //默认是false  _interrupted state?
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("before:" +Thread.currentThread().isInterrupted());
                    Thread.interrupted(); //对线程进行复位，由true变成false
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                }


            }
        },"interruptDemo");

        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.interrupt();//把isInterrupted设置成true
    }

}
