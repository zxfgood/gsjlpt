package com.zxf.gsjlpt.service.impl;

import com.zxf.gsjlpt.mapper.MessageMapper;
import com.zxf.gsjlpt.model.Message;
import com.zxf.gsjlpt.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageImplTest {
    @Autowired
    private MessageService messageService;
    @Test
    public void findAllTest() {
        if (messageService == null) {
            System.out.println("service为空");
        }
        List<Message> messageList= messageService.findAll();
        for (Message message:messageList) {
            System.out.println(message.getMid());
        }
    }
}