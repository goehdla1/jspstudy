package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class ListCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		Paging page = new Paging();
		
		// 1 . 전체 게시물의 수
		int count = DAO.getConunt();
		// 전체 게시물의 수를 totalrecord에 넣어준다.
		page.setTotalRecord(count);
		
		// 2. 전체 게시물의 수를 가지고 전체 페이지의 수를 구한다.
		if (page.getTotalRecord() <= page.getNumPerPage()) {
			page.setTotalPage(1);
		}else {
			page.setTotalPage(page.getTotalRecord()/page.getNumPerPage());
			if (page.getTotalRecord() % page.getNumPerPage() != 0) {
				page.setTotalPage(page.getTotalPage()+1);
			}
		}
		// 3. 현제 페이지 구하기
				// cmd가 listlist.jsp로 부터 cPage 파라미터가 들어오는데
				// cPage 파라미터는 현재 페이지를 의미 하는 것이다.
				// 맨 처음 list.jsp에서는 cPage가 안들어온다. 그때는 현재 페이지를 1 페이지로 지정하자.(nowPage = 1)
				// 그 다음부터는 cPage가 무조건 들어와야 하고 cPage를 nowPage로 변경시키자.
		 // 3. cPage를 받아서 현재 페이지로 변경하자.
		 String cPage = request.getParameter("cPage");
		 page.setNowPage(Integer.parseInt(cPage));
		 
		 // 4. 현재페이지를 이용해서 시작번호와 끝번호를 구하자.
		 page.setBegin((page.getNowPage()-1) * page.getNumPerPage()+1); 
		 page.setEnd((page.getBegin()-1)+page.getNumPerPage());
		 
		 
		 // 5. DB처리
		 List<VO> list = DAO.getList(page.getBegin(), page.getEnd());
		 
		 // 6. 현재 페이지의 시작 블록과 끝 블록 번호 구하기
		 // 시작블록에 의해서 엔드블록이 결정 된다.
		 page.setBeginBlock((int)((page.getNowPage()-1)/page.getPagePerBlock())*page.getPagePerBlock()+1);
		 page.setEndBlock(page.getBeginBlock()+page.getPagePerBlock()-1);
		 // 1 block => 1p ~ 3p , 2 block 4p ~ 6p , 3 block = > 7p ~ 9p 
		 
		 // 주의 사항 : 계산으로 구한 endBlock 의 페이지와 실제 데이터를 가지고 구한 totalPage의 값이 다를 수 가 있다.
		 // 즉 endblock의 값이 totalPage보다 큰경우가 발생했을 때
		 // endblock 값을 totalPage로 변경해야 된다.
		 
		 if(page.getEndBlock()>page.getTotalPage()) {
			 page.setEndBlock(page.getTotalPage());
		 }
		
		// 처리한 결과를 저장
		request.setAttribute("list", list);
		// 변경된 상황을 페이지에 저장한다.
		request.setAttribute("page", page);
		
		request.getSession().setAttribute("cPage", cPage);
		
		return "view/list.jsp";
	}
}
