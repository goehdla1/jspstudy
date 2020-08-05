package com.ict.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

// DB처리하는 클래스
public class DAO {
	// MyBatis는 SqlSession클래스를 사용
	private static SqlSession ss;

	// 싱글턴 패턴
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}

	public static int getCount() {
		int result = 0;
		result = getSession().selectOne("count");
		return result;
	}

	public static List<VO> getList(int begin, int end) {
		List<VO> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);

		list = getSession().selectList("list", map);
		return list;
	}

	public static int getInsert(VO vo) {
		int result = 0;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result;
		
	}
	// 조회 수 업데이트
	public static void getHit(String idx) {
			getSession().update("hitup", idx);
			ss.commit();
	}
	// 리스트
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
		
	}
	// 업데이트
	public static int getUpdate(VO vo) throws Exception{
		int result = 0;
		result = getSession().update("update", vo);
		ss.commit();
		return result;
	}
	// 삭제
	
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("delete", idx);
		ss.commit();
		return result;
		
	}
	
	// 댓글 레벨 up 기존 원글에 달려 있는 댓글의 lev를 업데이트.
	public static void getUP_lev(Map<String,Integer> map) {
		getSession().update("lev_up", map);
		ss.commit();
	}
	
	// 댓글 삽입
	public static int getAns_Insert(VO vo) {
		int result = 0;
		getSession().update("ans_insert", vo);
		ss.commit();
		return result;
	}
	

}
