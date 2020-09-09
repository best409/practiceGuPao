package com.gupao;

import com.gupao.domain.Student;
import com.gupao.service.IRowMapper;
import com.gupao.service.StudentService;
import com.gupao.service.impl.StudentServiceImpl;
import com.gupao.utils.JdbcUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author: zhangycl
 * @date: 2020/9/4
 * @description:
 */

public class Test {


    private StudentService studentService = new StudentServiceImpl();

    @org.junit.Test
    public void saveTest() {

//        Student student = new Student("zhangycl",28);
//
//        studentService.save(student);
        System.out.println("hello world");

        List<Student> studentList = studentService.list();
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }



    @org.junit.Test
    public void getCountTest(){
        String sql = "select count(*) total from t_student";
        Long totalCount = JdbcUtil.query(sql, new IRowMapper<Long>() {
            public Long mapping(ResultSet rs) throws Exception {
                Long totalCount = null;
                if(rs.next()) {
                    totalCount = rs.getLong("total");
                }

                return totalCount;
            }
        });


        System.out.println(totalCount);
    }
}
