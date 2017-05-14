package com.yun.service;

import java.sql.SQLException;

import com.yun.dao.UserDao;
import com.yun.domain.User;
import com.yun.exception.MsgException;

public class UserService {
	com.yun.dao.UserDao dao = new UserDao();
	//����û��������Ƿ���ȷ
	public User isUsernameAndPsw(String username,String password) throws SQLException{
		User user = dao.findUser(username);		
		if(user.getUsername() == null || !user.getPassword().equals(password)){
			//�û��������ڻ����벻��ȷ
			return null;
		}
		return user;
	}
	
	//ע���û�
	public void registUser(User user) throws MsgException, SQLException{
		//����û����Ƿ��Ѿ�����
		User findUser = dao.findUser(user.getUsername());
		if(findUser.getUsername()!=null){
			throw new MsgException("�û����Ѿ����ڣ���");
		}		
		//����dao�еķ��������ݿ��������û�
		dao.addUser(user);
	}
}
