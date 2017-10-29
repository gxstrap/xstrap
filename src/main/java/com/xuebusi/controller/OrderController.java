package com.xuebusi.controller;

import com.xuebusi.entity.Course;
import com.xuebusi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 订单
 * Created by SYJ on 2017/10/29.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private CourseService courseService;

    /**
     * 订单确认页
     * /order/show?targetId=1024&targetType=course
     * @param map
     * @return
     */
    @GetMapping(value = "/show")
    public ModelAndView orderShow(@RequestParam("targetId") Integer targetId,
                                  @RequestParam("targetType") String targetType,
                                  Map<String, Object> map) {

        Course course = courseService.findOne(targetId);
        map.put("course", course);
        return new ModelAndView("/order/order-show", map);
    }
}
