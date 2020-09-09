package com.gupao.service.impl;

import com.gupao.domain.Student;
import com.gupao.service.IRowMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangycl
 * @date: 2020/9/4
 * @description:
 */
public class StudentRowMapper implements IRowMapper<List<Student>> {
    public List<Student> mapping(ResultSet rs) throws Exception {

        List<Student> list = new ArrayList<Student>();

        while(rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu = new Student(name,age);
            list.add(stu);
        }
        return list;
    }
}
