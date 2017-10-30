package com.xuebusi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 登录用户表
 * Created by SYJ on 2017/10/26.
 */
@Entity
@Data
@Table(name = "tb_login_info")
public class LoginInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;

}
