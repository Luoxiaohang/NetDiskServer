package com.yun.service;

import java.sql.SQLException;

import com.yun.dao.UserDao;
import com.yun.domain.User;
import com.yun.exception.MsgException;

public class UserService {
	com.yun.dao.UserDao dao = new UserDao();
	//检查用户名密码是否正确
	public User isUsernameAndPsw(String username,String password) throws SQLException{
		User user = dao.findUser(username);		
		if(user.getUsername() == null || !user.getPassword().equals(password)){
			//用户名不存在或密码不正确
			return null;
		}
		return user;
	}
	
	//注册用户
	public void registUser(User user) throws MsgException, SQLException{
		//检查用户名是否已经存在
		User findUser = dao.findUser(user.getUsername());
		if(findUser.getUsername()!=null){
			throw new MsgException("用户名已经存在！！");
		}		
		//调用dao中的方法向数据库中增加用户
		dao.addUser(user);
	}
}
