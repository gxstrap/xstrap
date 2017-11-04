package com.xuebusi.service;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.xuebusi.controller.WeiboLoginController;
import com.xuebusi.entity.LoginInfo;
import com.xuebusi.entity.User;
import com.xuebusi.entity.WeiboUser;
import com.xuebusi.mapper.WeiboUserMapper;
import com.xuebusi.repository.LoginRepository;
import com.xuebusi.repository.UserRepository;
import com.xuebusi.repository.WeiboUserRepository;
import com.xuebusi.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private LoginRepository loginRepository;


    public String authBoot()
    {
        StringBuffer url = new StringBuffer(weiboAuthUrl);
        url.append("?client_id="+weiboClientId);
        url.append("&redirect_uri="+weiboRedirectUrl);
        url.append("&response_type=code");
        return url.toString();
    }
    public WeiboUser weiboBind(String code, UserVo userVo)
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
        WeiboUser weiboUser = weiboUserRepository.findByWeiboIdAndState(uid, 1);

        // if not exist
        if (weiboinfoMap==null){
            Map<String, String> userMap = new HashMap<>(16);
            userMap.put("access_token", token);
            userMap.put("uid", uid);
            String userResult = HttpRequest.get(weiboUserUrl, userMap, false).body();
            JSONObject userObj = JSONObject.parseObject(userResult);

            String userId = userObj.getString("idstr");
            String nickName = userObj.getString("name");

            User tempUser = userService.findByUsername(userId);

            if (userVo != null)
            {
                userId = userVo.getUsername();
            }
            else if(weiboUser==null && tempUser==null)
            {
                // insert to user table
                User user = new User();
                user.setUsername(userId);
                user.setTruename(nickName);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                user.setWeibo("http://weibo.com/"+userObj.getString("idstr")+"/info");
                userService.save(user);

                // insert to login_ifo table
                LoginInfo loginInfo = new LoginInfo();
                loginInfo.setUsername(userId);
                loginInfo.setCreateTime(new Date());
                loginInfo.setUpdateTime(new Date());
                loginInfo.setPassword("");
                loginRepository.save(loginInfo);
            }

            // insert or update
            if (null == weiboUser)
            {
                weiboUser = new WeiboUser();
                weiboUser.setUsername(userId);
                weiboUser.setWeiboId(userObj.getString("idstr"));
                weiboUser.setCreateTime(new Date());
            }
            weiboUser.setAccessToken(token);
            weiboUser.setUpdateTime(new Date());
            weiboUser.setState(1);
            weiboUserRepository.save(weiboUser);
            return weiboUser;
        }
        if (weiboinfoMap!=null && weiboUser!=null)
        {
            return weiboUser;
        }

        return null;
    }

    public WeiboUser findWeiboUserByUsername(String username)
    {
        return weiboUserRepository.findByUsernameAndState(username, 1);
    }

    public void cancelBind(String username)
    {
        WeiboUser weiboUser = weiboUserRepository.findByUsernameAndState(username, 1);
        weiboUser.setState(0);
        weiboUserRepository.save(weiboUser);
    }

}
