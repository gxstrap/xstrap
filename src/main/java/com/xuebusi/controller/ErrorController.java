package com.xuebusi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义错误页
 * Created by SYJ on 2017/11/5.
 */
@Controller
public class ErrorController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 找不到资源
     * @return
     */
    @GetMapping(value = "/404")
    public ModelAndView notFound() {
        return new ModelAndView("/404");
    }

    /**
     * 请求语法格式有误
     * @return
     */
    @GetMapping(value = "/400")
    public ModelAndView formatError() {
        return new ModelAndView("/400");
    }

    /**
     * 服务器内部错误
     * @return
     */
    @GetMapping(value = "/500")
    public ModelAndView serverError() {
        return new ModelAndView("/500");
    }
}
