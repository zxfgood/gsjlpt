package com.zxf.gsjlpt.form;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName LoginForm
 * @Description TODO 用户登录的form表单类
 * @Author dell
 * @Date 2019/1/18  14:47
 **/
@Data
public class LoginForm {
    @NotEmpty(message = "用户名必填")
    private String username;

    @NotEmpty(message = "密码必填")
    private String password;
}
