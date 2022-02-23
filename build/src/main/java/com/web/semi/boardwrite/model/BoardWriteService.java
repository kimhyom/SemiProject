package com.web.semi.boardwrite.model;

import java.sql.SQLException;
import java.util.List;

public class BoardWriteService {
	BoardWriteDTO dto = null;
	BoardWriteDAO dao = null;
	
	public BoardWriteService(BoardWriteDTO dto) {
		this.dto = dto;
	}

	public BoardWriteService() {}

	public boolean add(BoardWriteDTO dto) { // 글작성
		
		dao = new BoardWriteDAO();
		boolean res = dao.insert(this.dto);
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return res;
	}

	public int isValid() { // 글작성 유효성 검사
		if(this.dto.getTitle() == null) {
			return -1;
		} else if(this.dto.getContext() == null) {
			return -2;
		}
		return 0;
	}

	public List<BoardWriteDTO> getList() {
		List<BoardWriteDTO> datas = null;
		try {
			dao = new BoardWriteDAO();
			datas = dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public BoardWriteDTO getDetail(int no) { // 글 상세보기
		BoardWriteDTO noData = null;
		
		dao = new BoardWriteDAO();
		noData = dao.select(no);
		
		dao.close();
		
		return noData;
	}

	public boolean modify(BoardWriteDTO newData) { // 내 글 수정
		dao = new BoardWriteDAO();
		boolean res = dao.update(newData);
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return res;
	}

	public boolean delete(BoardWriteDTO dto) { // 내 글 삭제
		dao = new BoardWriteDAO();	
		boolean res = dao.delete(dto);
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return res;
	}
	
}