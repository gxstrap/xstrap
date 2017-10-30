package com.xuebusi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户基础信息表
 * Created by SYJ on 2017/10/15.
 */
@Entity
@Data
@Table(name="tb_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;//用户名
    private Date createTime;//创建时间
    private String truename;//真实姓名
    private String gender;//性别
    private String idcard;//身份证号码
    private String mobile;//手机号码
    private String company;//公司
    private String job;//职业
    private String title;//头衔
    private String signature;//个人签名
    private String about;//自我介绍
    private String site;//个人空间
    private String weibo;//微博
    private String isWeiboPublic;//微博是否公开
    private String weixin;//微信
    private String isWeixinPublic;//微信是否公开
    private String qq;//QQ
    private String isQqPublic;//QQ是否公开
    private String position;//职位
    private String city;//所在城市
    private String courseIds;//所学课程id列表(逗号分隔)

}
