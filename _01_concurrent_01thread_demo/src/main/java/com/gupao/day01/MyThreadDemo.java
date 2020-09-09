package com.gupao.day01;

import java.util.concurrent.*;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class MyThreadDemo extends Thread {
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Thread
        MyThreadDemo myThread1 = new MyThreadDemo();
        MyThreadDemo myThread2 = new MyThreadDemo();
        myThread1.start();
        myThread2.start();

        //Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();


        //Callable
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);
        System.out.println(future.get());
        executorService.shutdown();
    }

    /*
     *实现 Runnable 接口创建线程
     * */
    static class MyRunnable implements Runnable {

        public void run() {
            System.out.println("runnable");
        }
    }

    /*
     *实现 Callable 接口通过 FutureTask 包装器来创建 Thread 线程
     */
    static class CallableDemo implements Callable<String> {


        public String call() throws Exception {
            int a = 1;
            int b = 2;
            System.out.println(a + b);
            return "执行结果： " + (a + b);
        }
    }
}
