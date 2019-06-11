package com.zxf.gsjlpt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String mid;

    private String mnumber;

    private String mcontent;

    private String mstate;

    private String mreplay;

    private String muid;

    private String mruid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return mid
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid
     */
    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    /**
     * @return mnumber
     */
    public String getMnumber() {
        return mnumber;
    }

    /**
     * @param mnumber
     */
    public void setMnumber(String mnumber) {
        this.mnumber = mnumber == null ? null : mnumber.trim();
    }

    /**
     * @return mcontent
     */
    public String getMcontent() {
        return mcontent;
    }

    /**
     * @param mcontent
     */
    public void setMcontent(String mcontent) {
        this.mcontent = mcontent == null ? null : mcontent.trim();
    }

    /**
     * @return mstate
     */
    public String getMstate() {
        return mstate;
    }

    /**
     * @param mstate
     */
    public void setMstate(String mstate) {
        this.mstate = mstate == null ? null : mstate.trim();
    }

    /**
     * @return mreplay
     */
    public String getMreplay() {
        return mreplay;
    }

    /**
     * @param mreplay
     */
    public void setMreplay(String mreplay) {
        this.mreplay = mreplay == null ? null : mreplay.trim();
    }

    /**
     * @return muid
     */
    public String getMuid() {
        return muid;
    }

    /**
     * @param muid
     */
    public void setMuid(String muid) {
        this.muid = muid == null ? null : muid.trim();
    }

    /**
     * @return mruid
     */
    public String getMruid() {
        return mruid;
    }

    /**
     * @param mruid
     */
    public void setMruid(String mruid) {
        this.mruid = mruid == null ? null : mruid.trim();
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