package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport {

	private String message;
	String result;
	ItemListDeleteCompleteDAO dao =new ItemListDeleteCompleteDAO();

	public String execute() throws SQLException{

		int i =dao.itemInfoDelete();

		if(i > 0){
			setMessage("商品情報を削除しました。");
		}else if(i == 0){
			setMessage("商品情報を削除できませんでした。");
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
