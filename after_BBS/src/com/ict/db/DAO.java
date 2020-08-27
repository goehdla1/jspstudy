package com.ict.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.ibatis.session.SqlSession;
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

	// 전체 게시물의 수 구하기
	public static int getConunt() {
		int count = 0;
		count = getSession().selectOne("count"); // 1개의 수로 나온다.
		return count;
		
	}
	
	
	
	
	
	
	
	// 전체 리스트 보기
	public static List<VO> getList(int begin , int end) {
		List<VO> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = getSession().selectList("list", map);
		return list;
	}
	
	// 원글 정보 입력.
	
	public static int getInsert(VO vo) {
		int result = 0 ;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result ;
		
	}
	
	

}
