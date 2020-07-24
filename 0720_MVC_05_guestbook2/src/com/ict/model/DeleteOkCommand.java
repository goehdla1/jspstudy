package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class DeleteOkCommand implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	// session이 가지고 있는 정보 중 idx를 가져오자
		VO vo = (VO)request.getSession().getAttribute("vo");
		String idx = vo.getIdx();
		int result = DAO.getInstance().getDelete(idx); 
		request.setAttribute("result", result);
	return "view/delete_ok.jsp";
}
}
