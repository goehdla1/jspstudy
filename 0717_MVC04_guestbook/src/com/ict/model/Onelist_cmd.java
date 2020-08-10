package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Onelist_cmd implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String num = request.getParameter("num");
		VO vo = DAO.getInstance().getOnelist(idx);
		request.getSession().setAttribute("vo", vo);
		request.getSession().setAttribute("num", num);
		
		
		return "view/onelist.jsp";
	}
}
