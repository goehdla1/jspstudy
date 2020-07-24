package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DB처리하는 클래스
public class DAO {
	// MyBatis는 SqlSession클래스를 사용 
	private static SqlSession ss;
	
	// 싱글턴 패턴
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	// 리스트
	public static List<VO> getList(){
		 List<VO> list = null;
		 list = getSession().selectList("list");
		 return list;
	}
	
	// 저장
	public static int getInsert(VO vo) {
		int result = 0 ;
		result = getSession().insert("insert", vo);
		return result;
	}
	
	// one list
	public static VO getOneList(String idx) {
		VO vo = new VO();
		
		vo = getSession().selectOne("onelist", idx);
		return vo;
		
	}
	
	// delete
	public static int getDelete(String idx) {
		int result = 0 ;
		result = getSession().delete("delete", idx);
		return result ;
		
	}
}








