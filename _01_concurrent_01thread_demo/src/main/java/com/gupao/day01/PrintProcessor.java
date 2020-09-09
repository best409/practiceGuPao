package com.gupao.day01;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    private  final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void run(){
        while(true) {
            try {
                Request request = requests.take();
                System.out.println("print data:" + request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //处理请求
    public void processRequest(Request request) {
        requests.add(request);
    }
}
