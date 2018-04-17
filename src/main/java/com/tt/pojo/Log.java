package com.tt.pojo;

import java.util.Date;

/**
 * 
 * @author ciker
 * @desc  系统日志类
 *
 */
public class Log {
    private Integer logid;

    private Integer userid;

    private Date time;

    private String type;

    private String detail;

    private String ip;

    public Log(Integer logid, Integer userid, Date time, String type, String detail, String ip) {
        this.logid = logid;
        this.userid = userid;
        this.time = time;
        this.type = type;
        this.detail = detail;
        this.ip = ip;
    }

    public Log() {
        super();
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}