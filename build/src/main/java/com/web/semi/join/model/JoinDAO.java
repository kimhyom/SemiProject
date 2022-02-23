package com.web.semi.join.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCRUD;

public class JoinDAO extends OracleCRUD {

	public JoinDTO select(String username) {
		String query = "SELECT * FROM USERS WHERE USER_UN = '"+username+"'";
		JoinDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);
			if(res.next()) {
				data = new JoinDTO(
						res.getInt("USER_ID"),
						res.getString("USER_UN"),
						res.getString("USER_PW"));
			}
			res.close();
			occ.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO select() 메서드 동작 에러 발생");
		}
		return data;
	}
	
	public boolean insert(JoinDTO dto) {
		String query = "INSERT INTO USERS VALUES("
				+ "USERS_SEQ.NEXTVAL, "
				+ "'"+dto.getUsername()+"', "
				+ "'"+dto.getPassword()+"')";
		int res = 0;
		try {
			res = occ.insertQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO insert() 메서드 동작 에러 발생");
		}
		
		return res == 1 ? true : false;
	}

}
