// ※ 이 파일의 코드 수정 : [수정 8] (총 1곳) / 표시 없는 코드는 학원 원본 그대로
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBCTemplate
 *  - DB 연결 / 커밋 / 롤백 / 자원반납(close)처럼 "매번 똑같이 반복되는 JDBC 코드"를 한 곳에 모아둔 공용 클래스
 *  - 전부 static 이라서 Service, DAO 어디서든 new 없이 JDBCTemplate.getConnection() 처럼 바로 꺼내 씀
 */
public class JDBCTemplate {
	// 싱글톤 패턴(Single Tone Pattern) : 프로그램 구동 시 메모리에 객체를 딱 하나만 기록되게 함
	// 모든 필드와 메소드를 static으로 선언하여 static 영역에서 공용으로 사용할 수 있게 함
	private static Connection conn = null;

	// 생성자를 private 으로 막아서 외부에서 new JDBCTemplate() 를 못 하게 함
	// (static 메소드만 쓰는 클래스라 객체를 만들 이유가 없음)
	private JDBCTemplate() {}

	// DB 연결 객체(Connection)를 돌려주는 메소드
	public static Connection getConnection() {
		// 아직 한 번도 연결 안 했을 때(null)만 새로 연결 → 한 번 만든 Connection 을 계속 재사용 (싱글톤)
		if(conn == null) {
			try {
				// 1) 오라클 JDBC 드라이버를 메모리에 올림 (WEB-INF/lib 에 ojdbc.jar 가 있어야 함)
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2) DB 접속 : 접속주소(내 컴퓨터 1521 포트의 xe DB), 계정명, 비밀번호
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			} catch (ClassNotFoundException e) {	// ojdbc.jar 를 못 찾았을 때
				e.printStackTrace();
			} catch (SQLException e) {				// 주소/계정/비밀번호가 틀렸거나 DB가 꺼져 있을 때
				e.printStackTrace();
			}
		} return conn;
	}

	// 커밋 : INSERT / UPDATE / DELETE 한 결과를 DB에 "확정"
	public static void commit(Connection conn) {
		try {
			// 참고) setAutoCommit(false) 는 "자동 커밋 끄기" 설정이라 보통 getConnection() 에서 연결 직후 한 번만 해줌
			//       여기 있으면 conn 이 null 일 때 아래 null 체크보다 먼저 실행돼서 NullPointerException 이 날 수 있음
			//       (학원 원본 코드라 그대로 둠 / 이번 로그인은 SELECT 만 해서 커밋을 안 쓰므로 영향 없음)
			conn.setAutoCommit(false);
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ▼▼▼▼▼ [수정 8] 시작 : 새로 작성 (원본 스크린샷에서 36번 줄 이후가 잘려서 안 보이는 부분) ▼▼▼▼▼
	// 보통 수업에서 쓰는 형태로 작성함 → 학원 코드에 이미 똑같은 메소드가 있으면 학원 코드를 그대로 쓰면 됨

	// 롤백 : 작업하다 에러가 났을 때 커밋 전 상태로 되돌리기
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 자원 반납(close) : 다 쓴 JDBC 객체는 닫아줘야 DB 쪽 자원이 계속 쌓이지 않음
	// 이름은 똑같이 close 인데 매개변수 타입만 다르게 3개 → "메소드 오버로딩"

	// 주의) getConnection() 은 conn == null 일 때만 새로 연결함
	//      → 여기서 Connection 을 닫아버리면 conn 은 null 이 아니라 "닫힌 상태"로 남아서
	//        다음 요청 때 닫힌 Connection 을 받게 됨 (Closed Connection 에러)
	//      → 그래서 이번 로그인 기능(EmployeeService)에서는 Connection 은 닫지 않음
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// PreparedStatement 는 Statement 를 상속받은 자식이라 이 메소드로 같이 닫을 수 있음 (다형성)
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ▲▲▲▲▲ [수정 8] 끝 ▲▲▲▲▲
}
