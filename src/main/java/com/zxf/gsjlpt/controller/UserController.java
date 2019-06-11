package com.zxf.gsjlpt.controller;

import com.zxf.gsjlpt.dto.UserDto;
import com.zxf.gsjlpt.form.LoginForm;
import com.zxf.gsjlpt.model.SysUser;
import com.zxf.gsjlpt.model.SysUser2;
import com.zxf.gsjlpt.service.UserService;
import com.zxf.gsjlpt.util.CasPassword;
import com.zxf.gsjlpt.util.Page;
import com.zxf.gsjlpt.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName LoginController
 * @Description 用户相关操作
 * @Author dell
 * @Date 2019/1/18  14:17
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * @Description:    用户登录
     * @Author:         zxf
     * @Date:     2019/1/18 14:55
     * @Param [loginForm, bindingResult]
     * @return com.zxf.gsjlpt.vo.ResultVO
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(@Valid LoginForm loginForm, BindingResult bindingResult, HttpSession session) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(false);
        if (bindingResult.hasErrors()){
            resultVO.setMessage(bindingResult.getFieldError().getDefaultMessage());
        } else {
            // 密码加密
            CasPassword casPassword = new CasPassword();
            String password = casPassword.encode(loginForm.getPassword());
            SysUser2 user = userService.selectByNameAndPwd(loginForm.getUsername(), password);
            if ( user == null ) {
                resultVO.setMessage("用户名或者密码错误");
            } else {
                session.setAttribute("user",user);
                resultVO.setCode(true);
                resultVO.setMessage("用户认证成功");
            }
        }
        return resultVO;
    }

    /**
     * @Description:    获得当前系统登录用户
     * @Author:         zxf
     * @Date:     2019/1/18 16:13
     * @Param [session]
     * @return com.zxf.gsjlpt.vo.ResultVO
     */
    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public ResultVO getLoginUser(HttpSession session) {
        ResultVO<UserDto> resultVO = new ResultVO<>();
        resultVO.setCode(false);
        SysUser user = (SysUser) session.getAttribute("user");
        if (user == null) {
           resultVO.setMessage("不存在登录用户");
        } else {
            resultVO.setCode(true);
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            resultVO.setData(userDto);
            resultVO.setMessage("存在登录用户");
        }
        return resultVO;
    }

    /**
     * @Description:    用户退出
     * @Author:         zxf
     * @Date:     2019/1/18 16:30
     * @Param [session]
     * @return void
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logOut(HttpSession session) {
        session.removeAttribute("user");
        //销毁session
        session.invalidate();
    }

    /**
     * @Description:    查询所有用户信息
     * @Author:         zxf
     * @Date:     2019/1/20 15:03
     * @Param []
     * @return com.zxf.gsjlpt.vo.ResultVO
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
    public ResultVO getAllUser(int pageNumber, int pageSize,String username, String dept, String realname) {
        ResultVO<Page> resultVO = new ResultVO<>();
        resultVO.setCode(false);
        SysUser user = new SysUser();
        user.setRealname(realname);
        user.setUsername(username);
        user.setDept(dept);
        Page page= userService.findAll(user,pageNumber, pageSize);
        if (page !=null) {
            resultVO.setCode(true);
            resultVO.setData(page);
            resultVO.setMessage("查询成功");
        }
        return resultVO;
    }
    /**
     * @Description:    批量删除用户
     * @Author:         zxf
     * @Date:     2019/1/20 16:24
     * @Param []
     * @return void
     */
    @RequestMapping(value = "/batchesDeleteUser", method = RequestMethod.POST)
    public void batchesDeleteUser(String[] uids) {
        userService.batchesDelete(Arrays.asList(uids));
    }

    /**
     * @Description:    删除单个用户
     * @Author:         zxf
     * @Date:     2019/1/20 16:26
     * @Param [uid]
     * @return void
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResultVO deleteUser(@RequestParam String uid) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(false);
        try {

            userService.delete(uid);
            resultVO.setCode(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setMessage("未知错误");
        }
        return resultVO;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResultVO getUser(@RequestParam String uid) {
        ResultVO<UserDto> resultVO = new ResultVO<>();
        resultVO.setCode(false);
        SysUser user= userService.selectByKey(uid);
        if (user !=null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            resultVO.setData(userDto);
            resultVO.setMessage("查询成功");
            resultVO.setCode(true);
        }
        return resultVO;
    }
    /**
     * @Description:    添加用户
     * @Author:         zxf
     * @Date:     2019/1/21 9:27
     * @Param [userDto, bindingResult]
     * @return com.zxf.gsjlpt.vo.ResultVO
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResultVO saveUser(@Valid UserDto userDto, BindingResult bindingResult) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(false);
        if (bindingResult.hasErrors()) {
            resultVO.setMessage(bindingResult.getFieldError().getDefaultMessage());
        } else {
            try {
                List<SysUser> sysUser = userService.findByUsername(userDto.getUsername());
                if (sysUser.size() == 0) {
                    userDto.setUid(UUID.randomUUID().toString());
                    SysUser user = new SysUser();
                    BeanUtils.copyProperties(userDto, user);
                    CasPassword casPassword = new CasPassword();
                    user.setPassword(casPassword.encode("123456"));
                    user.setUpdateTime(new Date());
                    user.setCreateTime(new Date());
                    userService.save(user);
                    resultVO.setCode(true);
                    resultVO.setMessage("添加成功");
                } else {
                    resultVO.setMessage("用户名重复");
                }
            } catch (Exception e) {
                e.printStackTrace();
                resultVO.setMessage("未知错误");
                return resultVO;
            }
        }
        return resultVO;
    }

    /**
     * @Description:    更新用户密码
     * @Author:         zxf
     * @Date:     2019/1/21 10:43
     * @Param [uid, password]
     * @return com.zxf.gsjlpt.vo.ResultVO
     */
    @RequestMapping(value = "/updateUserPwd", method = RequestMethod.PUT)
    public ResultVO updateUserPwd(String uid, String password) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(false);
        try {
            if (!StringUtils.isEmpty(uid.trim()) && !StringUtils.isEmpty(password.trim())){
                SysUser sysUser = userService.selectByKey(uid);
                if (sysUser !=null) {
                    CasPassword casPassword = new CasPassword();
                    sysUser.setPassword(casPassword.encode(password));
                    userService.updateAll(sysUser);
                    resultVO.setMessage("更新成功");
                    resultVO.setCode(true);
                } else {
                    resultVO.setMessage("不存在此用户");
                }
            } else {
                resultVO.setMessage("缺少相应参数");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setMessage("未知错误");
            return resultVO;
        }
        return resultVO;
    }
}
