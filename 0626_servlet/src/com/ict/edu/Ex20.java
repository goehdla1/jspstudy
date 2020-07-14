package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.Project01;
import com.ict.model.Project02;
import com.ict.model.Project03;

@WebServlet("/Ex20")
public class Ex20 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex20() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String cmd = request.getParameter("cmd");
		String result = "";

		// 1-3 다시 html로 돌아가는 것.
		// request 와 response 가 필요 하면 포워딩
		// 필요 없으면 리다이렉트
		switch (cmd) {
		case "1":
			response.sendRedirect("ex21_1.html");
			break;
		case "2":
			response.sendRedirect("ex21_2.html");
			break;
		case "3":
			response.sendRedirect("ex21_3.html");
			break;
		case "4":
			// 성적 처리
			Project01 p01 = new Project01();
			result = p01.exec(request, response);
			break;
		case "5":
			// 사칙연산
			Project02 p02 = new Project02();
			result = p02.exec(request, response);
			break;
		case "6":
			// 알바비 계산
			Project03 p03 = new Project03();
			result = p03.exec(request, response);
			break;

		}

		out.println("<h2> 결과 </h2>");
		out.println("<h2>" + result + "</h2>");

	}

}
