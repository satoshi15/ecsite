package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector =new DBConnector();
	private Connection connection =dbConnector.getConnection();
	private LoginDTO loginDTO =new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){

		String sql ="SELECT * FROM login_user_transaction "
				+ "WHERE login_id =? AND login_pass =?";

		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet =preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				if(resultSet.getString("login_id") != null){
					loginDTO.setLoginFlg(true);

					if(resultSet.getString("admin_flg") != null){
						loginDTO.setAdminFlg(true);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

}
