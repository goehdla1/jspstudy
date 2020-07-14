package com.ict.model;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Project01 {

	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		int sum = 0;
		double avg = 0;
		String hak = "";

		sum = kor + eng + math;
		avg = (int) (sum / 3.0 * 10) / 10.0;

		if (avg >= 90) {
			hak = "A";

		} else if (avg >= 80) {
			hak = "B";

		} else if (avg >= 70) {
			hak = "C";

		} else {
			hak = "F";
		}
		
		msg = "이름:"+name+"\t"+"총점:"+sum+"\t"+"평균:"+avg+"학점"+hak;
		return msg;
	}

}
