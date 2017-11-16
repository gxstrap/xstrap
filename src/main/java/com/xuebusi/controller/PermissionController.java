package com.xuebusi.controller;

import com.alibaba.fastjson.JSON;
import com.xuebusi.entity.SysPermission;
import com.xuebusi.service.SysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 前端控制器
 */

@Controller
@RequestMapping(value = "permission")
public class PermissionController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	SysPermissionService sysPermissionService;

	// 跳转到用户管理页面
	@RequestMapping(value = "permissionPage")
	public String userPage(String edit, Model modle) {
		// edit判断是否编辑成功
		modle.addAttribute("edit", edit);
		return "permission/permission";
	}

	// 跳轉到編輯頁面edit
	@RequestMapping(value = "editPage/{Id}")
	public String editPage(@PathVariable("Id") String Id, Model model) {
		if (Id.equals("add")) {
		} else {
			SysPermission permission = null/*sysPermissionService.selectById(Id)*/;
			model.addAttribute("permission", permission);
		}
		return "permission/edit";
	}

	// 增加和修改
	@RequestMapping(value = "edit")
	public String edit(SysPermission permission, Model model) {
		if (true/*sysPermissionService.insertOrUpdate(permission)*/) {
			return "forward:permissionPage?edit=true";
		} else {
			return "forward:permissionPage?edit=false";
		}
	}

	// 刪除
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(@RequestParam(value = "ids[]") String[] ids) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//sysPermissionService.deleteBatchIds(Arrays.asList(ids));
			resultMap.put("flag", true);
			resultMap.put("msg", "刪除成功！");
		} catch (Exception e) {
			resultMap.put("flag", false);
			resultMap.put("msg", e.getMessage());
		}
		return JSON.toJSONString(resultMap);
	}
}
