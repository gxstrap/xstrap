package com.xuebusi.vo;


import lombok.Data;

/**
 * 提交订单参数
 * Created by SYJ on 2017/10/29.
 */
@Data
public class OrderCreateVo {

    private String password;
    private String targetType;
    private String targetId;
    private String totalPrice;
    private String shouldPayMoney;
    private String smsCode;
    private String mobile;
    private String csrfToken;
    private String courseTitle;
    private String courseImgUrl;
    private String courseLink;

}
