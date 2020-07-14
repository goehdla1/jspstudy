package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cmd02 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String msg = ""; // 처리 결과를 저장 변수
		// 일처리
		// msg = String.valueOf((int) (Math.random() * 101)); // 모든 정수,실수를 스트링으로 변환하는 방법.
		msg = "오늘의 운수는" + (int) (Math.random() * 101) + "% 입니다.";

		return msg;
	}
}
