package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hi {
	
	// 요청을 실행할 메소드를 만들자 
	public String exec(HttpServletRequest request, HttpServletResponse response) {
			String name = "둘리";
			int age = 24 ;
			String msg = "Hi";
		
		// 리턴은 결과를 표시할 뷰(jsp)를 지정한다.
		return "view/result1.jsp";
	}
}
