package com.example.mapper;


import com.example.model.User;

public interface UserMapper {
	
	int insertSelective(User user);
	int updateByPrimaryKeySelective(User user);
	int deleteByPrimaryKey(int userId);
	User selectByPrimaryKey(int userId);
	int resetpwd(User user);
	String getPassword(String username);
	User userLogin(User user);
	int updateAvatar(User user);
	
	User getUserByLoginName(User user);
}
