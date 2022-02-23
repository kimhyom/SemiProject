package com.web.semi.replyboard.model;

import java.sql.SQLException;
import java.util.List;



public class ReplyBoardService {
	
	
	public int add(String userName, String r_context,int boardNo) {
		ReplyBoardDAO dao;
		int result =0;
		try {
			dao = new ReplyBoardDAO();
			boolean res = dao.insert(userName, r_context,boardNo);
			if(res) {
				dao.commit();
				result = 1;
			} else {
				dao.rollback();
				
			}
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	
	}


	public List<ReplyBoardDTO> getList(int no) {
		ReplyBoardDAO dao = null;
		List<ReplyBoardDTO> datas = null;
		try {
			dao = new ReplyBoardDAO();
			datas = dao.select(no);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return datas;
	}
	
	public ReplyBoardDTO getData(int id) {
		ReplyBoardDTO data = new ReplyBoardDTO();
		return data;
	}
	
	


	public int delectReply(int boardNo) {
		//ReplyBoardDTO data = getData(dto.getBoardNo());  //추후 확인 닉네임인지 아이디값인
		ReplyBoardDAO dao;
	
		int result=0;
		try {
			dao = new ReplyBoardDAO();
			result = dao.deleteReply(boardNo);
			if(result ==1) {
				dao.commit();
			}else {
				dao.rollback();
			}
			dao.close(); 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return result;
	}
	
	
	
	
}