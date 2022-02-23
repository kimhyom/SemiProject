package com.web.semi.boardwrite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.boardwrite.model.*;

@WebServlet("/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("N_ID"));
		
		BoardWriteService service = new BoardWriteService();
		BoardWriteDTO dto = new BoardWriteDTO();
		dto.setId(no);
		
		if(service.delete(dto)) {
			response.sendRedirect("/boardlist");
		} else {
			response.sendRedirect("/boardlist");
		}
	}

}
