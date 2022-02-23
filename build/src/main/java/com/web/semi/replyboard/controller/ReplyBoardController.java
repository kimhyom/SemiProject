package com.web.semi.replyboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.replyboard.model.*;

@WebServlet("/replyboard")
public class ReplyBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReplyBoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String R_context = request.getParameter("R_context");
		String userName = request.getParameter("memberId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("R_context : "+ R_context.toString());
		System.out.println("userName : "+userName.toString());
		System.out.println("boardNo : "+ boardNo);
		
		int result = new ReplyBoardService().add(userName,R_context,boardNo);
		System.out.println("result : "+ result);
	
		String view = "/WEB-INF/jsp/common/msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		if(result > 0) {
			//저장 완료
			System.out.println("댓글 등록 성공!");
			request.setAttribute("msg", "댓글 등록 성공!");
		
		} else {
			//저장 실패
			System.out.println("댓글 등록 실패!");
			request.setAttribute("msg", "댓글 등록 실패!");
			
		}
		
		request.setAttribute("loc", "/boardview?N_ID="+boardNo);
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
