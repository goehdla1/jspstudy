package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello {
public String exec(HttpServletRequest request , HttpServletResponse response) {
	String name = "임꺽정";
	int age = 47;
	String msg = "Hello";
		
		// 리턴은 결과를 표시할 뷰(jsp)를 지정한다.
		return "view/result2.jsp";
	}
}
