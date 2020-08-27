package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.DAO;
import com.ict.db.VO;

public class OneListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		// 기본키를 가지고 select문을 처리하면  
		// 한 사람의 정보만 가져올수 있다.
		VO vo = DAO.getOneList(idx);
		
		// 수정과 삭제를 위해서
		HttpSession session = request.getSession();
		session.setAttribute("vo", vo);
		
		return "view/oneList.jsp";
	}
}
