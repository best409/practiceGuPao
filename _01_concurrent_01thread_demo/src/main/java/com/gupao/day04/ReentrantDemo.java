package com.gupao.day04;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class ReentrantDemo {

    public synchronized void demo() { //main获得对象锁
        System.out.println("demo");
        demo2();
    }

    private void demo2() {
        synchronized (this) { //增加重入次数就行
            System.out.println("demo2");

        } //减少重入次数
    }

    public static void main(String[] args) {
        ReentrantDemo app = new ReentrantDemo();
        app.demo();
    }
}
