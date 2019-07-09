package cn.appsys.dao.deve.user;
/**
 * 开发者平台对应的用户接口
 *
 */

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	/**
	 * 根据开发者开发者帐号和开发者密码查询用户(登录功能)
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	DevUser queryUserAndPwd(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
}
