package com.gupao.service;

import java.sql.ResultSet;

/**
 * @author: zhangycl
 * @date: 2020/9/4
 * @description:
 */
public interface IRowMapper<T> {
    //处理结果集
    T mapping(ResultSet rs) throws Exception;
}
