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

	// 리스트
	public static List<BVO> getList() {
		List<BVO> list = null;
		list = getSession().selectList("list");
		return list;
	}
	
	// 리스트 (시작번호 , 끝번호 )
	public static List<BVO> getList(int begin , int end) {
		List<BVO> list = null;
		// 파라미터값이 하나 이상이므로 VO 또는 Map을 만들어서 넣어주어야 한다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		
		list = getSession().selectList("plist", map);
		return list;
	}

	// 삽입
	public static int getInsert(BVO bvo) {
		int result = 0;
		result = getSession().insert("insert", bvo);
		ss.commit();
		return result;
	}

	// 조회수 업데이트
	public static int getHitUp(String b_idx) {
		int result = 0;
		result = getSession().update("hitup", b_idx);
		ss.commit();
		return result;
	}

	// 상세내용 가져오기
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
		return result;
	}

	// 업데이트
	public static int getUpdate(BVO bvo) {
		int result = 0;
		result = getSession().update("update", bvo);
		ss.commit();
		return result;

	}

	// 댓글 가져오기
	public static List<CVO> getclist(String b_idx) {
		List<CVO> clist = null;
		clist = getSession().selectList("clist", b_idx);
		return clist;

	}
	
	// 댓글쓰기
	public static int getC_Insert(CVO cvo) {
		int result = 0 ; 
		result = getSession().insert("c_write", cvo);
	    ss.commit();
	    return result;	
	}
	
	// 댓글 삭제
	public static int getC_delete(String c_idx) {	
		int result = 0;
		result = getSession().delete("c_delete", c_idx);
		ss.commit();
		return result;
	}
	
	// 원글 삭제를 위해 관련 댓글 삭제하기
	public static int getC_AllDelete(String b_idx) {
		int	result = 0;
		result = getSession().delete("c_alldelete", b_idx);
		ss.commit();
		return result;
		
	}
	// 전체 게시물의 수 구하기.
	public static int getCount() {
		int result = 0;
		result = getSession().selectOne("count");
		return result;
		
	}
}
