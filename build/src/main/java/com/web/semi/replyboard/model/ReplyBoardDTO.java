package com.web.semi.replyboard.model;

import java.sql.Date;

public class ReplyBoardDTO {
	private int id;
	private String r_context;
	private String nickname;
	private Date date;
	private int boardNo;
	
	
	
	
	public ReplyBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ReplyBoardDTO(int id, String r_context, String nickname, Date date, int boardNo) {
		super();
		this.id = id;
		this.r_context = r_context;
		this.nickname = nickname;
		this.date = date;
		this.boardNo = boardNo;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getR_context() {
		return r_context;
	}




	public void setR_context(String r_context) {
		this.r_context = r_context;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public int getBoardNo() {
		return boardNo;
	}




	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	
	
	

}