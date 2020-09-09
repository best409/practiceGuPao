package com.gupao.day03;

import com.gupao.day02.ThreadB;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class VolatileRule {

    public volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (!stop) { //condition 不满足
                i++;
                System.out.println(i);
            }
        });
        t1.start();
        Thread.sleep(1000);
        stop = true; //ture
    }
}
