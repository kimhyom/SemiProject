package com.web.semi.join.model;

public class JoinDTO {
	private int id;
	private String username="";
	private String password;
	
	public JoinDTO() {}
	
	public JoinDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public JoinDTO(int id, String username, String password) {
		this(username,password);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
