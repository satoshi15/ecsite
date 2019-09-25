package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	String result;
	UserListDAO dao =new UserListDAO();
	ArrayList<UserInfoDTO> userInfoList =new ArrayList<>();

	public String execute() throws SQLException{
		userInfoList =dao.getUserInfo();
		result =SUCCESS;
		return result;
	}
	
	public ArrayList<UserInfoDTO> getUserInfoList(){
		return this.userInfoList;
	}
	public void set(ArrayList<UserInfoDTO> userInfoList){
		this.userInfoList =userInfoList;
	}

}
