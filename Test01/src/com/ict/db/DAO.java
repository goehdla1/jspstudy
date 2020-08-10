package com.ict.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.corba.se.pept.transport.Connection;

public class DAO {

	java.sql.Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private static DAO dao = new DAO();

	public static DAO getInstance() {
		return dao;

	}

//접속
	public java.sql.Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
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
			String sql = "select *from guestbook order by idx";
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
			
		}finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
				
			} catch (Exception e2) {
				
			}
		}
		return list;
	}
}