package com.xuebusi.controller;

import com.xuebusi.service.WeiboLoginService;
import com.xuebusi.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 微博登录
 * @author caiyuyu
 * @date 2017/10/31
 */

@Controller
@RequestMapping
public class WeiboLoginController extends BaseController{

    @Autowired
    private WeiboLoginService weiboLoginService;

    private final static Logger LOGGER = LoggerFactory.getLogger(WeiboLoginController.class);

    /**
     * 授权页
     * @param request
     * @return
     */
    @GetMapping(value = "/login/bind/weibo")
    public ModelAndView authBoot(HttpServletRequest request)
    {
        return new ModelAndView(new RedirectView(weiboLoginService.authBoot()));
    }

    /**
     * 授权回调页
     * @param code
     * @param request
     * @return
     */
    @GetMapping(value = "/login/bind/weibo/token")
    public ModelAndView getAccessToken(@RequestParam("code") String code, HttpServletRequest request)
        throws Exception
    {
        // already login
        if (this.getUserInfo() != null){
            Map<String, Object> tempMap = new HashMap<>(16);
            tempMap.put("user", this.getUserInfo());
            return new ModelAndView(new RedirectView("/my/courses/learning"), tempMap);
        }

        if (StringUtils.isBlank(code)){
            LOGGER.error("error");
            return new ModelAndView("/");
        }
        UserVo userVo = weiboLoginService.weiboLogin(code);

        Map<String, Object> returnMap = new HashMap<>(16);
        if (userVo!=null){
            request.getSession().setAttribute("user", userVo);
            returnMap.put("user", userVo);
            return new ModelAndView(new RedirectView("/my/courses/learning"), returnMap);
        }
        else {
            returnMap.put("errMsg", "微博登录失败，请重试");
            return new ModelAndView("/user/login", returnMap);
        }
    }
}
