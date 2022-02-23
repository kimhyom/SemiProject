<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.semi.boardwrite.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>boardupdate</title>
	<link rel ="stylesheet" href="/static/css/boardwrite.css">
	<script type="text/javascript" src="/static/js/view.js"></script>
</head>

<body>
	<%
		BoardWriteDTO noData = (BoardWriteDTO)request.getAttribute("noData");
	%>
	<div id="write-main">
		  	<div id="logo">
	  		<img src ="/image/logo.png" alt ="woori_logo" width="300px">
	  	</div>
	  	
	  	<div id="write-form">
	  		
	  		<form action="/update?N_ID=<%=noData.getId() %>" method="post">
	  			<table>
	  				<thead>
	  					<tr>
	  						<th colspan="2">게시글 수정 양식</th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  					<tr>
	  						<td class="cols1">No</td>
	  						<td>
	  							<input type="text" name="no" value="<%=noData.getId()%>" readonly>
	  						</td>
	  					</tr>	  				
	  					
	  					<tr>
	  						<td class="cols1">선택</td>
	  						<td>
	  							<select name ='city'>
	  								<option  selected="<%=noData.getCity()%>"><%=noData.getCity()%></option>
								</select>
		   							
		   						<select name = 'hobbp'>
		   							<option  selected="<%=noData.getCity()%>"><%=noData.getHobbp()%></option>
								</select>
								<p style="color: rgb(255,128,128); font-size: 14px; float:right; padding-right: 385px; padding-top: 4px;">선택란은 수정이 불가합니다.</p>						
	  						</td>
	  					</tr>
	  					
	  					<tr>
	  						<td class="cols1">제목</td>
	  						<td>
	  							<input type="text" name="title" value="<%=noData.getTitle() %>" required>
	  						</td>
	  					</tr>
	  					
	  					<tr>
	  						<td class="cols1">작성자</td>
	  						<td>
	  							<input type="text" name="nickname" value="<%=noData.getNickname() %>" readonly>
	  						</td>
	  					</tr>
	  					
	  					<tr>
	  						<td class="cols1">내용</td>
	  						<td>
	  							<textarea name="context" cols="69" rows="15" required><%=noData.getContext() %></textarea>
	  						</td>
	  					</tr>
	  				</tbody>
	  			</table>
	  			
	  			<div id="form-button" class="right">
	  				<div>
	  					<button type="submit">확인</button>
	  				</div>
	  				<div>
	  					<button type="reset" onclick="history.back()">취소</button>
	  				</div>
	  			</div>
	  		</form>
	  		
	    </div>
	    
	</div>
</body>
</html>