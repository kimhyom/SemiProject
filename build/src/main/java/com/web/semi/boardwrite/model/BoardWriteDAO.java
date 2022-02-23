package com.web.semi.boardwrite.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.jspweb.dbconn.*;

public class BoardWriteDAO extends OracleCRUD {
	BoardWriteDTO dto = null;
	
	public boolean insert(BoardWriteDTO dto) { //테이블 데이터 삽입
		String query = "INSERT INTO NOTICEBOARD VALUES ("
					+ getNext()+", "
					+ "'" + dto.getCity() + "', "
					+ "'" + dto.getHobbp() + "', "
					+ "'" + dto.getTitle() + "', "
					+ "'" + dto.getContext() + "', "
					+ "SYSDATE,"
					+ "'" + dto.getNickname() + "')";
		int res = 0;
		try {
			res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardWriteDAO insert() error");
		}
		
		return res == 1 ? true : false;
	}
	
	public int getNext() { // 마지막 글 번호 가져오기
		dto = new BoardWriteDTO();
		String query = "SELECT N_ID FROM NOTICEBOARD ORDER BY N_ID DESC";
		try {
			ResultSet res = occ.sendQuery(query);
			if(res.next()) {
				dto.setId(res.getInt("N_ID")+1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardWriteDAO getNext() error");
		}
		return dto.getId();
	}

	public List<BoardWriteDTO> select() throws SQLException { // 목록리스트 나열
		List<BoardWriteDTO> datas = new ArrayList<BoardWriteDTO>();
		
		String query = "SELECT * FROM NOTICEBOARD ORDER BY N_DATE DESC";
		ResultSet res = occ.sendQuery(query);
		
		while(res.next()) {
			BoardWriteDTO dto = new BoardWriteDTO();
			dto.setId(res.getInt("N_ID"));
			dto.setCity(res.getString("N_CITY"));
			dto.setHobbp(res.getString("N_CATEGORY"));
			dto.setTitle(res.getString("N_TITLE"));
			dto.setDate(res.getDate("N_DATE"));
			dto.setNickname(res.getString("USER_UN"));
			
			datas.add(dto);
		}
		res.close();
		occ.close();
		
		return datas;
	}
	
	public BoardWriteDTO select(int no) { // 상세게시글
		BoardWriteDTO noData = new BoardWriteDTO();
		
		String query = "SELECT * FROM NOTICEBOARD WHERE N_ID = "+no;
		
		try {
			ResultSet res = occ.sendQuery(query);
			if(res.next()) {
				noData.setResultSet(res); // 상세게시글에 반영될 내용들
			}
			res.close();
			occ.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardWriteDAO select() error");
		}
		
		return noData;
	}

	public boolean update(BoardWriteDTO newData) {
		String query = "UPDATE NOTICEBOARD SET"
				+ " N_ID = "+getNext()+","
				+ " N_TITLE = '"+newData.getTitle()+"',"
				+ " N_CONTENT = '"+newData.getContext()+"',"
				+ " N_DATE = SYSDATE"
				+ " WHERE N_ID = "+newData.getId()+"";
		int res = 0;
		try {
			res = occ.updateQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardWriteDAO update() error");
		}
		
		return res == 1 ? true : false;
	}

	public boolean delete(BoardWriteDTO dto) {
		String query = "DELETE FROM NOTICEBOARD WHERE N_ID = "+dto.getId()+"";
		int res=0;
		try {
			res=occ.deleteQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardWriteDAO delete() error");
		}
		return res == 1 ? true : false;
	}
	
}
