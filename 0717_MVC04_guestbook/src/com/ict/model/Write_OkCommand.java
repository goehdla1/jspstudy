package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Write_OkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터값 받아서 DB 처리 
		VO vo = new VO();
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setEmail(request.getParameter("email"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setContent(request.getParameter("content"));
		
		int result = DAO.getInstance().getInsert(vo);
		
		/* 방법1 : alert 사용
		request.setAttribute("result", result);
		return "view/write_ok.jsp";
		*/
		
		//방법2 : alert 사용 X
		if(result>0) {
			return "MyController?cmd=list";
		}else {
			return "MyController?cmd=write";
		}
	}
}






