package com.ict.model;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class DeleteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		VO vo = (VO)request.getSession().getAttribute("vo");
		int result = DAO.getDelete(vo.getIdx());

		
		return "/MyController?cmd=list";
	}
}
