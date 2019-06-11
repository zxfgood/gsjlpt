package com.zxf.gsjlpt.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class SysUser2 {

    private String uid;

    private String username;

    private String password;

    private String dept;

    private String realname;

    private String salt;

    private Boolean locked;


    private Date createTime;


    private Date updateTime;

    private SysRoles sysRoles;

    private List<SysPermissions> sysPermissions;
    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * @param dept
     */
    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    /**
     * @return realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }


    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public SysRoles getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(SysRoles sysRoles) {
        this.sysRoles = sysRoles;
    }

    public List<SysPermissions> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List<SysPermissions> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }
}