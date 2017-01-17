package cn.tarena.note.mapper;

import cn.tarena.note.pojo.User;

public interface UserMapper {
	
	User findUserByName(String name);
}
