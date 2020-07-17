package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;


public class WriteOkCommand implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	

	
	VO vo  = new VO();
	vo.setName(request.getParameter("name"));
	vo.setName(request.getParameter("subject"));
	vo.setName(request.getParameter("email"));
	vo.setName(request.getParameter("pwd"));
	vo.setName(request.getParameter("content"));
	
	int result = DAO.getInstance().getInsert(vo);
	request.setAttribute("result",result);
	
	return "view/write_ok.jsp";
}
}

