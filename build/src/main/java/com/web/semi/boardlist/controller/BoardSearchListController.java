package com.web.semi.boardlist.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.semi.boardlist.model.*;

@WebServlet("/search")
public class BoardSearchListController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @SuppressWarnings("unused")
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String query = request.getParameter("q");
      
      BoardListService service = new BoardListService();
      List<BoardListDTO> datas = null;
      
    //조회
      if(query != null) {
         try {
            datas = service.getList(query);
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } else {
         try { 
            query = "%";
            datas = service.getList(query);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      }
      request.setAttribute("datas", datas);

      
      
      
      String view = "/WEB-INF/jsp/search/searchlist.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(view);
      rd.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

}