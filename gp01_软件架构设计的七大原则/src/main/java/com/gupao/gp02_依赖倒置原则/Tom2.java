package com.gupao.gp02_依赖倒置原则;

/**
 * @author: zhangycl
 * @date: 2020/9/3
 * @description: 构造器方式依赖注入
 */
public class Tom2 {

    private ICourse course;

    public Tom2(ICourse course) {
        this.course =course;
    }

    public void study(){
        course.study();
    }

    public static void main(String[] args) {
        Tom2 tom = new Tom2(new JavaCourse());
        tom.study();

        Tom2 tom1 = new Tom2(new PythonCourse());
        tom1.study();

    }

}
