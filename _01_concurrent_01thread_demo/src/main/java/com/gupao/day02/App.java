package com.gupao.day02;

/**
 * @author: zhangycl
 * @date: 2020/8/22
 * @description:
 */
public class App {

    public static void main(String[] args) {
        synchronized (App.class) {
            
        }
        test();
    }

    private static synchronized  void test() {
    }
}
