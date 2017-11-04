package com.xuebusi.controller;

import com.xuebusi.entity.User;
import com.xuebusi.entity.WeiboUser;
import com.xuebusi.service.UserService;
import com.xuebusi.service.WeiboLoginService;
import com.xuebusi.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 微博登录
 * @author caiyuyu
 * @date 2017/10/31
 */

@Controller
@RequestMapping(value = "/weibo")
public class WeiboLoginController extends BaseController{

    @Autowired
    private WeiboLoginService weiboLoginService;

    @Autowired
    private UserService userService;

    private final static Logger LOGGER = LoggerFactory.getLogger(WeiboLoginController.class);

    /**
     * 授权页
     * @param request
     * @return
     */
    @GetMapping(value = "/boot")
    public ModelAndView authBoot(HttpServletRequest request)
    {
        return new ModelAndView("redirect:"+weiboLoginService.authBoot());
    }

    /**
     * 授权回调页
     * @param code
     * @param request
     * @return
     */
    @GetMapping(value = "/bind")
    public ModelAndView getAccessToken(@RequestParam("code") String code, HttpServletRequest request, HttpSession session)
        throws Exception
    {
        String redirect =  "/my/courses/learning";
        if (null != session.getAttribute("weibo_login_current_url"))
        {
            redirect = session.getAttribute("weibo_login_current_url").toString();
        }
        LOGGER.info("redirect url {}", redirect);

        if (StringUtils.isBlank(code))
        {
            LOGGER.error("error");
            return new ModelAndView("/");
        }
        WeiboUser weiboUser = weiboLoginService.weiboBind(code, this.getUserInfo());

        Map<String, Object> returnMap = new HashMap<>(16);
        if (weiboUser!=null)
        {
            // login
            User user = userService.findByUsername(weiboUser.getUsername());
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            request.getSession().setAttribute("user", userVo);
            returnMap.put("user", user);

            return new ModelAndView("redirect:"+redirect, returnMap);
        }
        else if(null!=this.getUserInfo())
        {
            returnMap.put("errorMsg", "微博帐号已经绑定用户!");

        }
        else
        {
            returnMap.put("errorMsg", "微博帐号绑定失败!");
        }
        return new ModelAndView("redirect:"+redirect, returnMap);
    }

    @GetMapping(value = "/unbind")
    public ModelAndView cancleBind(HttpServletRequest request)
    {
        Map<String, Object> returnMap = new HashMap<>(16);
        if (this.getUserInfo() != null)
        {
            weiboLoginService.cancelBind(this.getUserInfo().getUsername());
            returnMap.put("successMsg", "微博帐号解绑成功！");
        }
        else
        {
            returnMap.put("errorMsg", "请登录后重试！");
        }
        return new ModelAndView("/settings/binds", returnMap);
    }
}
