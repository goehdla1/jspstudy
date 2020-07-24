package com.ict.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// MUltipartRequest 객체 생성

		try {
			String path = request.getServletContext().getRealPath("/upload");
			MultipartRequest mr = new MultipartRequest(request, path, 100 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			// 파라미터값 받아서 DB에 저장
			VO vo = new VO();
			vo.setName(mr.getParameter("name"));
			vo.setSubject(mr.getParameter("subject"));
			vo.setContent(mr.getParameter("content"));
			vo.setEmail(mr.getParameter("email"));
			vo.setPwd(mr.getParameter("pwd"));
			// 첨부 파일을 업로드 할때와 하지 않을때로 구분. // 첨부파일을 바로 올리지 않으면 오류가 난다.
			if (mr.getFile("file_name") != null) {
				vo.setFile_name(mr.getFilesystemName("file_name"));
				
			} else {
				vo.setFile_name("");
			}
			int result = DAO.getInstance().getInsert(vo);
			request.setAttribute("result", result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "view/write_ok.jsp";
	}

}
