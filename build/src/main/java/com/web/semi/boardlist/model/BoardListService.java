package com.web.semi.boardlist.model;

import java.sql.SQLException;
import java.util.List;

public class BoardListService {
   BoardListDTO dto = null;
   
   public BoardListService(BoardListDTO dto) {
      this.dto = dto;
   }

   public BoardListService() {}
   
    //검색창
   public List<BoardListDTO> getList(String query,String gubun) throws SQLException {
      BoardListDAO dao = new BoardListDAO();
      List<BoardListDTO> datas = dao.select(query,gubun);
      dao.close();      
      return datas;
   }  
   public List<BoardListDTO> getList(String query) throws SQLException {
	      BoardListDAO dao = new BoardListDAO();
	      List<BoardListDTO> datas = dao.select(query);
	      dao.close();      
	      return datas;
	   }  

       
       public boolean add(BoardListDTO dto) { // 글작성
          
          BoardListDAO dao = new BoardListDAO();
          boolean res = dao.insert(this.dto);
          if(res) {
             dao.commit();
          } else {
             dao.rollback();
          }
          dao.close();
          
          return res;
       }
      
       public BoardListDTO getDetail(int no) { // 글 상세보기
          BoardListDAO dao = null;
          BoardListDTO noData = null;
          
          dao = new BoardListDAO();
          noData = dao.select(no);
          
          dao.close();
          
          return noData;
       }
       



}