package com.zxf.gsjlpt.service.impl;

import com.zxf.gsjlpt.mapper.MessageMapper;
import com.zxf.gsjlpt.model.Message;
import com.zxf.gsjlpt.service.MessageService;
import com.zxf.gsjlpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MessageImpl
 * @Description TODO
 * @Author dell
 * @Date 2019/1/18  16:59
 **/
@Service
public class MessageImpl extends BaseService<Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> findAll() {
        return messageMapper.findAll();
    }

    @Override
    public int count(Message entity) {
        return super.count(entity);
    }
}
