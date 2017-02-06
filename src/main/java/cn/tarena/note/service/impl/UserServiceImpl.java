package cn.tarena.note.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.note.mapper.UserMapper;
import cn.tarena.note.pojo.User;
import cn.tarena.note.service.UserService;
import cn.tarena.note.util.NameOrPasswordException;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 1L;
	@Resource
	UserMapper userMapper;
	
	public User checkLogin(String name, String password) {
		//入口参数检查
		if(name == null || name.trim().isEmpty()) {
			throw new NameOrPasswordException("用户名不能为空");
		}
		if(password == null || password.trim().isEmpty()) {
			throw new NameOrPasswordException("密码不能为空");
		}
		//从数据层查询用户的信息
		User user = userMapper.findUserByName(name);
		if(user==null) {
			throw new NameOrPasswordException("用户名或者密码错误");
		}
		if(user.getPassword().equals(password)) {
			return user;
		}
		throw new NameOrPasswordException("用户名那个或者密码错误");
	}

}
