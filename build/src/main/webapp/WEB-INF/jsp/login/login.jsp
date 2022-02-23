<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link type="text/css" rel="stylesheet" href="/static/css/login.css">
</head>
<body>
    <div class="login-main">
        <div class="login-logo">
            <h1>로그인</h1>
        </div>
        <div class="login-form">
            <form action="./login" method="post">
                <div class="login-info1">
                    <div class="input-form">
                        <label for="">아이디</label>
                        <%
			                String login_error = "";
			    			if(request.getAttribute("login_error") != null) {
			    				login_error = (String)request.getAttribute("login_error");
			    			}
		                %>
                        <div class="inline-input">
							<input type="text" name="username" placeholder="아이디" required>
                        </div>
                    </div>
                    <div class="input-form">
                        <label for="">비밀번호</label>
                        <div class="inline-input">
                            <input type="password" name="password" placeholder="비밀번호" required>
                        </div>
                        <%
                        	if(!login_error.isEmpty()) {
                        %>
                        	<div>
                        		<label><%=login_error %></label>
                        	</div>
                        <%
                        	}
                        %>
                    </div>
                </div>
                <div class="login-submit">
                    <button type="submit">로그인</button>
                </div>
            </form>
            
            <div id="signup-submit">
                <a href="/account" role="button" id="btn">회원가입</a>
            </div>
        </div>

    </div>
</body>
</html>