package com.web.semi.replyboard.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;

public class ReplyBoardDAO {
	OracleCloudConnect occ = null;
	
	public ReplyBoardDAO() throws SQLException {
		this.occ = new OracleCloudConnect();
		this.occ.connection();
	}
	
	
	
	public void commit() throws SQLException {
		occ.commit();
	}
	public void rollback() throws SQLException {
		occ.rollback();
	}


	public boolean insert(String userName, String r_context,int boardNo) {
		String query = "INSERT INTO REPLYBOARD VALUES("
				+ "REPLYBOARD_SEQ.NEXTVAL,"
				+ "'" + r_context + "', "
				+ "SYSDATE, "
				+ "'" + userName+"', "
				+ boardNo+")";
		System.out.println(query);
		
		int res=0;
		
			try {
				res = occ.insertQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return res == 1 ? true : false;

	}

	public List<ReplyBoardDTO> select(int no) throws SQLException  {
		List<ReplyBoardDTO> datas = new ArrayList<ReplyBoardDTO>();
		ResultSet res=null;
		String query = "SELECT * FROM REPLYBOARD where BOARDNO="+no+"ORDER BY R_DATE";
		
		System.out.println(query);
		res = occ.sendQuery(query);
		while(res.next()) {
				ReplyBoardDTO dto = new ReplyBoardDTO();
				dto.setId(res.getInt("R_ID"));
				dto.setR_context(res.getString("R_CONTENT"));
				dto.setDate(res.getDate("R_DATE"));
				dto.setNickname(res.getString("USER_UN"));
				dto.setBoardNo(res.getInt("BOARDNO"));
				datas.add(dto);
		}
		if(datas.isEmpty()) {
		System.out.println("성");
		}
		res.close();
		occ.close();
	
		
		return datas;
	}

	public void close() throws SQLException{
		// TODO Auto-generated method stub
		occ.close();
	}
	
	


	public int deleteReply(int boardNo)throws SQLException {
		String query = "DELETE FROM REPLYBOARD"
				+ " WHERE R_ID = '" +boardNo+ "'";
		int res = 0;
		try {
			res = occ.deleteQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res == 1 ? 1 : 0;
		
	}
	
	
	
}