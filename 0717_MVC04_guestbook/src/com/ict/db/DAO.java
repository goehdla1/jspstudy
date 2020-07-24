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
	
	// 접속
	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user  = "c##ha6511";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		}
		return conn;
	}
	
	// 리스트
	public ArrayList<VO> getList(){
		ArrayList<VO> list = new ArrayList<VO>();
		try {
			conn = getConnection();
			String sql = "select * from guestbook order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
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
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}
	
	// 삽입
	public int getInsert(VO vo) {
		int result = 0 ;
		try {
			conn = getConnection();
			String sql = "insert into guestbook "
					+ " values(guestbook_seq.nextval,?,?,?,?,?,sysdate)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getContent());
			pstm.setString(4, vo.getEmail());
			pstm.setString(5, vo.getPwd());
			result = pstm.executeUpdate();
		} catch (Exception e) {
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
	// 상세정보 
	public VO getOneList(String idx) {
		VO vo = new VO();
		try {
			conn = getConnection();
			String sql = "select * from guestbook where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idx);
			rs = pstm.executeQuery();
			while(rs.next()) {
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
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return vo;
	}
	
	public int getDelete(String idx) {
		int result = 0 ;
		try {
			conn = getConnection();
			String sql = "delete from guestbook where idx = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, idx);
			
			result = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
	public int getUpdate(VO vo) {
		int result = 0 ;
		try {
			conn = getConnection();
			String sql = "update guestbook set name=?, subject=?, content=?, email=? where idx=?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getContent());
			pstm.setString(4, vo.getEmail());
			pstm.setString(5, vo.getIdx());
			
			result = pstm.executeUpdate();
			
		} catch (Exception e) {
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
}








