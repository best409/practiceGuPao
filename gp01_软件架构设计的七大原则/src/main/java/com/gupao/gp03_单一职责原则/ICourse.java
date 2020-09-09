package com.gupao.gp03_单一职责原则;

/**
 * @author: zhangycl
 * @date: 2020/9/3
 * @description:
 */
public interface ICourse {

    //获得基本信息
    String getCourseName();
    //获得视频流
    byte[] getCourseVideo();
    //学习课程
    void studyCourse();
    //退款
    void refundCourse();
}
