package cum.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cum.kh.model.vo.Employee;

public class EmployeeDAO {

	public ArrayList <Employee> selectAll() {
		ArrayList <Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			// 0. Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 1. DB 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "SCOTT");
			
			//System.out.println(conn);
			//2. 쿼리 작성
			String query = "select * from emp";
			
			// 3.쿼리 전송 및 처리 결과
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("job");
				int mgr = rset.getInt("mgr");
				Date dt = rset.getDate("hireDate");
				int sal = rset.getInt("sal");
				int comm = rset.getInt("comm");
				int dept = rset.getInt("deptNo");
				Employee e = new Employee(empNo, empName, job, mgr, dt,  sal, comm, dept);
				list.add(e);				
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return list;		
	}

	public Employee selectEmployee(int empNo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		Employee emp = null;
		try {
			// 0. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 1. DB접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			
			// 2. 쿼리 작성
			String query = "select * from emp where empno = " + empNo;
			
			// 3. 쿼리 전송 및 처리 결과
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) { 				
				emp = new Employee(empNo,
											rset.getString("ename"),
											rset.getString("job"),
											rset.getInt("mgr"),
											rset.getDate("hireDate"),
											rset.getInt("sal"),
											rset.getInt("comm"),
											rset.getInt("deptNo"));
											
				
			}
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return emp;
		
	}

	public int insertEmployee(Employee e) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			// Statement객체
			// 		단순 SQL문을 실행하는데 사용, 동적 쿼리 문자열을 그대로 실행
			//		문자열 결합 방식으로 쿼리를 구성하여  SQL인젝션 위험이 높음
			// PreparedStatement객체
			// 		SQL문을 미리 컴파일 하고 위치홀더 ? 를 이용하여 파라미터 바인딩
			//		파라미터 바인딩을 통해 SQL구문과 값이 분리되어 처리되므로 SQL인젝션 방어에 효과적
			
			// SQL인젝션? 사용자가 입력한 값이 데이터로 쓰이지 않고 문법의 이부로 해석이 되어 개발자가 의도하지 않은 쿼리 실행
			// ex. String query = select * from emp where empno = " + no + "and ename = '" + empName + "'";
			// no에 입력된 값: 88 --
			// empName에 입력된 값: rose
			//		=> select * from emp where empno = 88 --, ename = 'rose'
			
//			String query = "insert into emp values(" + e.getEmpNo() +", '"  + e.getEmpName() +"', '"
//								+ e.getJob() + "', " + e.getMgr() + ", sysdate, " + e.getSal() + ", "
//								+ e.getComm() + ", " + e.getDeptNo() + ")";
			String query = "insert into emp values(?, ?, ?, ?, sysdate, ?, ?, ?)"; // ?  <-물으표 아니고 위치홀더
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getMgr());
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComm());
			pstmt.setInt(7, e.getDeptNo());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();				
			} else {
				conn.rollback();
			}			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
		return result;
	}

	public int updateEmployee(Employee emp) {
		// PreparedStatement ver.
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query = "update emp set job = ?, sal = ?, comm = ? where empNo = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getJob());
			pstmt.setInt(2, emp.getSal());
			pstmt.setInt(3, emp.getComm());
			pstmt.setInt(4, emp.getEmpNo());
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
		
		
		

	}

	public int deleteEmployee(int empNo) {	
		// Statement ver.
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query ="delete from emp where empNo = " + empNo;
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();						
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
						
		}
	}

