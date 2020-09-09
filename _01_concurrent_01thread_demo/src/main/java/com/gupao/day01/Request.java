package com.gupao.day01;

/**
 * @author: zhangycl
 * @date: 2020/8/21
 * @description:
 */
public class Request {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
