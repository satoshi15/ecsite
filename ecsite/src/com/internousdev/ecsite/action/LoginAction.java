package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String message;
	private Map<String, Object> session;
	private LoginDAO loginDAO =new LoginDAO();
	private LoginDTO loginDTO =new LoginDTO();
	private BuyItemDAO buyItemDAO =new BuyItemDAO();

	public String execute(){

		String result =ERROR;
		loginDTO =loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result =SUCCESS;
			BuyItemDTO buyItemDTO =buyItemDAO.getBuyItemInfo();
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			if(((LoginDTO)session.get("loginUser")).getAdminFlg()){
				result ="admin";
				session.put("adminFlg", loginDTO.getAdminFlg());
			}
		}else{
			setMessage("ログインID、またはパスワードが間違っています。");
		}
		return result;

	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId =loginUserId;
	}

	public String getPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword =loginPassword;
	}

	public String getMessage(){
		return message;
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
