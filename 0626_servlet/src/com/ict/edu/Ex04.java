package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청에 의한 한글 처리 
		// 2. 응답을 위한 한글 처리 및 문서 처리 (HTML)
		response.setContentType("text/html; charset=UTF-8");
		// 3. 출력 처리 
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>table 배경색</title>");
		out.println("<style type='text/css'>");
		out.println("table, th, td{");
		out.println("border: 2px solid green; }");
		out.println("thead{");
		out.println("background-color: tomato;}");
		out.println("table{");
		out.println("width: 700px;");
		out.println("margin: auto;");
		out.println("background-color: skyblue;}");
		out.println("td{");
		out.println("text-align: center;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<thead style='background-color: yellow;'>");
		out.println("<tr><th>방이름</th><th>대상</th><th>크기</th><th>가격</th></tr>");
		out.println("</thead>");
		out.println("<tbody>");
		out.println("<tr><td>유채방</td><td>여성</td><td rowspan='3'>4인실</td><td rowspan='4'>1인 20,000원</td></tr>");
		out.println("<tr><td rowspan='2' style='background-color: gray;'>동백방</td><td>동성</td></tr>");
		out.println("<tr><td>가족</td></tr>");
		out.println("<tr><td>장미방</td><td>누구나</td><td>2인실</td></tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
