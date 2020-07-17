package com.ict.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private static DAO dao = new DAO();

	public static DAO getInstance() {
		return dao;
	}

	public Connection getConnection() {
		try {
			// 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@203.236.220.59:1521:xe";
			String user = "c##ha6511";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		}
		return conn;
	}

	// 리스트
	public ArrayList<VO> getList() {
		ArrayList<VO> list = new ArrayList<VO>();
		try {
			conn = getConnection();
			String sql = "select*from guestbook order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
				list.add(vo);

			}
		} catch (Exception e) {

		} finally {
			try {
				conn.close();
				pstm.close();
				rs.close();

			} catch (Exception e2) {

			}

		}
		return list;

	}

	// 삽입하기
	public int getInsert(VO vo) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?,?,?,sysdate)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getEmail());
			pstm.setString(4, vo.getPwd());
			pstm.setString(5, vo.getContent());

			result = pstm.executeUpdate();
		} catch (Exception e) {

		} finally {
			try {
				conn.close();
				pstm.close();

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return result;

	}

	// 전체 리스트보기

	public VO getOneList(String idx) {
		VO vo = new VO();
		try {
			conn = getConnection();
			String sql = "select * from guestbook where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idx);
			rs = pstm.executeQuery();

			while (rs.next()) {
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {

		} finally {
			try {
				conn.close();
				pstm.close();
				rs.close();

			} catch (Exception e2) {

			}
		}
		return vo;

	}

	// 삭제하기
	public int getDelete(String idx) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "delete from guestbook where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idx);
			result = pstm.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				conn.close();
				pstm.close();

			} catch (Exception e2) {

			}
		}
		return result;

	}

	// 업데이트하기
	public int getUpdate(String name, String subject, String email, String content, String idx) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "update guestbook set name=? , subject = ? , email = ? , content = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, subject);
			pstm.setString(3, email);
			pstm.setString(4, content);
			pstm.setString(5, idx);
			result = pstm.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				conn.close();
				pstm.close();

			} catch (Exception e2) {

			}
		}
		return result;

	}
}
