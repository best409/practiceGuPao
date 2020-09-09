package com.gupao.day02;

/**
 * @author: zhangycl
 * @date: 2020/8/22
 * @description:
 */
public class WaitNofityDemo {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }
}
