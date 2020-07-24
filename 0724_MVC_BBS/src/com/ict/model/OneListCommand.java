package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class OneListCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");

		// 조회수 1 업데이트
		int result = DAO.getHitUp(b_idx);

		// 내용 가져오기
		BVO bvo = DAO.getOneList(b_idx);

		// 수정과 삭제를 위해서 session에 저장
		request.getSession().setAttribute("bvo", bvo);
		return "view/onelist.jsp";
	}

}
