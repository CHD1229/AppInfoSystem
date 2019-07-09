package cn.appsys.service.deve.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.deve.user.DevUserMapper;
import cn.appsys.pojo.DevUser;
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper devUserMapper;
	@Override
	public DevUser queryUserAndPwd(String devCode, String devPassword) {
		return devUserMapper.queryUserAndPwd(devCode, devPassword);
	}

}
