package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport {

	private String message;

	public String execute() throws SQLException{

		UserListDeleteCompleteDAO dao =new UserListDeleteCompleteDAO();
		int i =dao.userInfoDelete();

		if(i > 0){
			setMessage("ユーザー情報を削除しました");
		}else if(i == 0){
			setMessage("ユーザー情報を削除できませんでした");
		}
		return SUCCESS;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message =message;
	}

}
