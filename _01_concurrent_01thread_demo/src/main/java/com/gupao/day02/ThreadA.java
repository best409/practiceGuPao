package com.gupao.day02;

/**
 * @author: zhangycl
 * @date: 2020/8/22
 * @description:
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            System.out.println("start ThreadA");
            try{
                lock.wait();//实现阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end ThreadA");
        }
    }

}
