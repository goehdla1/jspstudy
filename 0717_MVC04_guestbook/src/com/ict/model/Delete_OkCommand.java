package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Delete_OkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 삭제를 위해서 session 있는 idx를 불러 오자 
		VO vo = (VO)request.getSession().getAttribute("vo") ;
		int result = DAO.getInstance().getDelete(vo.getIdx());
		
		// 방법2
		// return "MyController?cmd=list";
		
		// 방법1
		request.setAttribute("result", result);
		return "view/delete_ok.jsp";

		
	}
}
