package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.Command;
import com.ict.model.DeleteCommand;
import com.ict.model.DeleteOKCommand;
import com.ict.model.ListCommand;
import com.ict.model.OneListCommand;
import com.ict.model.UpdateCommand;
import com.ict.model.UpdateOKCommand;
import com.ict.model.WriteCommand;
import com.ict.model.WriteOKCommand;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get으로 들어온 정보를 post에 보내서 처리하자
		doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 : request, response , 화면출력(브라우저에 출력) : response
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 사용자가 요청할때 같이 들어온 파라미터를 받자
		String cmd = request.getParameter("cmd");
		
		Command comm = null;
		switch (cmd) {
			case "list":  comm = new ListCommand(); break;
			case "write":  comm = new WriteCommand(); break;
			case "write_ok":  comm = new WriteOKCommand(); break;
			case "onelist":  comm = new OneListCommand(); break;
			case "delete":  comm = new DeleteCommand(); break;
			case "delete_ok":  comm = new DeleteOKCommand(); break;
			case "update":  comm = new UpdateCommand(); break;
			case "update_ok":  comm = new UpdateOKCommand(); break;
			
		}
		// 실행 후 포워딩하는 위치 받아서 포워딩(실행결과보기)
		 String path = comm.exec(request, response);
		 request.getRequestDispatcher(path).forward(request, response);
	}
}


















