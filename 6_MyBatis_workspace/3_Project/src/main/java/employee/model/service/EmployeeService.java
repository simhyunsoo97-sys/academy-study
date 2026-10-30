package employee.model.service;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import common.JDBCTemplate;
import common.Template;
import employee.model.dao.EmployeeDAO;
import employee.model.vo.Employee;

/*
 * Service : Controller(Servlet) 와 DAO 사이의 "중간 관리자"
 *  - DB 연결(Connection)을 준비해서 DAO 에게 넘겨주고
 *  - (INSERT/UPDATE/DELETE 같은 작업이면) 결과를 보고 commit / rollback 을 결정하는 곳
 *  - 이번 로그인은 조회(SELECT)만 하니까 commit / rollback 은 필요 없음
 */
public class EmployeeService {
	// 실제 SQL 을 실행할 DAO 객체 (Service 가 DAO 에게 일을 시킴)
	private EmployeeDAO empDAO = new EmployeeDAO();

	// 로그인 처리
	// 매개변수 e   : Servlet 이 넘겨준 "사용자가 입력한" 사원번호 / 비밀번호
	// 반환값       : DB 에 일치하는 사원이 있으면 그 사원 정보(Employee), 없으면 null
	public Employee login(Employee e) {
		SqlSession session = Template.getSqlSession();
		Employee loginEmp = empDAO.login(session, e);
		return loginEmp;
		// 3) 결과를 Servlet 에게 그대로 돌려줌
		//    (Connection 은 JDBCTemplate 에서 싱글톤으로 공유해서 쓰는 중이라 여기서 close 하지 않음
		//     → 자세한 이유는 JDBCTemplate.close(Connection) 위의 주석 참고)
		
	}

	public ArrayList<Employee> selectAll() {
		Connection conn = getConnection();
		ArrayList<Employee> list = empDAO.selectAll(conn);
		return list;
	}

	public int insertEmployee(Employee e) {
		Connection conn = getConnection();
		int result = empDAO.insertEmployee(conn, e);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int updateEmployee(Employee e) {
		Connection conn = getConnection();
		int result = empDAO.updateEmployee(conn, e);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int checkEmpNo(int value) {
		Connection conn = getConnection();
		int result = empDAO.checkEmpNo(conn, value);
		return result;
	}

	public int UpdateStateServlet(int id, String col, String value) {
		Connection conn = getConnection();
		int result = empDAO.updateState(conn, id, col, value);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
		
	}
}
