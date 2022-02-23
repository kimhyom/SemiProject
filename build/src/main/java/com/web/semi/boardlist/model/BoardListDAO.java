package com.web.semi.boardlist.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCRUD;

public class BoardListDAO extends OracleCRUD {
   
	public boolean insert(BoardListDTO dto) { //테이블 데이터 삽입
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
		BoardListDTO dto = new BoardListDTO();
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
   
   public BoardListDTO select(int no) { // 상세게시글
      BoardListDTO noData = new BoardListDTO();
      
      String query = "SELECT * FROM NOTICEBOARD WHERE N_ID = "+no;
      
      try {
         ResultSet res = occ.sendQuery(query);
         if(res.next()) {
            noData.setResultSet(res); // 상세게시글에 반영될 내용들
         }
         res.close();
         occ.close();
         
      } catch (SQLException e) {
         System.out.println("BoardListDAO select(int) error");
         e.printStackTrace();
      }
      
      return noData;
   }
   
   //검색
   public List<BoardListDTO> select(String query,String gubun) throws SQLException { 
      List<BoardListDTO> datas = new ArrayList<BoardListDTO>();
      
	  
      if(gubun.equals("title")) {
      query =  "SELECT * FROM NOTICEBOARD WHERE N_TITLE like '%"+query+"%' ORDER BY N_ID DESC";
      }else {
    	  query =  "SELECT * FROM NOTICEBOARD WHERE USER_UN like '%"+query+"%' ORDER BY N_ID DESC";
      }
      ResultSet res = occ.sendQuery(query);
      
      while(res.next()) {
         BoardListDTO dto = new BoardListDTO();
         dto.setId(res.getInt("N_ID"));
         dto.setCity(res.getString("N_CITY"));
         dto.setHobbp(res.getString("N_CATEGORY"));
         dto.setTitle(res.getString("N_TITLE"));
         dto.setDate(res.getDate("N_DATE"));
         dto.setNickname(res.getString("USER_UN"));
         dto.setNickname(res.getString("USER_UN"));
         dto.setGubun(gubun);
         datas.add(dto);
      }
      res.close();
      occ.close();
      
      return datas;
   }
   
   public List<BoardListDTO> select(String query) throws SQLException { 
	      List<BoardListDTO> datas = new ArrayList<BoardListDTO>();
	    		  
	     
	      query =  "SELECT * FROM NOTICEBOARD WHERE N_TITLE like '%"+query+"%' ORDER BY N_ID DESC";
	     
	      ResultSet res = occ.sendQuery(query);
	      
	      while(res.next()) {
	         BoardListDTO dto = new BoardListDTO();
	         dto.setId(res.getInt("N_ID"));
	         dto.setCity(res.getString("N_CITY"));
	         dto.setHobbp(res.getString("N_CATEGORY"));
	         dto.setTitle(res.getString("N_TITLE"));
	         dto.setDate(res.getDate("N_DATE"));
	         dto.setNickname(res.getString("USER_UN"));
	         dto.setNickname(res.getString("USER_UN"));
	         datas.add(dto);
	      }
	      res.close();
	      occ.close();
	      
	      return datas;
	   }

}