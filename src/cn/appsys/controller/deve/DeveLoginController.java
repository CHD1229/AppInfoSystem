package cn.appsys.controller.deve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev/login")
public class DeveLoginController {
	//负责跳转到开发者平台的登录页面
	@RequestMapping("/login")
	public  String login() {
		return "devlogin";
	}
}
