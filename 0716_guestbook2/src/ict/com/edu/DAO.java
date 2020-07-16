package ict.com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	// 싱글톤 패턴 : 프로그램이 끝날 때까지 하나의 객체를 사용
	// 필요한 객체를 또 만들지 않고 한번 만든 객체를 재사용하는 것
	private static DAO dao = new DAO();

	public static DAO getInstance() {
		return dao;
	}

	// 접속
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

	// 리스트 실행할 메소드
	public ArrayList<VO> getList() {
		ArrayList<VO> list = new ArrayList<VO>();
		try {
			conn = getConnection();
			String sql = "select * from guestbook2 order by idx";
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
				vo.setFile_name(rs.getString("file_name"));
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

	// 정보를 받아서 삽입하는 메소드
	public int getInsert(VO vo) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "insert into guestbook2 values(guestbook2_seq.nextval,?,?,?,?,?,?,sysdate)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getContent());
			pstm.setString(4, vo.getEmail());
			pstm.setString(5, vo.getPwd());
			pstm.setString(6, vo.getFile_name());

			result = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	// 기본키 idx를 받아서 상세페이지 정보를 가져온다.
	public VO getOnelist(String idx) {
		VO vo = new VO();
		try {
			conn = getConnection();
			String sql = "select * from guestbook2 where idx = ?";
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
				vo.setFile_name(rs.getString("file_name"));
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

	// 정보를 받아서 업데이트 하자
	public int getUpdate(VO vo) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "update guestbook2 set name=?, subject=?, content=?, email=? , file_name=? "
					+ " where idx=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getContent());
			pstm.setString(4, vo.getEmail());
			pstm.setString(5, vo.getFile_name());
			pstm.setString(6, vo.getIdx());

			result = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	public int getDelete(String idx) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "delete from guestbook2 where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idx);

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
