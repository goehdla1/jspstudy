package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bye {
public String exec(HttpServletRequest request , HttpServletResponse response) {
	String name = "임과장";
	int age = 68;
	String msg = "Bye~~~~~";
		
		// 리턴은 결과를 표시할 뷰(jsp)를 지정한다.
		return "view/result3.jsp";
	}
}
