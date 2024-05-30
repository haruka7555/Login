package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Login;

public class LoginDAO extends DAO{
	
	public Login search(String name, String email, String password)
	throws Exception{
		Login login = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from login where email = ? and password = ?");
		st.setString(1, email);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			login = new Login();
			login.setId(rs.getInt("id"));
			login.setName(rs.getString("name"));
			login.setPassword(rs.getString("password"));
			login.setEmail(rs.getString("email"));
		}
		
		st.close();
		con.close();
		return login;
	}
}
