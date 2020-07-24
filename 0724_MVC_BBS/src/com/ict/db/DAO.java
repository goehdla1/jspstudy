package com.ict.db;

import java.util.List;

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

	// 리스트
	public static List<BVO> getList() {
		List<BVO> list = null;
		list = getSession().selectList("list");
		return list;
	}

	// 삽입
	public static int getInsert(BVO bvo) {
		int result = 0;
		result = getSession().insert("insert", bvo);
		ss.commit();
		return result;
	}

	// 조회수 업데이트!!!!!!!!!!!!!!!!
	public static int getHitUp(String b_idx) {
		int result = 0;
		result = getSession().update("hitup", b_idx);
		ss.commit();
		return result;
		

	}

	// onelist
	public static BVO getOneList(String b_idx) {
		BVO bvo = null;
		bvo = getSession().selectOne("onelist", b_idx);
		return bvo;

	}
	// 삭제
	public static int getDelete(String b_idx) {
		int result = 0;
		result = getSession().delete("delete", b_idx);
		ss.commit();
		return result ;
		
	}
	
	// 업데이트
	public static int getUpdate(BVO bvo) {
		int result = 0;
		result = getSession().update("update", bvo);
		return result;
		
	}
}
