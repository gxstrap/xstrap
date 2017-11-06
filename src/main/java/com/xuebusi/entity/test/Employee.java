package com.xuebusi.entity.test;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * 测试
 * Created by SYJ on 2017/11/6.
 */
public class Employee {

    private String name;
    private Integer age;

    /**
     * 使用@DateTimeFormat对日期进行格式转换
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /**
     * 使用@NumberFormat注解对数字进行格式转换
     */
    @NumberFormat(pattern = "#,###,###.#")
    private Float salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
