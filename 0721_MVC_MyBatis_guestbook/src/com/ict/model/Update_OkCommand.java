package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Update_OkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		VO vo = new VO();
		
		vo.setIdx(request.getParameter("idx"));
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setEmail(request.getParameter("email"));
		vo.setContent(request.getParameter("content"));
		
		int result = DAO.getUpdate(vo);
		
		return "MyController?cmd=onelist&idx="+vo.getIdx();
	}
}
