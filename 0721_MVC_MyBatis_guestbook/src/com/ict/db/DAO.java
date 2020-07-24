package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DB처리하는 클래스
public class DAO {
	// MyBatis는 SqlSession 클래스를 사용
	
	private static SqlSession ss;
	
	// 싱글턴 패턴
	private synchronized static SqlSession getSession() {
		if (ss == null){
			// 커밋은 select에는 의미가 없다.
			// insert , update , delete 는 커밋을 해야한다.(변경)
			
			// 자동 커밋 안된다. : 개발자가 커밋 명령을 해야한다.
			// 					   나중에 트랜잭션 처리 할때 필요한다.
			//ss = DBService.getFactory().openSession();
			ss = DBService.getFactory().openSession(false);
			// 자동 커밋 된다.
			//ss = DBService.getFactory().openSession(true);
			
		}
		return ss;
		
	}
	
	// SqlSession 이용해서 DB처리
	// 리스트 : select문의 결과가 여러개 이므로 반환형 List<VO>
	//          select문의 결과가 하나 이므로 반환형 VO
	public static List<VO> getList(){
		List<VO> list = null;
		// 여러개 일때
		//list = getSession().selectList("mapper의 id");
		//list = getSession().selectList("mapper의 id",파라미터);
		
		// 하나일때
		//VO = getSession().selectOne("mapper의 id");
		//VO = getSession().selectOne("mapper의 id",파라미터);
		// maaper.xml의 id가 list인 태그를 찾아서 결과를 받는다.
		list = getSession().selectList("list"); //mapper(실제 db를날리고 db정보를 받는다.) 를 찾아간다.
		ss.commit(); // DB에 적용
		return list;
	}
	// 삽입
	public static int getInsert(VO vo) {
		int result = 0 ; 
		result = getSession().insert("insert", vo);
		ss.commit();
		return result;
		
		
	}
	// OneList
	public static VO getOneList(String idx){
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		ss.commit();
		return vo;
		
	}
	
	// Delete
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("delete", idx);
		ss.commit();
		return result;
		
	}
	
	//update
	public static int getUpdate(VO vo) {
		int result = 0;
		result = getSession().update("update", vo);
		ss.commit();
		return result;
		
	}

}








