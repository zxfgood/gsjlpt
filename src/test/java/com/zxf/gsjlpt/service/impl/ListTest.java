package com.zxf.gsjlpt.service.impl;

import com.zxf.gsjlpt.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    @Test
    public  void a() {
        List<User> list = new ArrayList<User>();
        User a = new User();
        a.setAge(10);
        a.setName("a");
        User b = new User();
        b.setAge(12);
        b.setName("b");
        User c = new User();
        c.setAge(9);
        c.setName("c");
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list, new Comparator<User>(){
            public int compare(User o1, User o2) {
                //排序属性
                if(o1.getAge() > o2.getAge()){
                    return 1;
                }
                if(o1.getAge() == o2.getAge()){
                    return 0;
                }
                return -1;
            }
        });

        for (User u:list) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void a1() {
        Object a = new Object();
        a = "13";
        System.out.println((String) a);
    }

}
