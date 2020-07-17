package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;


public class UpdateOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String idx = request.getParameter("idx");

		int result = DAO.getInstance().getUpdate(name, subject, email, content, idx);
		request.setAttribute("result", result);

		return "view/update_ok";
	}

}
