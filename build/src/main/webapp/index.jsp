<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메인</title>
    <link rel="stylesheet" href="/static/css/main.css">

</head>
<body>
	
    <nav class ="navbar">
      <div class="navbar_logo">
          <img src="/image/logo.png" alt="logo" style="width: 220px; height: 60px;"> 
      </div>
      
      <ul class="navbar_menu">
      
      	  <%
      	  	if(session.getAttribute("login_name")!=null) {
      	  %>
      	  	  <!-- 로그인 상태인 경우 -->
	          <li><a href="/logout">로그아웃</a></li>
	          <li><a href="/boardlist">게시판</a></li>
	      <%
      	  	} else {
	      %>
		      <!-- 로그인 상태가 아닌 경우 -->
	          <li><a href="/login">로그인</a></li>
	          <li><a href="/account">회원가입</a></li>
          <%
      	  	}
          %>
      </ul>
    </nav>
     
   	<!-- 본문 -->
    <section class="main-page">
        <div class="main-full">
            <div class="main-text">
                우리 <span style="color : #F3B2CF">동네</span>에서<br>
                우리 <span style="color : #97D2D4">모임</span>할래요?
            </div>
            <div class="main-img">
                <img src="/image/biglogo.png" alt="biglogo" style="width: 450px; height: 350px;">
            </div>
        </div>
    </section>

    <!-- 하단 -->
    <div class="footer-full">
        <div class="footer-text">
            공지사항 | 서비스 이용약관 | 개인정보처리방침 | 운영정책 | 청소년보호정책 |<br>
            Contact US help@woori.com | COPYRIGHT 2021 WOORI, ALL RIGHTS RESERVED.
        </div>
    </div>
    
</body>
</html>