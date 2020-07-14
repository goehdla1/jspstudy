package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.Cmd01;
import com.ict.model.Cmd02;
import com.ict.model.Cmd03;

@WebServlet("/Ex19")
public class Ex19 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex19() {
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

		String com = request.getParameter("com");
		String result = "";
		switch (com) {
		case "1":
			Cmd01 c01 = new Cmd01();
			result = c01.exec(request, response);
			break;
		case "2":
			Cmd02 c02 = new Cmd02();
			result = c02.exec(request, response);
			break;
		case "3":
			Cmd03 c03 = new Cmd03();
			result = c03.exec(request, response);
			break;

		}
		out.println("<h2> 결과 </h2>");
		out.println("<h2>" + result + "</h2>");
	}

}
