package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xml_DataCommand01 {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product>");
		sb.append("<name>딸기우유</name>");
		sb.append("<price>1000</price>");
		sb.append("</product>");
		
		sb.append("<product>");
		sb.append("<name>초코우유 </name>");
		sb.append("<price>1000</price>");
		sb.append("</product>");
		
		sb.append("<product>");
		sb.append("<name>커피우유</name>");
		sb.append("<price>1000</price>");
		sb.append("</product>");
		
		
		sb.append("<product>");
		sb.append("<name>흰우유</name>");
		sb.append("<price>1000</price>");
		sb.append("</product>");
		
		sb.append("</products>");
		return sb.toString();
	}
}
