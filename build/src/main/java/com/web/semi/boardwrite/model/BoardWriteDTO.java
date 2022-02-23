package com.web.semi.boardwrite.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWriteDTO {
	private int id=1;
	private String city;
	private String hobbp;
	private String title="";
	private String context="";
	private Date date;
	private String nickname;
	
	
	public BoardWriteDTO() {}

	public BoardWriteDTO(String city, String hobbp, String title, String context, String nickname) {
		this.city = city;
		this.hobbp = hobbp;
		this.title = title;
		this.context = context;
		this.nickname = nickname;
	}
	

	public BoardWriteDTO(String nickname) {
		this.nickname = nickname;
	}

	public BoardWriteDTO(String city, String hobbp, String title, String context) {
		this.city = city;
		this.hobbp = hobbp;
		this.title = title;
		this.context = context;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getHobbp() {
		return hobbp;
	}
	public void setHobbp(String hobbp) {
		this.hobbp = hobbp;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public void setResultSet(ResultSet res) throws SQLException {
		this.id = res.getInt("N_id");  //추가함
		this.title = res.getString("N_TITLE");
		this.context = res.getString("N_CONTENT");
		this.nickname = res.getString("USER_UN");
		this.hobbp = res.getString("N_CATEGORY");
		this.date = res.getDate("N_DATE");
		this.city = res.getString("N_CITY");
		this.id = res.getInt("N_ID");
	}
	
}