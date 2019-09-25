package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;


public class UserListDeleteCompleteDAO {

	public int userInfoDelete() throws SQLException {

		int result =0;
		DBConnector db =new DBConnector();
		Connection con =db.getConnection();

		String sql="DELETE FROM login_user_transaction WHERE admin_flg IS NULL ";

		try{
			PreparedStatement ps =con.prepareStatement(sql);
			result =ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
