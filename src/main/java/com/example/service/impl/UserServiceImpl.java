package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(User user) {
		
		return userMapper.insertSelective(user);
	}
	
	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Override
	public int delete(int userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}
	
	@Override
	public User selectOne(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int resetpwd(User user) {
		return userMapper.resetpwd(user);
		
	}

	@Override
	public String getPassword(String username) {
		return userMapper.getPassword(username);
		
	}
	
	@Override
	public User userLogin(User user) {
		return userMapper.userLogin(user);
	}
	
	@Override
	public int updateAvatar(User user) {
		return userMapper.updateAvatar(user);
	}
	
	@Override
	public User getUserByLoginName(User user) {
		return userMapper.getUserByLoginName(user);
	}
	
	
}