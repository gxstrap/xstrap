package com.xuebusi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 课程目录（课时章节）
 * Created by SYJ on 2017/10/9.
 */
@Entity
@Data
@Table(name = "tb_lesson")
public class Lesson {

    @Id
    private Integer id;
    private Integer lessonParentId;
    private String lessonName;
    private Integer lessonType;
    private Date createTime;
    private Integer lessonSort;
    private Integer courseId;

}
