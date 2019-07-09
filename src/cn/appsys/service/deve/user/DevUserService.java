package cn.appsys.service.deve.user;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	/**
	 * 根据开发者开发者帐号和开发者密码查询用户(登录功能)
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	DevUser queryUserAndPwd(String devCode,String devPassword);
}
