package com.ict.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Delete_cmd implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		VO vo = (VO)request.getSession().getAttribute("vo");
		int result = DAO.getInstance().getIDU(vo, "Delete");
		
		ArrayList<VO> list = DAO.getInstance().getList();
		request.getSession().setAttribute("list", list);
		
		if(result > 0) {
			return "view/list.jsp";
		} else {
			return "view/delete.jsp";
		}
			
	}
	
}
