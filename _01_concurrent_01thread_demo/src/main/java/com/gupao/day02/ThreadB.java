package com.gupao.day02;

/**
 * @author: zhangycl
 * @date: 2020/8/22
 * @description:
 */
public class ThreadB extends Thread{

    private Object lock = new Object();

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    public void run(){
        synchronized (lock) {
            System.out.println("start ThreadB");
            lock.notify();//唤醒被阻塞的线程
            System.out.println("end ThreadB");
        }
    }

}
