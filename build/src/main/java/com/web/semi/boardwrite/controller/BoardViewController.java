package com.web.semi.boardwrite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.boardwrite.model.*;
import com.web.semi.replyboard.model.*;

@WebServlet("/boardview")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		int no = Integer.parseInt(request.getParameter("N_ID")); //게시글 번호
		
		BoardWriteService service = new BoardWriteService();
		BoardWriteDTO noData = service.getDetail(no);
		
		
		
		System.out.println(noData.toString());
		
		
		//댓글
		ReplyBoardService r_service = new ReplyBoardService();
		List<ReplyBoardDTO> datas = r_service.getList(no);
		if(datas != null) {
			System.out.println("문제없음!!!!!!!!!!");
		}
		String view = "/WEB-INF/jsp/boardview/view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
	
		request.setAttribute("noData", noData);
		request.setAttribute("datas", datas);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		
	}

}