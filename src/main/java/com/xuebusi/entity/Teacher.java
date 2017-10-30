package com.xuebusi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 讲师
 * Created by SYJ on 2017/10/8.
 */
@Entity
@Data
@Table(name = "tb_teacher")
public class Teacher {

    @Id
    private Integer id;
    private String teacherName;
    private String teacherAbout;
    private String teacherLearn;
    private String teacherLearningClassroom;
    private String teacherFavorited;
    private String teacherGroup;
    private String teacherFollowing;
    private String teacherFollower;
    private String teacherRank;
    private String teacherSign;
    private String createTime;
    private String teacherPhotoUrl;

}
