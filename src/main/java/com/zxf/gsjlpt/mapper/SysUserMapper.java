package com.zxf.gsjlpt.mapper;

import com.zxf.gsjlpt.common.MyMapper;
import com.zxf.gsjlpt.dto.UserDto;
import com.zxf.gsjlpt.model.SysPermissions;
import com.zxf.gsjlpt.model.SysRoles;
import com.zxf.gsjlpt.model.SysUser;
import com.zxf.gsjlpt.model.SysUser2;
import org.apache.ibatis.annotations.Param;

import java.security.Permission;
import java.util.List;

public interface SysUserMapper extends MyMapper<SysUser> {
    SysUser2 selectByNameAndPwd(@Param("username") String username, @Param("password")String password);
    void batchesDelete(List<String> list);
    List<SysUser> findByUsername(String username);
    SysRoles findRole(String username);
    List<SysPermissions> getPermission(String username);
    List<SysUser> findByUsernameLike(String username);
    void batchesAddUser(@Param("sysUsers") List<SysUser> sysUsers);
}