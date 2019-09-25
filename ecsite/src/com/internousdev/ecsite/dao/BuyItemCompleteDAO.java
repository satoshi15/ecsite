package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {


	DBConnector dbConnector =new DBConnector();
	Connection connection =dbConnector.getConnection();

	public int buyItemInfo(String item_transaction_id,String total_price,
			String total_count, String user_master_id, String pay)
			throws SQLException{

		int result =0;

		DateUtil dateUtil =new DateUtil();

		String sql ="INSERT INTO user_buy_item_transaction "
				+ "(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) "
				+ "VALUES(?,?,?,?,?,?)";

		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());

			preparedStatement.executeUpdate();
			result =1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;

	}

	public void itemInfoUpdate(String totalStock, int id)
			throws SQLException{
		connection =dbConnector.getConnection();

		String sql ="UPDATE item_info_transaction SET item_stock =? WHERE id=?";

		try{
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, totalStock );
			ps.setInt(2, id);

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}
