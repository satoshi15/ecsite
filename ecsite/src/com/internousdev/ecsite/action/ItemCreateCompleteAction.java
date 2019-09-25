package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private Map<String, Object> session;

	ItemCreateCompleteDAO dao =new ItemCreateCompleteDAO();

	public String execute() throws SQLException{

		dao.itemCreate(session.get("itemName").toString(), session.get("itemPrice").toString(), session.get("itemStock").toString());

		return SUCCESS;

	}

	public String getItemName(){
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName =itemName;
	}

	public String getItemPrice(){
		return this.itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice =itemPrice;
	}

	public String getItemStock(){
		return this.itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock =itemStock;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session =session;
	}
}
