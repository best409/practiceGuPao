package com.gupao.day03;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class StartRule {

    static int x = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //use x = 10;
            System.out.println(x);
        });
        x = 10;

        t1.start();
    }
}
