package employee.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import common.JDBCTemplate;
import employee.model.vo.Employee;


public class EmployeeDAO {

	public Employee login(Connection conn, Employee e) {
		PreparedStatement pstmt = null;	
		ResultSet rset = null;			
		Employee loginEmp = null;		

		
		String query = "SELECT * FROM v_employee WHERE EMPNO = ? AND PWD = ? and status='Y'";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getPwd());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginEmp = new Employee(rset.getInt("empNo"), 
										rset.getString("pwd"), 
										rset.getString("ename"), 
										rset.getString("job"), 
										rset.getInt("mgr_No"), 
										rset.getString("mgr"), 
										rset.getDate("hireDate"), 
										rset.getInt("sal"), 
										rset.getInt("comm"), 
										rset.getInt("deptNo"), 
										rset.getString("dname"), 
										rset.getString("is_Admin"), 
										rset.getString("status"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return loginEmp;
	}

	public ArrayList<Employee> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		String query = "select * from v_employee";
		

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				list.add(new Employee(rset.getInt("empNo"), 
							rset.getString("pwd"), 
							rset.getString("ename"), 
							rset.getString("job"), 
							rset.getInt("mgr_No"), 
							rset.getString("mgr"), 
							rset.getDate("hireDate"), 
							rset.getInt("sal"), 
							rset.getInt("comm"), 
							rset.getInt("deptNo"), 
							rset.getString("dname"), 
							rset.getString("is_Admin"), 
							rset.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;

	}

	public int insertEmployee(Connection conn, Employee e) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into emp values(?, ? , ?, " + e.getMgrNo() + ", sysdate, ?, ?, ?, default, ?, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getSal());
			pstmt.setInt(5, e.getComm());
			pstmt.setInt(6, e.getDeptNo());
			pstmt.setString(7, e.getIsAdmin());
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateEmployee(Connection conn, Employee e) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update emp set pwd=?, ename=?, job=?, sal=?, comm=?, deptno=? where empno=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, e.getPwd());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getSal());
			pstmt.setInt(5, e.getComm());
			pstmt.setInt(6, e.getDeptNo());
			pstmt.setInt(7, e.getEmpNo());	
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
		
	}

	public int checkEmpNo(Connection conn, int value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		
		String query = "select count(*) from emp where empno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, value);
			rset = pstmt.executeQuery();
			if(rset.next()) {
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

}