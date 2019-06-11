package com.zxf.gsjlpt.service.impl;

import com.zxf.gsjlpt.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RolesServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void test() {
        System.out.println(roleService.selectByKey(69).getRole());
    }
}