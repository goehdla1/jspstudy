package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청에 대한 한글 처리
		// 2. 응답에 대한 한글 처리 및 HTML 문서
		response.setContentType("text/html; charset=UTF-8");
		// 3. 웹 브라우저에 HTML 출력하게 하는 코딩처리
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> 오늘의 운세 </h1>");
		// 오늘 날짜 구하기
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; // 자바에서 월은 11까지라서 +1해줘야한다.
		int day = now.get(Calendar.DATE);
		int lucky = (int) (Math.random() * 101); // 0 - 100 까지 랜덤값 구하기
		out.println(year+". "+month+". "+day+". 의 운수는 : " + lucky + "% 입니다." );
		out.println("<hr>");
		// 요청정보를 출력해 보자.
		out.println("<h3><ul>");
		out.println("<li>"+ request.getRemoteAddr() + "</li>");
		out.println("<li>"+ request.getRemoteHost()+ "</li>");
		out.println("<li>"+ request.getRemotePort()+ "</li>");
		out.println("<li>"+ request.getRemoteUser()+ "</li>");
		out.println("<li>"+ request.getContextPath()+ "</li>"); // 프로젝트 주소
		out.println("<li>"+ request.getRequestURI() + "</li>");
		out.println("</ul></h3>");
		out.println("</body>");
		out.println("</html>");
	}

}
