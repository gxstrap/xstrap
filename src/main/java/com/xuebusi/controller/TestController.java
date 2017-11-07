package com.xuebusi.controller;

import com.xuebusi.common.result.JsonResult;
import com.xuebusi.entity.LoginInfo;
import com.xuebusi.entity.test.Employee;
import com.xuebusi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口测试
 * Created by SYJ on 2017/10/28.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private LoginService loginService;

    /**
     * 测试
     * @return
     */
    @RequestMapping
    public String getTime(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", System.currentTimeMillis());
        return new JsonResult().JsonSuccess(map);
    }

    /**
     * 测试@ModelAttribute的使用
     * 被@ModelAttribute注解修饰的方法就相当于SpringMVC拦截器，
     * 在调用该类中所有的方法之前都会先调用此方法。
     * @param loginInfo
     * @param map
     */
    @ModelAttribute
    public void getLoginInfo(LoginInfo loginInfo, Map<String, Object> map) {
        if (loginInfo.getId() != null && loginInfo.getId() > 0) {
            map.put("loginInfo", loginService.findOne(loginInfo.getId()));
        }
    }

    /**
     * 【测试修改登录用户信息】
     *
     *  结合上面的@ModelAttribute注解标识的方法，
     *  先判断LoginInfo的id不为空，说明是修改，
     *  就根据id从数据库中查询出LoginInfo对象，
     *  并放到请求域（map）中。
     *  然后SpringMVC会将表单中的值赋值给查询出来的
     *  LoginInfo对象并将其传递给此方法的入参中的"loginInfo"，
     *  最后再进行修改操作，这样才能保证LoginInfo对象中的
     *  密码属性不会被修改或者赋值为null。
     * @param loginInfo
     * @return
     */
    @RequestMapping(value = "/saveLoginInfo")
    public String updateLoginInfo(@ModelAttribute("loginInfo") LoginInfo loginInfo) {
        loginService.save(loginInfo);
        return "success";
    }

    /**
     * 测试日期数据类型转换
     * 使用@DateTimeFormat注解对出生日期进行格式转换;
     * 使用@NumberFormat注解对薪水进行数字格式转换;
     * @param employee
     * @return
     */
    @PostMapping(value = "/emp")
    public String saveEmployee(Employee employee) {
        System.out.println(employee);
        return "success";
    }

}
