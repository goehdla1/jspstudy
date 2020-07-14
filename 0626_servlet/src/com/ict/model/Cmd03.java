package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cmd03 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String msg = ""; // 처리 결과를 저장 변수
		// 일처리
		String ip = request.getRemoteAddr();
		msg = "당신의 IP주소는"+ip+"입니다.";
		return msg;
	}
}
