package com.zxf.gsjlpt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "repair")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rid;

    private String rnumber;

    private String rcontent;

    private String rstate;

    private String rreplay;

    private String ruid;

    private String rruid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    /**
     * @return rnumber
     */
    public String getRnumber() {
        return rnumber;
    }

    /**
     * @param rnumber
     */
    public void setRnumber(String rnumber) {
        this.rnumber = rnumber == null ? null : rnumber.trim();
    }

    /**
     * @return rcontent
     */
    public String getRcontent() {
        return rcontent;
    }

    /**
     * @param rcontent
     */
    public void setRcontent(String rcontent) {
        this.rcontent = rcontent == null ? null : rcontent.trim();
    }

    /**
     * @return rstate
     */
    public String getRstate() {
        return rstate;
    }

    /**
     * @param rstate
     */
    public void setRstate(String rstate) {
        this.rstate = rstate == null ? null : rstate.trim();
    }

    /**
     * @return rreplay
     */
    public String getRreplay() {
        return rreplay;
    }

    /**
     * @param rreplay
     */
    public void setRreplay(String rreplay) {
        this.rreplay = rreplay == null ? null : rreplay.trim();
    }

    /**
     * @return ruid
     */
    public String getRuid() {
        return ruid;
    }

    /**
     * @param ruid
     */
    public void setRuid(String ruid) {
        this.ruid = ruid == null ? null : ruid.trim();
    }

    /**
     * @return rruid
     */
    public String getRruid() {
        return rruid;
    }

    /**
     * @param rruid
     */
    public void setRruid(String rruid) {
        this.rruid = rruid == null ? null : rruid.trim();
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