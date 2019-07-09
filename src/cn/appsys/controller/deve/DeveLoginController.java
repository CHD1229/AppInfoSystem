package cn.appsys.controller.deve;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.cache.NullCacheKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.deve.user.DevUserService;
import cn.appsys.tools.Constant;

@Controller
@RequestMapping("/dev/login")
public class DeveLoginController {
	@Resource
	private DevUserService devUserService;

	// 负责跳转到开发者平台的登录页面
	@RequestMapping("/login")
	public String login() {
		return "devlogin";
	}

	// 用于处理登录
	@RequestMapping("/doLogin")
	public String doLogin(HttpSession session, HttpServletRequest request, @RequestParam("devCode") String devCode,
			@RequestParam("devPassword") String devPassword) {
		DevUser devUser = devUserService.queryUserAndPwd(devCode, devPassword);
		if (devUser != null) { // 登录成功 ，将用户对象保存到session中
			session.setAttribute(Constant.DEV_USER_SESSION, devUser);
			return "developer/main";
		} else {
			request.setAttribute("error", "用户名或密码错误");
			return "devlogin";
		}
	}
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		//当前登录用户从session作用域中删除
		session.removeAttribute(Constant.DEV_USER_SESSION);
		return "devlogin";
	}
}
