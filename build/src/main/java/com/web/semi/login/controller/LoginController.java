package com.web.semi.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.semi.login.model.LoginDTO;
import com.web.semi.login.model.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String view = "/WEB-INF/jsp/login/login.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(view);
      rd.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      LoginDTO dto = new LoginDTO(
    		  request.getParameter("username"),
    		  request.getParameter("password"));
      
      LoginService servcie =  new LoginService(dto);
      
      String view = "/WEB-INF/jsp/login/login.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(view);
      
      if(servcie.isExisted()) {
    	  
    	  // 아이디가 있는 경우
    	  if(servcie.confirmPassword()) {
    		  
    		  // 패스워드가 일치하는 경우    		  
    		  HttpSession session = request.getSession();
    		  session.setAttribute("login_name", dto.getUsername());
    		  System.out.print("session: "+dto.getUsername());
    		  response.sendRedirect("/");
    	  } else {
    		  // 패스워드가 틀림
    		  request.setAttribute("login_error", "패스워드를 잘못 입력했습니다.");
    		  rd.forward(request, response);
    	  }
      } else {
    	  // 아이디 틀림
    	  request.setAttribute("login_error", "존재하지 않는 아이디입니다.");
    	  rd.forward(request, response);
      }
   }

}