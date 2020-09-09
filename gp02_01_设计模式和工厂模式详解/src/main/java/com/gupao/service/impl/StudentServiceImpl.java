package com.gupao.service.impl;

import com.gupao.domain.Student;
import com.gupao.service.StudentService;
import com.gupao.utils.JdbcUtil;
import org.springframework.stereotype.Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangycl
 * @date: 2020/9/4
 * @description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    public void save(Student stu) {
        String sql = "insert into t_student(name, age) values(?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn =JdbcUtil.getConnection();
            // 3. 创建语句对象
            ps =conn.prepareStatement(sql);
            ps.setObject(1, stu.getName());
            ps.setObject(2, stu.getAge());

            ps.executeUpdate();


        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }
    }



    public List<Student> list() {

        String sql = "select * from t_student";
        List<Student> list =JdbcUtil.query(sql,new StudentRowMapper());
        return list;


    }
}
