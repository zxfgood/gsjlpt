package com.zxf.gsjlpt.service.impl;

import com.zxf.gsjlpt.dto.UserDto;
import com.zxf.gsjlpt.mapper.SysUserMapper;
import com.zxf.gsjlpt.model.SysPermissions;
import com.zxf.gsjlpt.model.SysRoles;
import com.zxf.gsjlpt.model.SysUser;
import com.zxf.gsjlpt.model.SysUser2;
import com.zxf.gsjlpt.service.UserService;
import com.zxf.gsjlpt.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void selectByNameAndPwdTest() {
        SysUser2 user = userService.selectByNameAndPwd("a", "123456");
        if (user != null) {
            System.out.println(user.getUsername());
            System.out.println(user.getSysRoles().getRole());
        } else {
            System.out.println("不存在此用户");
        }
    }

    @Test
    public void SaveTest() {
        SysUser user = new SysUser();
        for (int i = 0; i< 20;i++) {
            user.setDept("信息化");
            user.setUsername("zxf" + (i+1));
            user.setLocked(false);
            user.setPassword("123456");
            user.setRealname("zxf" + (i+1));
            user.setRole("saveRole");
            user.setSalt("saltTest");
            user.setUid(UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            System.out.println(userService.save(user));
        }


    }

    @Test
    public void findAllTest() {
       /* List<UserDto> userDtoList= userService.findAll(new SysUser(),0,10);
        for (UserDto userDto : userDtoList) {
            System.out.println(userDto.getUsername());
        }*/
       SysUser user = new SysUser();
       user.setUsername("zxf");
       Page page = userService.findAll(user, 0, 10);
        System.out.println("list:" + page.getList());
        System.out.println("PageNumber:" + page.getPageNumber());
        System.out.println("TotalPage:" + page.getTotalPage());
    }

    @Test
    public void batchesDeleteTest() {
        List<String> list = Arrays.asList("00acf47e-e30a-436d-a986-115788821dda", "1b35e50e-5bc8-428a-9012-59953913c2a5");
        userService.batchesDelete(list);
    }

    @Test
    public void findByUserNameTest() {
        try {
            List<SysUser> users = userService.findByUsername("zxf");
            for (SysUser user: users){
                System.out.println(user.getUsername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countTest() {
        SysUser user = new SysUser();
        user.setUsername("zxf");
        System.out.println(userService.count(user));
    }

    @Test
    public void findRole() {
        SysRoles roles = userService.findRole("a");
        System.out.println(roles.getDescription());
    }

    @Test
    public void getPermission() {
        List<SysPermissions> permissionsList = userService.getPermission("a");
        System.out.println("123");
    }

    @Test
    public void findByUsernameLikeTest() {
        List<SysUser> sysUsers = userService.findByUsernameLike("z");
        System.out.println("123");
    }

    @Test
    public void batchAdd() {
        List<SysUser> sysUsers = new ArrayList<>();
        SysUser user = new SysUser();
        // user.setUid("3a");
        user.setUsername("zxf23");
        user.setLocked(false);
        user.setPassword("123456");
        user.setRealname("zxf");
        user.setRole("saveRole");
        user.setSalt("saltTest");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        SysUser user2 = new SysUser();
        // user2.setUid("4a");
        user2.setUsername("zxf24");
        user2.setLocked(false);
        user2.setPassword("123456");
        user2.setRealname("zxf");
        user2.setRole("saveRole");
        user2.setSalt("saltTest");
        user2.setCreateTime(new Date());
        user2.setUpdateTime(new Date());
        sysUsers.add(user);
        sysUsers.add(user2);
        sysUserMapper.batchesAddUser(sysUsers);
        System.out.println(user.getUid());
    }
}