package com.gupao.service;

import com.gupao.domain.Student;
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

public interface StudentService {

    public void save(Student stu);

    public List<Student> list();

 }
