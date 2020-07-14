package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex06")
public class Ex06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>a 링크</title>");
	
		out.println("</head>");
		out.println("<body>");
		
		out.println("<a href='https://www.google.com'>구글가기1</a>");
		out.println("<a href='https://www.google.com' target='_blank'>구글가기2</a>");
		out.println("<a href='/0626_servlet/Ex04'>문서04</a>");
		out.println("<a href='"+request.getContextPath()+"/Ex05'>문서05</a>");

		out.println("</body>");
		out.println("</html>");

	}

}
