package cn.tarena.note.service;

import java.io.Serializable;

import cn.tarena.note.pojo.User;

public interface UserService extends Serializable {
	
	public User checkLogin(String name,String password);
}
