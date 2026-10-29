// ※ 이 파일은 코드 수정 없음 (학원 원본 그대로 + 설명 주석만 추가)
package employee.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginViewServlet
 *
 * 역할 : "로그인 화면(login.jsp)을 보여주기만" 하는 서블릿
 *  - login.jsp 는 WEB-INF 폴더 안에 있음
 *  - WEB-INF 안의 파일은 브라우저 주소창으로 직접 접근이 막혀 있어서
 *    반드시 이렇게 서블릿을 거쳐서(forward) 열어야 함 → 보안 목적
 */
// loginbar.jsp 의 <a href="${contextPath}/loginView.me">로그인</a> 을 누르면 여기로 들어옴
@WebServlet("/loginView.me")
public class LoginViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// <a> 링크 클릭은 GET 방식 요청이라 doGet 이 호출됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward : 서버 안에서 login.jsp 로 요청을 넘겨서 그 화면을 응답으로 보냄 (주소창은 loginView.me 그대로)
		// 참고) 경로 앞에 "/" 를 붙여서 "/WEB-INF/views/employee/login.jsp" 로 쓰는 게 더 안전함
		//       (지금은 서블릿 주소가 /loginView.me 라 "/" 가 없어도 같은 위치로 찾아가서 동작은 함)
		request.getRequestDispatcher("WEB-INF/views/employee/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// POST 로 들어와도 doGet 과 똑같이 처리
		doGet(request, response);
	}

}
