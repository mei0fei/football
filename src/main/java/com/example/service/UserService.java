package com.example.service;

import java.util.List;

import com.example.model.User;


public interface UserService {
	
	/**
	 * 注册用户
	 * @param user
	 */
	public int insert(User user);
	
	//更新用户信息
	public int update(User user);
	
	//删除用户信息
	public int delete(int userId);
	
	//查询一个用户
	public User selectOne(int userId);
	
	//重新设置用户密码
	public int resetpwd(User user);
	
	//获取用户密码
	public String getPassword(String username);
	
	//用户登录
	public User userLogin(User user);
	
	//更新用户的头像
	public int updateAvatar(User user);
	
	//根据登录名获取用户信息， 含头像信息		
	public User getUserByLoginName(User user);
}
