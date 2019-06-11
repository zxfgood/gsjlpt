package com.zxf.gsjlpt.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName IService
 * @Description TODO 通用接口
 * @Author dell
 * @Date 2019/1/17  11:24
 **/
@Service
public interface IService<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    int count(T entity);
    //TODO 其他...
}
