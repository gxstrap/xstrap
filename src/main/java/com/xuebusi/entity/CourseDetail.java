package com.xuebusi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by SYJ on 2017/10/8.
 */
@Entity
@Data
@Table(name = "tb_course_detail")
public class CourseDetail {

    @Id
    private int id;
    private String courseDesc;//课程介绍
    private String courseCatalog;// 课程目录
    private String courseNotice;//课程须知
    private int courseId;//课程id
    private Date createTime;//创建时间

}
