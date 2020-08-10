package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.Command;
import com.ict.model.Delete_cmd;
import com.ict.model.List_cmd;
import com.ict.model.Onelist_cmd;
import com.ict.model.Update_cmd;
import com.ict.model.Write_cmd;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		Command comm = null;
		String path = "";
		
		switch (cmd) {
			case "list": comm = new List_cmd(); break;
			case "write": comm = new Write_cmd(); break;
			case "onelist": comm = new Onelist_cmd(); break;
			case "update": comm = new Update_cmd(); break;
			case "delete":comm = new Delete_cmd(); break;
				
		}
		path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
