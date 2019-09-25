package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {

	String result;

	ArrayList<ItemInfoDTO> itemInfoList =new ArrayList<ItemInfoDTO>();
	ItemListDAO dao =new ItemListDAO();

	public String execute() throws SQLException{
		result =SUCCESS;
		itemInfoList =dao.getItemInfo();
		return result;
	}



	public ArrayList<ItemInfoDTO> getItemInfoList(){
		return this.itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList){
		this.itemInfoList =itemInfoList;
	}



}
