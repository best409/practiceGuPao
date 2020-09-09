package com.gupao.gp01_开闭原则;

/**
 * @author: zhangycl
 * @date: 2020/9/3
 * @description:
 */
public class JavaDiscountCourse extends JavaCourse {


    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

    public Double getPrice() {
        return super.getPrice() * 0.61;
    }
}
