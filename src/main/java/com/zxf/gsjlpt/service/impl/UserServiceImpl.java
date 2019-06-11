package com.zxf.gsjlpt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.zxf.gsjlpt.dto.UserDto;
import com.zxf.gsjlpt.mapper.SysUserMapper;
import com.zxf.gsjlpt.model.SysPermissions;
import com.zxf.gsjlpt.model.SysRoles;
import com.zxf.gsjlpt.model.SysUser;
import com.zxf.gsjlpt.model.SysUser2;
import com.zxf.gsjlpt.service.UserService;
import com.zxf.gsjlpt.util.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author dell
 * @Date 2019/1/17  15:03
 **/
@Service
public class UserServiceImpl extends BaseService<SysUser> implements UserService{
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser2 selectByNameAndPwd(String username, String password) {
        return sysUserMapper.selectByNameAndPwd(username, password);
    }

    @Override
    public Page findAll(SysUser sysUser, int pageNumber, int pageSize) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(sysUser.getUsername())) {
            criteria.andLike("username", "%" + sysUser.getUsername() + "%");
        }
        if (StringUtil.isNotEmpty(sysUser.getRealname())) {
            criteria.andLike("realname", "%" + sysUser.getRealname() + "%");
        }
        if (StringUtil.isNotEmpty(sysUser.getDept())) {
            //criteria.andEqualTo("id", country.getId());
            criteria.andLike("dept", "%" + sysUser.getDept() + "%");
        }
        List<SysUser> list= selectByExample(example);
        //分页查询
        PageHelper.startPage(pageNumber, pageSize);
        List<SysUser> sysUserList= selectByExample(example);
        List<UserDto> userDtoList = new ArrayList<>();
        if (sysUserList.size() > 0) {
            for (SysUser user : sysUserList) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                userDtoList.add(userDto);
            }
        }
        int totalNum = list.size();
        // System.out.println("totalNum :" + totalNum);
        int totalPage = Page.getTotalPage(totalNum, pageSize);
        Page page = new Page();
        page.setList(userDtoList);
        page.setTotalPage(totalPage);
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        return page;
    }

    @Override
    public void batchesDelete(List<String> list) {
        sysUserMapper.batchesDelete(list);
    }

    @Override
    public List<SysUser> findByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }

    @Override
    public List<SysPermissions> getPermission(String username) {
        return sysUserMapper.getPermission(username);
    }

    @Override
    public SysRoles findRole(String username) {
        return sysUserMapper.findRole(username);
    }

    @Override
    public List<SysUser> findByUsernameLike(String username) {
        return sysUserMapper.findByUsernameLike(username);
    }

    @Override
    public int save(SysUser entity) {
        return super.save(entity);
    }

    @Override
    public int count(SysUser entity) {
        return super.count(entity);
    }
}
