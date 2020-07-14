package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex08")
public class Ex08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청에 대한 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 응답에 대한 한글 처리 및 문서 처리 
		response.setContentType("text/html; charset=utf-8");
		// 3. 출력 처리 
		PrintWriter out = response.getWriter();
		
		out.println("<h2> 서블릿 파라미터 예제 </h2>");
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		String op = request.getParameter("op");
	
		int s1 = Integer.parseInt(su1);
		int s2 = Integer.parseInt(su2);
		int sum = 0 ;
		switch (op) {
			case "+": sum = s1 + s2 ; break;
			case "-": sum = s1 - s2 ; break;
			case "*": sum = s1 * s2 ; break;
			case "/": sum = s1 / s2 ; break;
		}
		// if문인 경우
		// if(op.equals("+")) {}
		
		out.println("<h3>");
		out.println("<p>결과 : "+su1+op+su2+"="+sum+"</p>");
		out.println("</h3>");
		
	}
}






