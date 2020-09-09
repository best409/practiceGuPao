package com.gupao.gp02_依赖倒置原则;

/**
 * @author: zhangycl
 * @date: 2020/9/3
 * @description: 如果 Tom 是全局单例，则 我们就只能选择用 Setter 方式来注入
 */
public class Tom3 {

    private ICourse course;

    public void setCourse(ICourse course) {
        this.course = course;
    }


    public void study(){
        course.study();
    }

    public static void main(String[] args) {
        Tom3 tom = new Tom3();
        tom.setCourse(new JavaCourse());
        tom.study();

        Tom3 tom1 = new Tom3();
        tom1.setCourse(new PythonCourse());
        tom1.study();
        
    }

}
