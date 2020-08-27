package com.ict.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sun.corba.se.pept.transport.Connection;

public class DAO {
	java.sql.Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	private static DAO dao = new DAO();

	public static DAO getInsetance() {
		return dao;
	}

	public java.sql.Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@203.236.220.59";
			String user = "c##ha6511";
			String password = "1111";

			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

		}
		return conn;
	}
	
	public ArrayList<VO> getList(){
			ArrayList<VO> list = new ArrayList<VO>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM guestbook order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				VO vo = new VO();
				vo.setIdx(rs.getNString("idx"));
				vo.setName(rs.getNString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getNString("content"));
				vo.setEmail(rs.getNString("email"));
				vo.setPwd(rs.getNString("pwd"));
				vo.setRegdate(rs.getNString("regdate"));
				list.add(vo);
				
			}
			
		} catch (Exception e) {
		
		}finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return list;
	}
	
	public int getInsert(VO vo) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO guestbook VALUES(guestbook_seq.nextval,?,?,?,?,?,sysdate)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setNString(2, vo.getSubject());
			pstm.setNString(3, vo.getContent());
			pstm.setNString(4, vo.getEmail());
			pstm.setNString(5, vo.getPwd());
			
			result = pstm.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			
		}finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
				
			} catch (Exception e2) {
				
			}
		}return result;
		
	}
	
	public VO getOneList(String idx) {
		VO vo = new VO();
		try {
			conn = getConnection();
			String sql = "select * from guestbook where idx=?";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				vo.setIdx(rs.getNString("idx"));
				vo.setName(rs.getNString("name"));
				vo.setSubject(rs.getNString("subject"));
				vo.setContent(rs.getNString("content"));
				vo.setEmail(rs.getNString("email"));
				vo.setRegdate(rs.getNString("regdate"));
			
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
				
			} catch (Exception e2) {
				
			}
		}
		return vo;
	}
	
	public int getUpdate(VO vo) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "update guestbook set name=?,subject=?,content=?,email=? where idx=?";
			pstm = conn.prepareStatement(sql);
			pstm.setNString(1, vo.getName());
			pstm.setNString(2, vo.getSubject());
			pstm.setNString(3, vo.getContent());
			pstm.setNString(4, vo.getEmail());
			pstm.setString(5,  vo.getEmail());
			
			result = pstm.executeUpdate();
			
		} catch (Exception e) {
			
		}finally {
			try {
				pstm.close();
				conn.close();
				
			} catch (Exception e2) {
				
			}
		}
		return result;
	}
}
