package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xml_DataCommand03 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product price=\"1000\">딸기우유</product>");
		sb.append("<product price=\"1000\">초코우유</product>");
		sb.append("<product price=\"1000\">커피우유</product>");
		sb.append("<product price=\"900\">그냥우유</product>");
		sb.append("</products>");
		
		return sb.toString();
	}
}
