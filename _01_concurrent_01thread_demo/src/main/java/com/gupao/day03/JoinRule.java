package com.gupao.day03;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class JoinRule {

    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            x = 100;
            System.out.println("t1");
        });

        Thread t2 = new Thread(() -> {
            x =200;
            System.out.println("t2");
        });

        Thread t3 = new Thread(() -> {
            x = 300;
            System.out.println("t3");
        });

        t1.start();
        t1.join();//阻塞主线程 wait/notify

        System.out.println(x);

        //等待阻塞释放
        //获取到t1线程的执行结果
        t2.start();
        t2.join(); //建立一个hapens-before规则
        System.out.println(x);
        t3.start();

        System.out.println(x);

    }

}
