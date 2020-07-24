package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class DeleteOKCommand  implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	BVO bvo = (BVO)request.getSession().getAttribute("bvo");
	String b_idx = bvo.getB_idx();
	
	// 글삭제
	int result = DAO.getDelete(b_idx);
	return "MyController?cmd=list";
}
}
