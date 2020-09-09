package com.gupao.day02;

/**
 * @author: zhangycl
 * @date: 2020/8/22
 * @description: 模拟中断的内部执行
 */
public class Test implements Runnable {

    private static volatile boolean isRunning = false; //中断标识

    @Override
    public void run() {
        while (!isRunning) { // !true

        }
    }

    public static void main(String[] args) {
        System.out.println("test");
        Thread thread = new Thread();
        thread.interrupt(); // isRunning = true;
    }
}
