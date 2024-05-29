package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;

public class CustomerDAO extends DAO{
	
	public Customer search(String email, String password)
	throws Exception{
		Customer customer = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from login where email = ? and password = ?");
		st.setString(1, email);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			customer = new Customer();
			customer.setPassword(rs.getString("password"));
			customer.setEmail(rs.getString("email"));
		}
		
		st.close();
		con.close();
		return customer;
	}
}
