package com.xuebusi.service;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.xuebusi.controller.WeiboLoginController;
import com.xuebusi.entity.User;
import com.xuebusi.entity.WeiboUser;
import com.xuebusi.mapper.WeiboUserMapper;
import com.xuebusi.repository.UserRepository;
import com.xuebusi.repository.WeiboUserRepository;
import com.xuebusi.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caiyuyu
 * @date 2017/11/2
 */
@Service
public class WeiboLoginService {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeiboLoginController.class);

    @Value("${weibo-auth-url}")
    private String weiboAuthUrl;

    @Value("${weibo-token-url}")
    private String weiboTokenUrl;

    @Value("${weibo-client-id}")
    private String weiboClientId;

    @Value("${weibo-client-sercret}")
    private String weiboClientSercret;

    @Value("${weibo-redirect-url}")
    private String weiboRedirectUrl;

    @Value("${weibo-user-url}")
    private String weiboUserUrl;

    @Autowired
    private UserService userService;

    @Autowired
    private WeiboUserRepository weiboUserRepository;

    @Autowired
    private WeiboUserMapper weiboUserMapper;

    @Autowired
    private UserRepository userRepository;


    public String authBoot()
    {
        StringBuffer url = new StringBuffer(weiboAuthUrl);
        url.append("?client_id="+weiboClientId);
        url.append("&redirect_uri="+weiboRedirectUrl);
        url.append("&response_type=code");
        return url.toString();
    }
    public UserVo weiboLogin(String code)
    {
        // access token
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("code", code);
        paramMap.put("grant_type", "authorization_code");
        paramMap.put("client_id", weiboClientId);
        paramMap.put("client_secret", weiboClientSercret);
        paramMap.put("redirect_uri", weiboRedirectUrl);
        String result = HttpRequest.post(weiboTokenUrl).form(paramMap).body();
        JSONObject resultObj = JSONObject.parseObject(result);
        String token = resultObj.getString("access_token");
        String uid = resultObj.getString("uid");
        LOGGER.info("uid: {} token: {}", uid, token);

        Map<String, Object> weiboinfoMap = weiboUserMapper.findWeiboInfoByToken(token);
        String weiboId = null;

        User user = null;
        // if not exist
        if (weiboinfoMap==null){
            Map<String, String> userMap = new HashMap<>(16);
            userMap.put("access_token", token);
            userMap.put("uid", uid);
            String userResult = HttpRequest.get(weiboUserUrl, userMap, false).body();
            JSONObject userObj = JSONObject.parseObject(userResult);

            String userId = userObj.getString("idstr");
            String userName = userObj.getString("name");

            try {
                // add to user table
                user = new User();
                user.setUsername(userId);
                user.setTruename(userName);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                user.setWeibo("http://weibo.com/"+userId+"/info");
                userService.save(user);

                // add to weibo table
                WeiboUser weiboUser = new WeiboUser();
                weiboUser.setWeiboId(userId);
                weiboUser.setAccessToken(token);
                weiboUser.setCreateTime(new Date());
                weiboUser.setUpdateTime(new Date());
                weiboUser.setState(1);
                weiboUserRepository.save(weiboUser);
                weiboId = userId;

            }
            catch (Exception e){
                LOGGER.error("error{}", e.getMessage());
            }
        }
        else {
            weiboId = weiboinfoMap.get("weiboId").toString();
        }

        // copy to userVo
        user = userRepository.findByUsername(weiboId);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);

        return userVo;
    }

}
