<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.semi.join.model.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/static/css/account.css">
    <title>회원가입</title>
</head>
<body>
	<%
		JoinDTO initData = new JoinDTO();
		if(request.getAttribute("initData")!=null) {
			initData = (JoinDTO)request.getAttribute("initData");
		}
	%>
    <div class="account-main">
        <div class="account-logo">
            <h1>회원가입</h1>
        </div>
    </div>

    <div class="account-form">
        <form action="./account" method="post">
            <div class="account-info1">
                <div class="input-form">
                    <label for="">아이디</label>
                    <%
		                String join_error = "";
		    			if(request.getAttribute("join_error") != null) {
		    				join_error = (String)request.getAttribute("join_error");
		    			}
	                %>
                    <div class="inline-input">
                        <input type="text" name="username" id="userid" value="<%=initData.getUsername() %>" placeholder="4~16 자리 사이 영문, 숫자만 입력" required>
                    </div>
                </div>
                <div class="input-form">
                    <label for="">비밀번호</label>
                    <div class="inline-input">
                        <input type="password" id="id_pass1" name="password" placeholder="4~16 자리 사이 영문, 숫자만 입력" required>
                    </div>
                </div>
                <div class="input-form">
                    <label for="">비밀번호 재확인</label>
                    <div class="inline-input">
                        <input type="password" id="id_pass2" name=password_check placeholder="4~16 자리 사이 영문, 숫자만 입력" required>
                    </div>
                    <%
                    	if(!join_error.isEmpty()) {
                    %>
                    	<div>
                    		<label><%=join_error %></label>
                    	</div>
                    <%
                    	}
                    %>
                </div>
            </div>
            
            <div class="account-submit">
                <button type="submit">가입하기</button>
            </div>
        </form>
    </div>
</body>
</html>