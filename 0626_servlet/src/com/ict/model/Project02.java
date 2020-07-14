package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Project02 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		String op = request.getParameter("op");
		int s1 = Integer.parseInt(request.getParameter("su1"));
		int s2 = Integer.parseInt(request.getParameter("su2"));
		int sum = 0;
		switch (op) {
		case "+":
			sum = s1 + s2;
			break;
		case "-":
			sum = s1 - s2;
			break;
		case "/":
			sum = s1 / s2;
			break;
		case "*":
			sum = s1 * s2;
			break;

		}
		msg ="숫자1"+op+"숫자2 :" + sum;
		return msg;
	}
}
