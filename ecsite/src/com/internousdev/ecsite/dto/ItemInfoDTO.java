package com.internousdev.ecsite.dto;

public class ItemInfoDTO {

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id =id;
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

}
