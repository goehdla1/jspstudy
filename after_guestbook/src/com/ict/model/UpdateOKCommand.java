package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class UpdateOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		VO vo = (VO)request.getSession().getAttribute("vo");
		String idx = vo.getIdx();
		
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		vo.setName(name);
		vo.setSubject(subject);
		vo.setEmail(email);
		vo.setContent(content);
		
		request.getSession().setAttribute("vo", vo);
		
		
		int result = DAO.getUpdate(vo);
		
		return "MyController?cmd=onelist&idx"+idx;
		}

}
