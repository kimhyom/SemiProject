package com.web.semi.boardwrite.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.boardwrite.model.*;

@WebServlet("/boardwrite")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/boardwrite/boardwrite.jsp"; // list1.jsp 는 전체게시판
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String city = request.getParameter("city");
		String hobbp = request.getParameter("hobbp");
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		String nickname = request.getParameter("nickname");
		
		BoardWriteDTO dto = new BoardWriteDTO(city,hobbp,title,context,nickname);
		
		BoardWriteService service = new BoardWriteService(dto);
		
		request.setAttribute("initData", dto);
		
		String view = "/WEB-INF/jsp/boardwrite/boardwrite.jsp"; // 등록 실패 시 입력값을 초기값으로 현재페이지 재로드
		RequestDispatcher rd = request.getRequestDispatcher(view);
		
		// 유효성 검사
		if(service.isValid() == 0) {
			if(service.add(dto)) {
				// 등록 성공
				response.sendRedirect("/boardlist"); //작성하면 게시판 목록으로
			} else {
				// 등록 실패
				rd.forward(request, response);
			}
		}
	}

}