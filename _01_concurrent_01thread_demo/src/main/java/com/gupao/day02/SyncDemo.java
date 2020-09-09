package com.gupao.day02;

/**
 * @author: zhangycl
 * @date: 2020/8/22
 * @description:
 */
public class SyncDemo {
    Object lock;

    public SyncDemo() {

    }

    public SyncDemo(Object lock) {
        this.lock = lock;
    }

    public void demo() {
        synchronized (this) {

        }
    }

    public static void main(String[] args) {
        SyncDemo sd = new SyncDemo();
        new Thread(() -> sd.demo()).start();
        new Thread(() -> sd.demo()).start();
    }
}
