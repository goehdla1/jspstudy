package com.ict.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05")
public class Ex05 extends HttpServlet {
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
		out.println("<title>charset</title>");
		out.println("<style type='text/css'>");
		out.println(".city{background-color:black; color:white; margin:20px; padding:20px; width:300px; float:left};");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<div class='city'>");
		out.println("<h2>London</h2>");
		out.println("<p>London is the capital of England.</p>");
		out.println("</div>");
		out.println("<div class='city'>");
		out.println("<h2>Paris</h2>");
		out.println("<p>paris is the capital of France.</p>");
		out.println("</div>");
		out.println("<div class='city'>");
		out.println("<h2>Tokyo</h2>");
		out.println("<p>Tokyo is the capital of Japan.</p>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div class='city'>");
		out.println("<h2>London</h2>");
		out.println("<p>London is the capital of England.</p>");
		out.println("</div>");
		out.println("<div class='city'>");
		out.println("<h2>Paris</h2>");
		out.println("<p>paris is the capital of France.</p>");
		out.println("</div>");
		out.println("<div class='city'>");
		out.println("<h2>Tokyo</h2>");
		out.println("<p>Tokyo is the capital of Japan.</p>");
		out.println("</div>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

}
