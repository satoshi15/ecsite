package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	ArrayList<UserInfoDTO> userInfoDTO =new ArrayList<>();

	public ArrayList<UserInfoDTO> getUserInfo() throws SQLException{

		DBConnector db =new DBConnector();
		Connection con =db.getConnection();

		String sql ="SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();

			while(rs.next()){

				UserInfoDTO dto =new UserInfoDTO();

				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				userInfoDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return userInfoDTO;
	}

}
