package com.xuebusi.controller;

import com.xuebusi.common.utils.MD5Utils;
import com.xuebusi.common.vcode.Captcha;
import com.xuebusi.common.vcode.SpecCaptcha;
import com.xuebusi.entity.LoginInfo;
import com.xuebusi.entity.User;
import com.xuebusi.service.LoginService;
import com.xuebusi.service.UserService;
import com.xuebusi.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 登录
 * Created by SYJ on 2017/10/14.
 */
@Controller
@RequestMapping
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    /**
     * 跳转到注册页
     * @param map
     * @return
     */
    @GetMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request, Map<String, Object> map) {
        if (this.getUserInfo() != null) {
            return new ModelAndView(new RedirectView("/my/courses/learning"));
        }
        return new ModelAndView("/user/register", map);
    }

    /**
     * 跳转到登录页
     * @param map
     * @return
     */
    @GetMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, Map<String, Object> map) {
        if (this.getUserInfo() != null) {
            return new ModelAndView(new RedirectView("/my/courses/learning"));
        }
        return new ModelAndView("/user/login", map);
    }

    /**
     * 登录成功后的loading页
     * @param map
     * @return
     */
    /*@GetMapping(value = "/login/loading")
    public ModelAndView loginLoading(Map<String, Object> map) {
        return new ModelAndView("/user/login-loading", map);
    }*/

    /**
     * 跳转到密码重置页
     * @param map
     * @return
     */
    @GetMapping(value = "/reset")
    public ModelAndView reset(Map<String, Object> map) {
        return new ModelAndView("/user/reset", map);
    }

    /**
     * 退出登录
     * @param request
     * @param map
     * @return
     */
    @GetMapping(value = "/logout2")
    public ModelAndView logout2(HttpServletRequest request, Map<String, Object> map) {
        request.getSession().invalidate();
        return new ModelAndView("/user/login", map);
    }

    @PostMapping(value = "/register/captcha/check")
    public String check() {

        return "";
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping(value="/logout")
    public ModelAndView logout(){
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ModelAndView(new RedirectView("/login"));
    }

    /**
     * 手机注册获取验证码
     * @return
     */
    @PostMapping(value = "/register/captcha/modal")
    public String captcha() {
        return "";
    }

    /**
     * 获取验证码(PNG格式)
     * @param response
     */
    @RequestMapping(value="/login/captcha/check",method=RequestMethod.GET)
    public void getPngCode(HttpServletResponse response,HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            //Captcha captcha = new GifCaptcha(146,33,4);
            Captcha captcha = new SpecCaptcha(146, 33, 4);
            //输出
            captcha.out(response.getOutputStream());
            HttpSession session = request.getSession(true);
            //存入Session
            session.setAttribute("_code",captcha.text().toLowerCase());
        } catch (Exception e) {
            System.err.println("获取验证码异常："+e.getMessage());
        }
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping(value = "/login2")
    public ModelAndView login(@RequestParam("username")String username,
                             @RequestParam("password")String password,
                             HttpServletRequest request, Map<String, Object> map) {
        if (this.getUserInfo() != null){
            return new ModelAndView(new RedirectView("/my/courses/learning"), map);
        }

        LoginInfo loginInfo = loginService.findByUsername(username);

        if (loginInfo != null && loginInfo.getPassword().equals(MD5Utils.md5(password))) {
            User user = userService.findByUsername(username);
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            userVo.setTitleImgUrl(loginInfo.getTitleUrl());
            //登录后将用户信息放入Session
            request.getSession().setAttribute("user", userVo);
            map.put("user", userVo);
            return new ModelAndView(new RedirectView("/my/courses/learning"), map);
        }
        map.put("errMsg", "用户名或密码不正确");
        return new ModelAndView("/user/login", map);
    }

    /**
     * shiro登录
     *
     * @param username
     * @param password
     * @param request
     * @param map
     * @return
     */
    @PostMapping(value="/login")
    public ModelAndView submitLogin(@RequestParam("username")String username,
                                    @RequestParam("password")String password,
                                    @RequestParam("vcode")String vcode,
                                    HttpServletRequest request,
                                    Map<String, Object> map) {
        if (this.getUserInfo() != null){
            return new ModelAndView(new RedirectView("/my/courses/learning"), map);
        }

        if(vcode==null||vcode==""){
            map.put("errMsg", "验证码不能为空！");
            return new ModelAndView("/user/login", map);
        }

        Session session = SecurityUtils.getSubject().getSession();
        //转化成小写字母
        vcode = vcode.toLowerCase();
        String v = (String) session.getAttribute("_code");
        //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
        session.removeAttribute("_code");
        if(!vcode.equals(v)){
            map.put("errMsg", "验证码错误！");
            return new ModelAndView("/user/login", map);
        }

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password,false);
            SecurityUtils.getSubject().login(token);

            LoginInfo loginInfo = loginService.findByUsername(username);
            User user = userService.findByUsername(username);
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            userVo.setTitleImgUrl(loginInfo.getTitleUrl());
            //登录后将用户信息放入Session
            request.getSession().setAttribute("user", userVo);
            map.put("user", userVo);
            return new ModelAndView(new RedirectView("/my/courses/learning"), map);

        } catch (Exception e) {
            map.put("errMsg", "帐号或密码不正确！");
            return new ModelAndView("/user/login", map);
        }
    }


    /**
     * 用户注册
     * @param username
     * @param password
     * @param request
     * @param map
     * @return
     */
    @PostMapping(value = "/u/register")
    public ModelAndView register(@RequestParam("username")String username,
                                   @RequestParam("password")String password,
                                   HttpServletRequest request,
                                   Map<String, Object> map) {

        if (this.getUserInfo() != null) {
            return new ModelAndView(new RedirectView("/my/courses/learning"), map);
        }

        if (loginService.findByUsername(username) != null) {
            map.put("errMsg", "用户名已存在，请重新输入！");
            return new ModelAndView("/user/register", map);
        }

        //保存注册用户
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(username);
        loginInfo.setPassword(MD5Utils.md5(password));
        loginService.save(loginInfo);

        map.put("successMsg", "注册成功，请登录！");
        return new ModelAndView("/user/login", map);
    }

}
