package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSession;
// DB처리하는 클래스
public class DAO {
	// MyBatis는 SqlSession클래스를 사용
	private static SqlSession ss;

	// 싱글턴 패턴
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			// 커밋은 select에는 의미가 없다.
			// insert, update, delete는 커밋을 해야 된다.

			// 자동 커밋 안됨 : 개발자가 커밋 명령을 해야된다.
			// 나중에 트랜잭션 처리 할때 필요한다.
			// ss = DBService.getFactory().openSession();
			// ss = DBService.getFactory().openSession(false);

			// 자동 커밋(오토커밋) 됨
			// ss = DBService.getFactory().openSession(true);

			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}

	// 방명록에 있는 전체정보를 가져오자 
	public static List<VO> getList(){
		List<VO> list = null;
		// selectList => 여러개 정보
		// ("list")   => 메퍼의 아이디가 list를 찾아
		//               실행하고 결과 받기 
		list = 	getSession().selectList("list");	
		return list;
	}
	public static int getInsert(VO vo) {
		int result = 0 ;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result;
	}
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("delete",idx);
		ss.commit();
		return result;
		
	}
	public static int getUpdate(VO vo) {
		int result = 0;
		result = getSession().update("update",vo);
		ss.commit();
		return result;
		
	}
}








