package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xml_DataCommand02 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product name=\"�������\" price=\"1000\" />");
		sb.append("<product name=\"�ٳ�������\" price=\"1000\" />");
		sb.append("<product name=\"�������\" price=\"1000\" />");
		sb.append("<product name=\"ź������\" price=\"900\" />");
		sb.append("</products>");
		return sb.toString();
	}
}
