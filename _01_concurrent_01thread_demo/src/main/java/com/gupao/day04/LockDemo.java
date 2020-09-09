package com.gupao.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: zhangycl
 * @date: 2020/8/24
 * @description:
 */
public class LockDemo {

    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();

    public static final Object get(String key) {
        System.out.println("开始读取数据");
        read.lock(); //读锁
        try {
            return cacheMap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        write.lock();
        System.out.println("开始写数据");
        try {

            return cacheMap.put(key, value);
        }finally {
            write.unlock();
        }
    }

}
