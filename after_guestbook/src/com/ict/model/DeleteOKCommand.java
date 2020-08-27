package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class DeleteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// DB 실제로 정보를 삭제하는 것.
		// 삭제할 떄 idx값이 필요하다.
		// idx는 sesstion vo 에 저장되어있으므로 호출한다.
		VO vo = (VO)request.getSession().getAttribute("vo");
		String idx = vo.getIdx();
		
		int result = DAO.getDelete(idx);
		
		return "MyController?cmd=list";
	}

}
