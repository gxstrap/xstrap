package com.xuebusi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 微博用户授权信息
 * @author caiyuyu
 * @date 2017/11/2
 */
@Entity
@Table(name="tb_weibo_user")
public class WeiboUser {

    @Id
    private String weiboId;
    private String accessToken;
    private Integer state;
    private Date createTime;
    private Date updateTime;

    public String getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(String weiboId) {
        this.weiboId = weiboId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
