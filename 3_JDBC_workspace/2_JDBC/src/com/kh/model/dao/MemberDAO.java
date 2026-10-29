package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;
/*
이전 프로젝트(1_JDBC)에서 DAO가 맡은 업무
	1) JDBC 드라이버 등록
	2) DB 연결 Connection 객체 생섯
	3) SQL 실행
	4) 처리 결과에 따른 트랜젝션
	5) 자원 반환
-> 실제 DAO가 처리해야 하는 업무는 SQL문을 DB에 전달 및 실행하고 반환 값을 받아오는 3번 뿐
->1, 2, 4, 5 업무 분리 진행
	공통 코드를 갖고 있는 JDBCTemplate, DAO 보조 역할인 Service
	
*/

public class MemberDAO {

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, default)";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender()+"");
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getaddress());
			pstmt.setInt(8, m.getAge());			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = "select * from member";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				list.add(new Member(rset.getString("member_id"),
									rset.getString("member_pwd"),
									rset.getString("member_name"),
									rset.getString("gender").charAt(0),
									rset.getString("email"),
									rset.getString("phone"),
									rset.getInt("age"),
									rset.getString("address"),
									rset.getDate("enroll_Date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}				
		return list;
	}

	public ArrayList<Member> selectMemberId(Connection conn, String id) {
		// 부분검색 가능
		// ex. 검색어 : user01 -> user01
		//	   검색어 : us -> user01, user02, user03, ....
		//	   검색어 : er -> user01, user02, user03, ....
		ArrayList<Member> list = new ArrayList<Member>();

	    Statement stmt = null;
	    ResultSet rset = null;

	    String query = "select * from member where member_id like '%" + id + "%'";
	    try {
	        stmt = conn.createStatement();
	        rset = stmt.executeQuery(query);
	        while(rset.next()) {
	            list.add(new Member(rset.getString("member_id"),
				                    rset.getString("member_pwd"),
				                    rset.getString("member_name"),
				                    rset.getString("gender").charAt(0),
				                    rset.getString("email"),
				                    rset.getString("phone"),
				                    rset.getInt("age"),
				                    rset.getString("address"),
				                    rset.getDate("enroll_date")));				                    	            
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rset);
	        close(stmt);
	    }		
		return list;
	}

	
	public ArrayList<Member> selectGender(Connection conn, char gen) {
	    // 위치홀더를 사용해서 값을 넣을 때는 완전한 데이터로만 인식하여 삽입
	    // 문자열 데이터일 때(setString()) 자동으로 싱글쿼테이션 ''이 감싸져서 들어감
		// 숫자 데이터일 때는 (setInt()) 싱글쿼테이션이 감싸지진 않음
	    ArrayList<Member> list = new ArrayList<Member>();

	    Statement stmt = null;
	    ResultSet rset = null;
	    String query = "select * from member where gender = '" + gen + "'";
	    try {
	        stmt = conn.createStatement();
	        rset = stmt.executeQuery(query);
	        while(rset.next()) {
	            list.add(new Member(rset.getString("member_id"),
				                    rset.getString("member_pwd"),
				                    rset.getString("member_name"),
				                    rset.getString("gender").charAt(0),
				                    rset.getString("email"),
				                    rset.getString("phone"),
				                    rset.getInt("age"),
				                    rset.getString("address"),
				                    rset.getDate("enroll_date")));	          		            
	        }  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	close(rset);
	    	close(stmt);
	    }
	    return list;
	}

	public int selectcheckMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "select count(*) from member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				//result = rset.getInt("count(*)");
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
		
	}

	public int selectupdateMember(Connection conn, String memberId, String updateStr, String input) {
		PreparedStatement pstmt = null;		
		int result = 0;
		
		String query = "update member set " + updateStr + " = ? where member_id = ?";

	    try {
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, input);
	        pstmt.setString(2, memberId);	        
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	
		
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;		
		int result = 0;
		
		String query = "delete from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
