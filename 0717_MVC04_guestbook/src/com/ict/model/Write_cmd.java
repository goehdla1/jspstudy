package com.ict.model;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Write_cmd implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		VO vo = new VO();
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setEmail(request.getParameter("email"));
		vo.setPwd(request.getParameter("pwd"));
		
		int result = DAO.getInstance().getIDU(vo,"Insert");
				
		ArrayList<VO> list = DAO.getInstance().getList();
		request.getSession().setAttribute("list", list);
		
		// alert을 하고 싶으면 jsp를 만들고 경로를 만들어 보낼 것.
		
		if(result > 0) {
			return "view/list.jsp";
		} else {
			return "view/write.jsp";
		}

		
	}
	
	
}
