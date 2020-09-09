package com.gupao.day03;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class Demo {

    int a = 0;
    volatile boolean flag = false;

    public void writer() { //线程A
        a = 1; // 1
        flag = true;// 2

    }

    public void reader() {
        if (flag) { //3
            int x = a; // 4
        }
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.writer();
        demo.reader();
        System.out.println(demo.a);
        System.out.println(demo.flag);
    }
}
