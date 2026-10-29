package employee.model.dao;

import java.sql.Connection;
import employee.model.vo.Employee;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.JDBCTemplate;

/*
 * DAO (Data Access Object) : DB 에 직접 SQL 을 날리는 클래스
 *  - SQL 실행 → 결과(ResultSet)를 VO(Employee)에 옮겨 담아서 → Service 에게 돌려줌
 *  - DB 연결(Connection)은 직접 만들지 않고 Service 에게 매개변수로 받아서 씀
 */
public class EmployeeDAO {

	// 로그인 : 입력한 사원번호 + 비밀번호가 둘 다 일치하는 사원이 있는지 조회
	public Employee login(Connection conn, Employee e) {
		PreparedStatement pstmt = null;	// SQL 을 실행시켜 주는 객체
		ResultSet rset = null;			// SELECT 결과(표)를 담는 객체
		Employee loginEmp = null;		// 돌려줄 결과 (일치하는 사원이 없으면 null 그대로 반환됨)

		// ※ SCOTT 계정의 EMP 테이블에 비밀번호 컬럼 PWD 를 추가해서 씀
		//   → 프로젝트 폴더의 db_setup.sql 을 먼저 실행해야 함 (테스트 계정 : 사원번호 7369 / 비밀번호 1234)
		//   → 학원에서 다른 테이블을 쓰면 아래 SQL 의 테이블명 / 컬럼명만 바꾸면 됨
		// ? (위치홀더) : 값이 들어갈 자리를 비워둔 것 → 아래 setString() 으로 채움
		//   문자열을 + 로 이어붙이지 않고 ? 를 쓰면 SQL Injection(해킹) 공격을 막을 수 있음
		String query = "SELECT EMPNO, PWD FROM EMP WHERE EMPNO = ? AND PWD = ?";

		try {
			// 1) SQL 을 미리 준비(컴파일)
			pstmt = conn.prepareStatement(query);

			// 2) ? 자리에 값 채우기 (순서는 1번부터 시작! 0번 아님)
			pstmt.setString(1, e.getEmpNo());
			pstmt.setString(2, e.getPwd());

			// 3) 실행 : SELECT 는 executeQuery() → ResultSet 반환
			//          (INSERT/UPDATE/DELETE 는 executeUpdate() → 처리된 행 개수(int) 반환)
			rset = pstmt.executeQuery();

			// 4) 결과 꺼내기
			//    rset.next() : 다음 행이 있으면 그 행으로 이동하고 true / 없으면 false
			//    사원번호는 겹치지 않으니(PK) 결과는 최대 1행 → while 말고 if 로 충분
			if(rset.next()) {
				loginEmp = new Employee();
				loginEmp.setEmpNo(rset.getString("EMPNO"));	// getString("컬럼명") 으로 값 꺼내기
				loginEmp.setPwd(rset.getString("PWD"));
			}
		} catch (SQLException ex) {
			// 주의) 매개변수 이름이 이미 e 라서 catch 변수까지 e 로 하면 "Duplicate local variable e" 컴파일 에러 → ex 로 씀
			ex.printStackTrace();
		} finally {
			// 5) 에러가 나든 안 나든 다 쓴 자원은 반드시 닫기 (finally 는 무조건 실행됨)
			//    여는 순서의 반대로 닫음 : rset → pstmt
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return loginEmp;
	}
}
