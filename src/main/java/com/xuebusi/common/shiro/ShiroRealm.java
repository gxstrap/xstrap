package com.xuebusi.common.shiro;

import com.xuebusi.entity.LoginInfo;
import com.xuebusi.entity.SysUser;
import com.xuebusi.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * shiro身份校验核心类
 */

public class ShiroRealm extends AuthorizingRealm {

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
		String username = token.getUsername();

		// 从数据库获取对应用户名密码的用户
		LoginInfo loginInfo = loginService.findByUsername(username);
		if (loginInfo != null) {
			Object credentials = loginInfo.getPassword();//数据库中的密码
			ByteSource credentialsSalt = ByteSource.Util.bytes(username);//用户名作为盐值
			String realm = getName();//当前Realm对象的名字
			return new SimpleAuthenticationInfo(loginInfo.getUsername(), credentials, credentialsSalt, realm);
		}else {
			throw new AccountException("帐号或密码不正确！");
		}
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限认证方法：ShiroRealm.doGetAuthorizationInfo()");
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
