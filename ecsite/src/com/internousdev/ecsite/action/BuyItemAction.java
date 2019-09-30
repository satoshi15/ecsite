package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int count;
	private String pay;
	private int stock;
	private String message;

	public String execute(){

		String result =SUCCESS;

		session.put("count", count);
		int intCount =Integer.parseInt(session.get("count").toString());
		int intPrice =Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount * intPrice);
		String payment;

		BuyItemDAO dao =new BuyItemDAO();
		stock =dao.getBuyItemInfo().getStock();

		session.put("stock", stock);
		int intStock =(int)session.get("stock");
		session.put("total_stock", intStock - intCount);

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}

		if(intStock < intCount ){
			setMessage("在庫が足りません");
			result =ERROR;
		}

		return result;
	}

	public void setStock(int stock){
		this.stock =stock;
	}

	public void setCount(int count){
		this.count =count;
	}

	public void setPay(String pay){
		this.pay =pay;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message =message;
	}

	public void setSession(Map<String, Object> session){
		this.session =session;
	}

}
