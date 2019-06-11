package com.zxf.gsjlpt.service;

import com.zxf.gsjlpt.dto.UserDto;
import com.zxf.gsjlpt.model.SysPermissions;
import com.zxf.gsjlpt.model.SysRoles;
import com.zxf.gsjlpt.model.SysUser;
import com.zxf.gsjlpt.model.SysUser2;
import com.zxf.gsjlpt.util.Page;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author dell
 * @Date 2019/1/17  15:04
 **/
public interface UserService extends IService<SysUser>{
    SysUser2 selectByNameAndPwd(String userame, String password);
    Page findAll(SysUser sysUser, int pageNumber, int pageSize);
    void batchesDelete(List<String> list);
    List<SysUser> findByUsername(String username);
    List<SysPermissions> getPermission(String username);
    SysRoles findRole(String username);
    List<SysUser> findByUsernameLike(String username);
}
