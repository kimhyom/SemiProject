package com.web.semi.boardwrite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.boardwrite.model.*;

@WebServlet("/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("N_ID"));
		
		BoardWriteService service = new BoardWriteService();
		BoardWriteDTO noData = service.getDetail(no);
		
		request.setAttribute("noData", noData);
		String view = "/WEB-INF/jsp/boardwrite/boardupdate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));	
		String city = request.getParameter("city");
		String hobbp = request.getParameter("hobbp");
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		String nickname = request.getParameter("nickname");
		
		BoardWriteDTO newData = new BoardWriteDTO();
		newData.setId(no);
		newData.setCity(city);
		newData.setHobbp(hobbp);
		newData.setTitle(title);
		newData.setContext(context);
		newData.setNickname(nickname);
		
		BoardWriteService service = new BoardWriteService();
		
		if(service.modify(newData)) {
			response.sendRedirect("/boardlist");
		} else {
			response.sendRedirect("/boardlist");
		}
	}

}
