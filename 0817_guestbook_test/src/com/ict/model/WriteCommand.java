package com.ict.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class WriteCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		VO vo = new VO();
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setEmail(request.getParameter("email"));
		vo.setPwd(request.getParameter("pwd"));
		
		int result = DAO.getInsetance().getInsert(vo);
		request.getSession().setAttribute("result", result);
		
		
		if (result > 0) {
			return "/MyController?cmd=list";
			
		}else {
			return "view/write.jsp";
		}
		
	}

}
