package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Text_DataCommand05 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		sb.append("1,홍길동,24,서울/");
		sb.append("2,고길동,23,서울/");
		sb.append("3,나둘리,14,서울/");
		sb.append("4,마이콜,28,서울/");
		sb.append("5,희동이,3,서울/");
		return sb.toString();
	}
}
