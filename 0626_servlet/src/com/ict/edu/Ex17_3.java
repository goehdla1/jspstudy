package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex17_3
 */
@WebServlet("/Ex17_3")
public class Ex17_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex17_3() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8 ");
		PrintWriter out = response.getWriter();

		// IP 구하기
		String ip = request.getRemoteAddr();
		out.println("<h2>IP구하기</h2>");
		out.println("<h2>IP주소는" + ip + "입니다." + "</h2>");
	}

}
