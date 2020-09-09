package com.gupao.day04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class AtomicDemo {
    private static int count = 0;
    static Lock lock = new ReentrantLock();

    public static void inrc() {
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                AtomicDemo.inrc();
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("result:"+count);
    }
}
