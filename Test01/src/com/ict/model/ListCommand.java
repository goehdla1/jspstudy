package com.ict.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class ListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<VO> list = DAO.getInstance().getList();
		return null;
	}

}
