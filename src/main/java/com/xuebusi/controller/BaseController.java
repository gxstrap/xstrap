package com.xuebusi.controller;

import com.xuebusi.common.utils.CommonUtils;
import com.xuebusi.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by SYJ on 2017/10/23.
 */
public class BaseController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 获取HttpServletRequest
     * @return
     */
    public HttpServletRequest getHttpServletRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 获取ServletContext
     * @return
     */
    public ServletContext getServletContext(){
        HttpServletRequest request = this.getHttpServletRequest();
        return request.getServletContext();
    }

    /**
     * 获取IP地址
     * @return
     */
    public String getIpAddr(){
        HttpServletRequest request = this.getHttpServletRequest();
        return CommonUtils.getIpAddr(request);
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    public UserVo getUserInfo(){
        HttpServletRequest request = this.getHttpServletRequest();
        UserVo user = (UserVo) request.getSession().getAttribute("user");
        return user != null ? user : null;
    }

}
