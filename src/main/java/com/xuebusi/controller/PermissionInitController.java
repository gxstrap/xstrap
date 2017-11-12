package com.xuebusi.controller;

import com.alibaba.fastjson.JSON;
import com.xuebusi.entity.SysPermissionInit;
import com.xuebusi.service.SysPermissionInitService;
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
 * <p>
 * 前端控制器
 * </p>
 *
 * @author z77z
 * @since 2017-03-11
 */

@Controller
@RequestMapping(value = "permissionInit")
public class PermissionInitController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	SysPermissionInitService sysPermissionInitService;

	// 跳转到用户管理页面
	@RequestMapping(value = "permissionInitPage")
	public String userPage(String edit, Model modle) {
		// edit判断是否编辑成功
		modle.addAttribute("edit", edit);
		return "permissionInit/permissionInit";
	}

	// 跳轉到編輯頁面edit
	@RequestMapping(value = "editPage/{Id}")
	public String editPage(@PathVariable("Id") String Id, Model model) {
		if (Id.equals("add")) {
		} else {
			SysPermissionInit permissionInit = null/*sysPermissionInitService.selectById(Id)*/;
			model.addAttribute("permissionInit", permissionInit);
		}
		return "permissionInit/edit";
	}

	// 增加和修改
	@RequestMapping(value = "edit")
	public String edit(SysPermissionInit permissionInit, Model model) {
		if (true/*sysPermissionInitService.insertOrUpdate(permissionInit)*/) {
			return "forward:permissionInitPage?edit=true";
		} else {
			return "forward:permissionInitPage?edit=false";
		}
	}

	// 刪除
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(@RequestParam(value = "ids[]") String[] ids) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//sysPermissionInitService.deleteBatchIds(Arrays.asList(ids));
			resultMap.put("flag", true);
			resultMap.put("msg", "刪除成功！");
		} catch (Exception e) {
			resultMap.put("flag", false);
			resultMap.put("msg", e.getMessage());
		}
		return JSON.toJSONString(resultMap);
	}
}
