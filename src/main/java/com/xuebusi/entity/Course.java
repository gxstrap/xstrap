package com.xuebusi.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * 课程信息
 * Created by SYJ on 2017/10/7.
 */
@Entity
@Table(name = "tb_course")
public class Course implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String courseTitle;
    private String courseImgUrl;
    private Integer courseUserCount;
    private String courseTeacherName;
    private Double coursePrice;
    private String courseLink;
    private Date createTime;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private Blob courseData;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public Integer getCourseUserCount() {
        return courseUserCount;
    }

    public void setCourseUserCount(Integer courseUserCount) {
        this.courseUserCount = courseUserCount;
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }

    public void setCourseTeacherName(String courseTeacherName) {
        this.courseTeacherName = courseTeacherName;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseNavigation() {
        return courseNavigation;
    }

    public void setCourseNavigation(String courseNavigation) {
        this.courseNavigation = courseNavigation;
    }

    public Integer getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(Integer courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public Date getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public Date getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public Blob getCourseData() {
        return courseData;
    }

    public void setCourseData(Blob courseData) {
        this.courseData = courseData;
    }
}
