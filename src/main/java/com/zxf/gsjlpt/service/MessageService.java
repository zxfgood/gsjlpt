package com.zxf.gsjlpt.service;

import com.zxf.gsjlpt.model.Message;

import java.util.List;

/**
 * @ClassName MessageService
 * @Description TODO
 * @Author dell
 * @Date 2019/1/18  16:50
 **/
public interface MessageService extends IService<Message>{
    List<Message> findAll();
}
