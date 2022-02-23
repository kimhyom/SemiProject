<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.semi.boardwrite.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>boardwrite</title>
	<link rel ="stylesheet" href="/static/css/boardwrite.css">
	<script type="text/javascript" src="/static/js/boardwrite.js"></script>
</head>

<body>
	<%
		String username = null;
		if(session.getAttribute("login_name")!=null) {
			username = (String)session.getAttribute("login_name");
		}
		
		BoardWriteDTO initData = new BoardWriteDTO();
		if(request.getAttribute("initData") != null) {
			initData = (BoardWriteDTO)request.getAttribute("initData");
		}
	%>
	<div id="write-main">
		  	<div id="logo">
	  		<a href ="/index.jsp"><img src ="/image/logo.png" alt ="woori_logo" width="300px"></a>
	  	</div>
	  	
	  	<div id="write-form">
	  		
	  		<form action="/boardwrite" method="post">
	  			<table>
	  				<thead>
	  					<tr>
	  						<th colspan="2">글쓰기</th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  					<tr>
	  						<td class="cols1">선택</td>
	  						<td>
	  							<select name ='city'>
			 						<option value="서울">서울</option>
			 						<option value="인천">인천</option>
			 						<option value="부산">부산</option>
			 						<option value="대구">대구</option>
			 						<option value="대전">대전</option>
								</select>
		   							
		   						<select name = 'hobbp'>
			 						<option value="운동">운동</option>
			 						<option value="취미">취미</option>
			 						<option value="스터디">스터디</option>
			 						<option value="맛집탐방">맛집탐방</option>
								</select>
	  						</td>
	  					</tr>
	  					
	  					<tr>
	  						<td class="cols1">제목</td>
	  						<td>
	  							<input type="text" name="title" value="<%=initData.getTitle()%>" placeholder="모집인원을 입력해주세요.">
	  						</td>
	  					</tr>
	  					
	  					<tr>
	  						<td class="cols1">작성자</td>
	  						<td>
	  							<input type="text" name="nickname" value="<%=username%>" readonly>
	  						</td>
	  					</tr>
	  					
	  					<tr>
	  						<td class="cols1">내용</td>
	  						<td>
	  							<textarea name="context" cols="69" rows="15" placeholder="댓글이 달린 게시글은 삭제할 수 없습니다."><%=initData.getContext()%></textarea>
	  						</td>
	  					</tr>
	  				</tbody>
	  			</table>
	  			
	  			<div id="form-button">
	  				<div>
	  					<button type="button" onclick="location.href='/boardlist'">취소</button>
	  				</div>
	  				<div class="right">
	  					<button type="reset">초기화</button>
	  					<button type="submit">등록</button>
	  				</div>
	  			</div>
	  		</form>
	  		
	  		<%
	  			
	  		%>
	    </div>
	    
	</div>
</body>
</html>