package com.xuebusi.controller;

import com.xuebusi.entity.User;
import com.xuebusi.service.UserService;
import com.xuebusi.vo.UserFormVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 个人设置
 * Created by SYJ on 2017/10/28.
 */
@Controller
@RequestMapping(value = "/settings")
public class SettingController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 基础信息
     *
     * @param map
     * @return
     */
    @GetMapping
    public ModelAndView settings(HttpServletRequest request, Map<String, Object> map) {
        if (this.getUserInfo() != null) {
            //显示最新基础信息
            User user = userService.findByUsername(this.getUserInfo().getUsername());
            request.getSession().setAttribute("user", user);
            map.put("user", user);
            return new ModelAndView("/settings/settings", map);
        }
        return new ModelAndView(new RedirectView("redirect:/user/login"));
    }

    /**
     * 保存基础信息
     *
     * @param map
     * @return
     */
    @PostMapping
    public ModelAndView saveSettings(UserFormVo userFormVo, HttpServletRequest request, Map<String, Object> map) {
        if (this.getUserInfo() != null && this.getUserInfo().getUsername().equals(userFormVo.getUsername())) {
            User user = userService.findByUsername(userFormVo.getUsername());
            if (user == null) {
                user = new User();
            }
            if (StringUtils.isEmpty(userFormVo.getUsername())) {
                user.setUsername(this.getUserInfo().getUsername());
            }
            BeanUtils.copyProperties(userFormVo, user);
            User userFromDb = userService.save(user);
            map.put("successMsg", "基础信息保存成功");
            map.put("user", userFromDb);//回显最新数据
            return new ModelAndView("/settings/settings", map);
        }
        return new ModelAndView(new RedirectView("redirect:/user/login"));
    }

    /**
     * 头像设置
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/avatar")
    public ModelAndView avatar(Map<String, Object> map) {

        return new ModelAndView("/settings/avatar", map);
    }

    /**
     * 上传头像
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/avatar")
    public ModelAndView uploadAvatar(Map<String, Object> map) {

        return new ModelAndView("/settings/avatar", map);
    }

    /**
     * 实名认证
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/approval/submit")
    public ModelAndView approval(Map<String, Object> map) {

        return new ModelAndView("/approval", map);
    }

    /**
     * 安全设置
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/security")
    public ModelAndView security(Map<String, Object> map) {

        return new ModelAndView("/security", map);
    }

    /**
     * 邮箱设置
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/email")
    public ModelAndView email(Map<String, Object> map) {

        return new ModelAndView("/email", map);
    }

    /**
     * 第三方登录
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/binds")
    public ModelAndView binds(Map<String, Object> map) {

        return new ModelAndView("/binds", map);
    }

    /**
     * 绑定手机
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/bind_mobile")
    public ModelAndView bindMobile(Map<String, Object> map) {

        return new ModelAndView("/bind_mobile", map);
    }
}
