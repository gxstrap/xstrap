package com.xuebusi.service;

import org.apache.shiro.session.mgt.SessionManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserService {
	
	@Autowired
	RedisSessionDAO redisSessionDAO;
	
	@Autowired
	SessionManager sessionManager;

}
