package com.xuebusi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 课程信息
 * Created by SYJ on 2017/10/7.
 */
@Entity
@Data
@Table(name = "tb_course")
public class Course {

    @Id
    private Integer id;
    private String courseTitle;
    private String courseImgUrl;
    private Integer courseUserCount;
    private String courseTeacherName;
    private Double coursePrice;
    private String courseLink;
    private Date createTime;
    /**
     * systematic   系统课
     * open         公开课
     * bootcamp     训练营
     */
    private String courseCategory;//所属分类
    /**
     * ai       人工智能
     * bigdata  大数据
     * da       数据分析
     * basic    基础课程
     */
    private String courseNavigation;//所属导航菜单

    private Integer courseTeacherId;//讲师id

    private Date courseStartTime;//课程开始时间

    private Date courseEndTime;//课程结束时间


}
