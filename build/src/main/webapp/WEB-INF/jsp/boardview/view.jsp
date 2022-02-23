<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.web.semi.boardwrite.model.*"%>
<%@ page import="com.web.semi.replyboard.model.*"%>
<%
	BoardWriteDTO noData = (BoardWriteDTO) request.getAttribute("noData");
	List<ReplyBoardDTO> datas = (List<ReplyBoardDTO>)request.getAttribute("datas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글상세보기</title>
<link type="text/css" rel="stylesheet" href="/static/css/view.css">
</head>
<body>


	<div id="write-main">
	
	  	<div id="logo">
	  		<a href ="/index.jsp"><img src ="/image/logo.png" alt ="woori_logo" width="300px"></a>
	  	</div>
	  	
	  	<div id="write-form">
  			<table id="table1">
  				<thead>
  					<tr>
  						<th colspan="4">글 상세보기</th>
  					</tr>
  				</thead>
  				<tbody>

  					<tr>
  						<td class="table1-cols1">제목</td>
  						<td >
  							<p><%=noData.getTitle() %> </p>
  						</td>
  						<td class="table1-cols1" >작성자</td>
  						<td >
  							<p><%=noData.getNickname() %> </p>
  						</td>
  						
  					</tr>
  					
  					<tr>
  						<td class="table1-cols1">카테고리</td>
  						<td >
  							<p><%=noData.getHobbp() %></p>
  						</td>
  						<td class="table1-cols1">작성일</td>
  						<td >
  							<p><%=noData.getDate() %></p>
  						</td>
  					</tr>
  					
  					<tr>
  						<td colspan="4" class="table1-cols1" style="min-height: 200px; text-align: center;">
  							<%=noData.getContext() %>
  						</td>
  						<td colspan="4">
  							
  						</td>
  					</tr>
  				</tbody>
  			</table>
	    </div>
	    
	    <div id="buttons">
		    <div>
		    	<form action="/boardlist" method="get">
					<button type="submit">목록</button>
				</form>
			</div>
			<%
			String username = null;
			if (session.getAttribute("login_name") != null) {
				username = (String) session.getAttribute("login_name");
				if (username.equals(noData.getNickname())) {
			%>
						<div class="right">
							<form action="/delete?N_ID=<%=noData.getId() %>" method="post">
								<button type="submit" >삭제</button>
							</form>
						</div>
						<div class="right">
							<button type="button" onclick="location.href='/update?N_ID=<%=noData.getId() %>'">수정</button>
						</div>
						
			<%
				}
			}
			%>
		</div>
		
		<!-- 댓글 -->
		<div id="view-reply">
			<!-- 등록된 댓글 보여주고, 로그인한 사용자가 작성한 댓글만 삭제버튼이 보이도록 -->
			<div id="show-reply">
				<table id="table2">
					<tbody>
						<%
							for(ReplyBoardDTO data : datas){
						%>
							<tr>
								<td class="table2-cols1">
									<p><%=data.getNickname()%></p>
								</td>
								<td>
									<p><%=data.getR_context()%></p>
								<td>
							
								<td class = "w-100">
									<%	if (username.equals(data.getNickname())) { %>
											<form action="/replydelete" method="post">
												<input type="hidden" name="r_id" value="<%=data.getId()%>">
												<input type="hidden" name="no" value="<%=data.getBoardNo()%>">
												<button type="submit" class="delete">삭제</button>
											</form>
									<%	} %>
								</td>
							
							</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<!-- 댓글 등록 -->
			<div id="comment-reply">
				<form action="/replyboard" method="get">
					<input type="hidden" name="boardNo" value="<%=noData.getId()%>">
					<input type="hidden" name="memberId"
						value="${ sessionScope.login_name}">
					<div>
						<input type="text" name="R_context" placeholder="댓글을 입력하세요.">
					</div>
					<div>
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>