package com.zxf.gsjlpt.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName UserDto
 * @Description TODO 返回给前端的用户信息
 * @Author dell
 * @Date 2019/1/18  16:01
 **/
@Data
public class UserDto {

    private String uid;

    @NotEmpty(message = "真实姓名必填")
    private String realname;

    @NotEmpty(message = "用户名必填")
    private String username;

    @NotEmpty(message = "部门必填")
    private String dept;

    private String role;
}
