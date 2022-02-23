package com.web.semi.login.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCRUD;

public class LoginDAO extends OracleCRUD {

	public LoginDTO select(String username) {
		String query = "SELECT * FROM USERS WHERE USER_UN = '" + username +"'";
		LoginDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);
			if(res.next()) {
				data = new LoginDTO(
						res.getString("USER_UN"),
						res.getString("USER_PW"));
			}
			res.close();
			occ.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("LoginDTO select() error");
		}
		return data;
	}
	
}
