package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class DeleteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BVO bvo = (BVO)request.getSession().getAttribute("bvo");
		String b_idx = bvo.getB_idx();
		 String cPage = request.getParameter("cPage");
		
		// 원글에 관련된 댓글이 있으면 오류 발생 (삭제안됨)
		int res = DAO.getC_AllDelete(b_idx);
		
		int result = DAO.getDelete(b_idx);
		return "MyController?cmd=list&cPage="+cPage;
	}
}
