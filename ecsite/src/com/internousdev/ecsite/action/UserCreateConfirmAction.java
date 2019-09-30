package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;
	private String errorMessage;

	public String execute() throws SQLException{

		String result =SUCCESS;
		UserCreateConfirmDAO dao =new UserCreateConfirmDAO();
		int i =dao.userCreateConfirm(loginUserId);

		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))
				){

			if(i == 1){
				setErrorMessage("既に登録されているログインIDです。");
				result =ERROR;
			}else{
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			}

		}else{
			setErrorMessage("未記入の項目があります。");
			result =ERROR;
		}
		return result;
	}

	public String getLoginUserId(){
		return this.loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId =loginUserId;
	}

	public String getLoginPassword(){
		return this.loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword =loginPassword;
	}

	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName =userName;
	}

	public String getErrorMessage(){
		return this.errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage =errorMessage;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session =session;
	}
}
