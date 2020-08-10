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
	
	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@203.236.220.86";
			String user = "c##jwc";
			String password = "1112";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	
	public VO getOnelist(String idx) {
		VO vo = new VO();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM guestbook WHERE idx=?";
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
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return vo;
	}
	
	
	public ArrayList<VO> getList(){
		ArrayList<VO> list = new ArrayList<VO>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM guestbook order by idx";
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
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e) {

				
			}
		}
		
		return list;
	}
	
	public int getIDU(VO vo, String mth) {
		int result = 0;
		try {
			conn = getConnection();
			String sql;
			
			switch (mth) {
				case "Insert":
					sql = "INSERT INTO guestbook \n" + 
						  "VALUES(guestbook_seq.nextval, ?, ?, ?, ?, ?, SYSDATE)";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, vo.getName());
					pstm.setString(2, vo.getSubject());
					pstm.setString(3, vo.getContent());
					pstm.setString(4, vo.getEmail());
					pstm.setString(5, vo.getPwd());
					
					break;
				
				case "Update":
					sql = "UPDATE guestbook \n" + 
						  "SET name=?, subject=?, content=?, email=? WHERE idx=?";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, vo.getName());
					pstm.setString(2, vo.getSubject());
					pstm.setString(3, vo.getContent());
					pstm.setString(4, vo.getEmail());
					pstm.setString(5, vo.getIdx());
					
					break;
					
				case "Delete":
					sql = "DELETE FROM guestbook \n" + 
						  "where idx=?";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, vo.getIdx());
					
					break;
				
			}
			
			result=pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return result;
		
	}
	
	
	
}
