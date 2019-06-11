package com.zxf.gsjlpt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cid;

    private String cnumber;

    private String ccontent;

    private String cstate;

    private String creplay;

    private String cuid;

    private String cruid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * @return cnumber
     */
    public String getCnumber() {
        return cnumber;
    }

    /**
     * @param cnumber
     */
    public void setCnumber(String cnumber) {
        this.cnumber = cnumber == null ? null : cnumber.trim();
    }

    /**
     * @return ccontent
     */
    public String getCcontent() {
        return ccontent;
    }

    /**
     * @param ccontent
     */
    public void setCcontent(String ccontent) {
        this.ccontent = ccontent == null ? null : ccontent.trim();
    }

    /**
     * @return cstate
     */
    public String getCstate() {
        return cstate;
    }

    /**
     * @param cstate
     */
    public void setCstate(String cstate) {
        this.cstate = cstate == null ? null : cstate.trim();
    }

    /**
     * @return creplay
     */
    public String getCreplay() {
        return creplay;
    }

    /**
     * @param creplay
     */
    public void setCreplay(String creplay) {
        this.creplay = creplay == null ? null : creplay.trim();
    }

    /**
     * @return cuid
     */
    public String getCuid() {
        return cuid;
    }

    /**
     * @param cuid
     */
    public void setCuid(String cuid) {
        this.cuid = cuid == null ? null : cuid.trim();
    }

    /**
     * @return cruid
     */
    public String getCruid() {
        return cruid;
    }

    /**
     * @param cruid
     */
    public void setCruid(String cruid) {
        this.cruid = cruid == null ? null : cruid.trim();
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
}