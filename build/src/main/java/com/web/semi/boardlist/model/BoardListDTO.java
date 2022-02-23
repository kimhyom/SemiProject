package com.web.semi.boardlist.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardListDTO {
   private int id;
   private String city;
   private String hobbp;
   private String title="";
   private String context="";
   private Date date;
   private String nickname;
   private String gubun;
   
   public BoardListDTO() {}
   
   public BoardListDTO(String city, String hobbp, String title, String context, String nickname, String gubun) {
	      this.city = city;
	      this.hobbp = hobbp;
	      this.title = title;
	      this.context = context;
	      this.nickname = nickname;
	      this.gubun = gubun;
	   }
   
   public BoardListDTO(String city, String hobbp, String title, String context, String nickname) {
      this.city = city;
      this.hobbp = hobbp;
      this.title = title;
      this.context = context;
      this.nickname = nickname;
   }
   
   public BoardListDTO(int id, String city, String hobbp, String title, String context) {
      this.city = city;
      this.hobbp = hobbp;
      this.title = title;
      this.context = context;
      this.id=id;
   }

   
   public String getGubun() {
	return gubun;
}

public void setGubun(String gubun) {
	this.gubun = gubun;
}

public BoardListDTO(String nickname) {
      this.nickname = nickname;
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
      this.title = res.getString("N_TITLE");
      this.context = res.getString("N_CONTENT");
      this.nickname = res.getString("USER_UN");
      this.hobbp = res.getString("N_CATEGORY");
      this.date = res.getDate("N_DATE");
   }
   
}