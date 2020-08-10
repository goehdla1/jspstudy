package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Update_cmd implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VO vo = new VO();
		
		vo.setIdx(request.getParameter("idx"));
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setEmail(request.getParameter("email"));
		
		
		int result = DAO.getInstance().getIDU(vo,"Update");
		
		request.getSession().setAttribute("vo", vo);
		
		if(result > 0) {
			return "MyController?cmd=onelist&idx=" + vo.getIdx();
		} else {
			return "view/update.jsp";
		}
		
	}
	
}
