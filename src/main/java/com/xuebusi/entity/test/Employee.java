package com.xuebusi.entity.test;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 测试
 * Created by SYJ on 2017/11/6.
 */
public class Employee {

    @NotEmpty
    private String name;

    @NotNull
    private Integer gender;

    @Email
    private String email;

    /**
     * 使用@DateTimeFormat对日期进行格式转换
     */
    @Past
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
