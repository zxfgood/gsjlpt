package com.zxf.gsjlpt.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName MyMapper
 * @Description TODO 继承自己的mapper
 * @Author zxf
 * @Date 2019/1/17  11:22s
 **/
public interface MyMapper <T> extends Mapper<T>, MySqlMapper<T> {
}
