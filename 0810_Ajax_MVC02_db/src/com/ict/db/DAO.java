package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DB처리하는 클래스
public class DAO {

	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	public static List<VO> getList(){
		List<VO> list = null;
		list = getSession().selectList("list");
		return list;
		
	}
	
	public static List<VO> getIdChk(String m_id){
		
		List<VO> list = null;
		list = getSession().selectList("idchk",m_id);
		return list;
	}
	
	public static int getInsert(VO vo) {
		int result = 0;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result ;
	}
}








