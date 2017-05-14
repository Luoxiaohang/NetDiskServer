package com.yun.domain;

import com.yun.exception.MsgException;


public class User {
	private String username;
	private String password;
	private String password2;
	private String nickname;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void checkData() throws MsgException{
		if(username == null || "".equals(username.trim())){
			throw new MsgException("�û�������Ϊ�գ���");
		}
		if(password == null || "".equals(password.trim())){
			throw new MsgException("���벻��Ϊ�գ���");
		}
		if(password2 == null || "".equals(password2.trim())){
			throw new MsgException("ȷ�����벻��Ϊ�գ���");
		}if(!password.equals(password2)){
			throw new MsgException("�������벻һ�£���");
		}
		if(nickname == null || "".equals(nickname.trim())){
			throw new MsgException("�ǳƲ���Ϊ�գ���");
		}
		if(email == null || "".equals(email.trim())){
			throw new MsgException("���䲻��Ϊ�գ���");
		}
		if(!email.matches("^\\w+@\\w+(\\.\\w+)+$")){
			throw new MsgException("�����ʽ����ȷ����");
		}
		
		
	}
	
}