package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class WriteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// write.jsp에서 보낸 파라미터들을 받아서 DB에 저장
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		
		VO vo = new VO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setContent(content);
		
		int result = DAO.getInsert(vo);
		
		// 여기서 컨트롤러를 거쳐서 리스트를 갈 수 있게 하자 
		return "MyController?cmd=list";
	}
}
