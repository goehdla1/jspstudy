package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Project03 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		int total = 0;
		int pay = 8590;
		int overpay = (int)(8590*1.5);
		int time = Integer.parseInt(request.getParameter("time"));
		
		if (time>8) {
			total = pay*8 + (time-8)*overpay;
			
			
		}else if (time<=8) {
			total = pay*time;
			
		}
		msg = "알바비 : " + total;
		return msg;
	}
}
