package com.zxf.gsjlpt.mapper;

import com.zxf.gsjlpt.common.MyMapper;
import com.zxf.gsjlpt.model.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MessageMapper extends MyMapper<Message> {
    List<Message> findAll();
}