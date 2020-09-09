package com.gupao.day01;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class Main {

    PrintProcessor printProcessor;

    protected Main() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();

        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request) {
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("大超哥");
        new Main().doTest(request);
    }

}
