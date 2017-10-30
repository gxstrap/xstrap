package com.xuebusi.vo;

import lombok.Data;

/**
 * 支付信息
 * Created by SYJ on 2017/10/29.
 */
@Data
public class PayCenterInfoVo {

    private String targetType;
    private String targetId;//课程id
    private String totalPrice;//总价格
    private String shouldPayMoney;//应付价格
    private String courseTitle;//课程标题
    private String courseImgUrl;//课程图片地址
    private String courseLink;//课程链接地址
    private String orderNo;//订单号

}
