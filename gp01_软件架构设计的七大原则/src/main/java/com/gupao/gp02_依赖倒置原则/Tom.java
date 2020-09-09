package com.gupao.gp02_依赖倒置原则;

/**
 * @author: zhangycl
 * @date: 2020/9/3
 * @description:
 */
public class Tom {

    public void study(ICourse course){
        course.study();
    }

    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.study(new JavaCourse());
        tom.study(new PythonCourse());
    }

}
