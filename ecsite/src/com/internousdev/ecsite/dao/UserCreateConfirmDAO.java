package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class UserCreateConfirmDAO {

	public int userCreateConfirm(String loginUserId) throws SQLException{

		int result =0;
		LoginDTO dto =new LoginDTO();
		DBConnector db =new DBConnector();
		Connection con =db.getConnection();

		String sql ="SELECT * FROM login_user_transaction WHERE login_id=?";

		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs =ps.executeQuery();

			if(rs.next()){
			dto.setLoginId(rs.getString("login_id"));
			result =1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
