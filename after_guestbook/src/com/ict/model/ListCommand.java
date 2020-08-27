package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

// 방명록 전체를 보여주는 일을 하는 클래스 
public class ListCommand implements Command{
	
	// 반환형 String 결과를 보여줄 페이지을 적는다.
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 일한다.(model = service = 비즈니스로직)
		// 방명록 전체를 보여주는 일
		List<VO> list = DAO.getList();
		
		//DB는 jsp에서 보여줄려면 request나 session에 저장
		request.setAttribute("list", list);
		
		return "view/list.jsp";
	}
}







