package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Json_DataCommand04 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("{\"name\":\"커피우유\", \"price\":\"950\"},");
		sb.append("{\"name\":\"이온음료\", \"price\":\"1500\"},");
		sb.append("{\"name\":\"탄산수\", \"price\":\"1900\"},");
		sb.append("{\"name\":\"카페라떼\", \"price\":\"2400\"}");
		sb.append("]");
		
		return sb.toString();
	}
}
