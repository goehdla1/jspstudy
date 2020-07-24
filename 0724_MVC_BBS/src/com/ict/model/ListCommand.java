package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class ListCommand  implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	List<BVO> list = DAO.getList();
	// 여기서 써먹기 위해 저장한다.
	request.setAttribute("list", list);
	return "view/list.jsp";
}
}
