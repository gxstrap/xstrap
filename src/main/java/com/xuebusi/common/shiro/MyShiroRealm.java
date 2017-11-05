package com.xuebusi.common.shiro;

import com.xuebusi.common.utils.MD5Utils;
import com.xuebusi.entity.LoginInfo;
import com.xuebusi.entity.SysUser;
import com.xuebusi.service.LoginService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * shiro身份校验核心类
 */

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private LoginService loginService;

	/**
	 * 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 * 
	 * @param authcToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String name = token.getUsername();
		String password = String.valueOf(token.getPassword());

		// 从数据库获取对应用户名密码的用户
		LoginInfo loginInfo = loginService.findByUsername(name);

		if (null == loginInfo || !loginInfo.getPassword().equals(MD5Utils.md5(password))) {
			throw new AccountException("帐号或密码不正确！");
		}
		Logger.getLogger(getClass()).info("身份认证成功，登录用户：" + name);
		return new SimpleAuthenticationInfo(loginInfo, password, getName());
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		String userId = user.getId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		//根据用户ID查询角色（role），放入到Authorization里。
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", userId);
		List<SysRole> roleList = sysRoleService.selectByMap(map);
		Set<String> roleSet = new HashSet<String>();
		for(SysRole role : roleList){
			roleSet.add(role.getType());
		}*/
		Set<String> roleSet = new HashSet<String>();
		roleSet.add("100002");
		info.setRoles(roleSet);
		//根据用户ID查询权限（permission），放入到Authorization里。
		/*List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
		Set<String> permissionSet = new HashSet<String>();
		for(SysPermission Permission : permissionList){
			permissionSet.add(Permission.getName());
		}*/
		Set<String> permissionSet = new HashSet<String>();
		permissionSet.add("权限添加");
		permissionSet.add("权限删除");
		info.setStringPermissions(permissionSet);
        return info;
	}
}
