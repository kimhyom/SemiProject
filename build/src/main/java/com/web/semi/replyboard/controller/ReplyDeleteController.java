package com.web.semi.replyboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.replyboard.model.*;

@WebServlet("/replydelete")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("r_id"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReplyBoardService service = new ReplyBoardService();
		int result = service.delectReply(boardNo);
		
		if(result==1) {
			System.out.println("good");
		} else {
			System.out.println("nononono");
		}
		
		response.sendRedirect("/boardview?N_ID="+no);
	}

}
