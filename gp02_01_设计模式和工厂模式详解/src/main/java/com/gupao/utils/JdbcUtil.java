package com.gupao.utils;

import com.gupao.domain.Student;
import com.gupao.service.IRowMapper;
import javafx.beans.property.Property;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author: zhangycl
 * @date: 2020/9/4
 * @description:
 */
public class JdbcUtil {

    static Properties p = null;
    private JdbcUtil() {}
    static {
        //1. 加载注册驱动
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream("db.properties");
            p = new Properties();
            p.load(inputStream);
            Class.forName(p.getProperty("driverClassName"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            //2. 获取数据库连接
            return DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /*
    * 释放资源
    * */
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if( rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if( st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if( conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //查询统一模板
    public static List<Student> query_old(String sql, Object ...params) {
        List<Student> list = new ArrayList<Student>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn =JdbcUtil.getConnection();
            // 3. 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置值
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }

            // 4. 执行 SQL 语句
            rs = ps.executeQuery();
            while(rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student stu = new Student(name,age);
                list.add(stu);
            }


            // 5. 释放资源
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);
        }

        return list;

    }


    //查询统一模板->进阶版
    public static <T> T query(String sql, IRowMapper<T> rsh, Object ...params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn =JdbcUtil.getConnection();
            // 3. 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置值
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }

            // 4. 执行 SQL 语句
            rs = ps.executeQuery();
            return rsh.mapping(rs);


            // 5. 释放资源
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);
        }

        return null;

    }

}
