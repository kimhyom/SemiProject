<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.semi.boardlist.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SearchList</title>
   <link type="text/css" rel="stylesheet" href="/static/css/boardlist.css">
</head>
<body>
   <div id="list-main">
   
      <div id="logo">
         <img src ="/image/logo.png" alt ="woori_logo" width="300px">
      </div>
   
      <div id="header">
         <h4>우리 동네 소모임 게시판</h4>
      </div>
      
      <div id="show-list">
         <div>
            <%
               String username = null;
               if(session.getAttribute("login_name")!=null) {
                  username = (String)session.getAttribute("login_name");
            %>
            <p><a href="/logout"><%=username %> </a>님 환영합니다!!</p>
            <%   } %>
         </div>
         <div id="search">
            <form action="/search" method="get">
            	
                <select name = "f">
                    <option ${(param.f == "title")? "selected" : ""} value = "title">제목</option>
                   
                </select>
                <label>검색어</label>
                <input type = "text" name = "q" value = "${param.q}"/>
                <button type="submit">검색</button>             
                     
            </form>
         </div>
         <table>
            <colgroup>
               <col width="10%">
               <col width="10%">
               <col width="17%">
               <col>
               <col width="10%">
               <col width="130px">
            </colgroup>
            <thead>
               <tr>
                  <th>No</th>
                  <th>지역</th>
                  <th>카테고리</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>날짜</th>
               </tr>
            </thead>
            <tbody>
               <%
                  List<BoardListDTO> datas =(List<BoardListDTO>)request.getAttribute("datas");
                  for(BoardListDTO data: datas) {
               %>
                  <tr>
                     <td><%=data.getId() %></td>
                     <td><%=data.getCity() %></td>
                     <td class="text-center"><%=data.getHobbp() %></td>
                     <td class="col-title"><a href="/boardview?N_ID=<%=data.getId()%>"><%=data.getTitle() %></td>
                     <td><%=data.getNickname() %></td>
                     <td><%=data.getDate() %></td>
                  </tr>
               <%
                  }
               %>
            </tbody>
         </table>
      </div>
      
      <div>
      	 <form action="/boardlist" method="get">	
         	<button type="submit">취소</button>
         </form>
      </div>
   
   </div>
</body>
</html>