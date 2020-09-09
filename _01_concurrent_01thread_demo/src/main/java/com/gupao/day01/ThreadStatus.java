package com.gupao.day01;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class ThreadStatus {
    public static void main(String[] args) {
        //TIME_WATING
        new Thread(() -> {
           while(true) {
               try {
                   TimeUnit.SECONDS.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"timewating").start();


        //WAITING，线程在ThreadStatus类锁上通过wait进行等待
        new Thread(() -> {
            while(true) {
                synchronized (ThreadStatus.class) {
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Wating").start();


        //线程在ThreadStatus加锁后，不会释放锁
        new Thread(new BlockedDemo(),"BlockDemo-01").start();
        new Thread(new BlockedDemo(),"BlockDemo-02").start();

    }

    static class BlockedDemo extends Thread {
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try{
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
