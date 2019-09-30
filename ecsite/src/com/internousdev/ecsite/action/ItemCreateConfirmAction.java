package com.internousdev.ecsite.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String message;
	Map<String, Object> session;
	String result;


	public String execute(){

		String regex ="^[0-9]*$";
		Pattern p =Pattern.compile(regex);
		Matcher price =p.matcher(itemPrice);
		Matcher stock =p.matcher(itemStock);

		if(!(itemName.equals(""))
				&& !(itemPrice.equals(""))
				&& !(itemStock.equals(""))
				){

			if(price.find() && stock.find()){
				session.put("itemName", itemName);
				session.put("itemPrice", itemPrice);
				session.put("itemStock", itemStock);
				result =SUCCESS;
			}
			else{
				setMessage("値段、在庫には数字を入力してください");
				result =ERROR;
			}

		}else{
			setMessage("未記入の項目があります。");
			result =ERROR;
		}
		return result;
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

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message =message;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session =session;
	}
}
