package com.gupao.day01;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    //阻塞队列
    LinkedBlockingQueue<Request>  requests = new LinkedBlockingQueue<Request>();

    public void run() {
        while(true) {
            try {
                Request request = requests.take();
                System.out.println("begin save request info: "+ request);
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
