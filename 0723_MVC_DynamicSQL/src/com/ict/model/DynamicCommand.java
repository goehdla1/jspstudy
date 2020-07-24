package com.ict.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class DynamicCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String keyword = request.getParameter("keyword");
		
		String str = "";
		if(keyword.equals("")|| idx.equals("0")) {
			str = "view/index.jsp";
		}else {
			// 파라미터값인데 VO에 없으면서 여러개 이면 무조건 Map를 사용한다.
			Map<String, String> map = new HashMap<String, String>();
			map.put("idx", idx);
			map.put("keyword", keyword);
			
			List<VO> dy_list = DAO.getDynamic(map);
			
			request.setAttribute("dy_list", dy_list);
			request.setAttribute("idx", idx);
			
			str = "view/result_dynamic.jsp";
		}
		return str;
	}
}
