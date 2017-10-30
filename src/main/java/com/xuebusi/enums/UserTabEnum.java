package com.xuebusi.enums;

/**
 * 用户页面Tab类型
 * Created by SYJ on 2017/10/30.
 */
public enum UserTabEnum {

    about(1, "个人介绍"),

    teach(2, "在教课程"),

    teachingClassrooms(3, "在教班级"),

    learn(4, "在学课程"),

    learningClassrooms(5, "在学班级"),

    favorited(6, "收藏课程"),

    group(7, "加入小组"),

    following(8, "关注"),

    follower(9, "粉丝");

    private int code;

    private String value;

    UserTabEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
