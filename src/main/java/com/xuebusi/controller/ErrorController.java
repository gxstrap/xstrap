package com.xuebusi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义错误页
 * Created by SYJ on 2017/11/5.
 */
@Controller
public class ErrorController {

    @GetMapping(value = "/404")
    public ModelAndView notFound() {
        return new ModelAndView("/404");
    }

    @GetMapping(value = "/500")
    public ModelAndView serverError() {
        return new ModelAndView("/500");
    }
}
