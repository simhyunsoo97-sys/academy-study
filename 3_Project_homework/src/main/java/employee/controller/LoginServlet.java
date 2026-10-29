// ※ 이 파일의 코드 수정 : [수정 1] ~ [수정 3] (총 3곳) / 표시 없는 코드는 학원 원본 그대로
package employee.controller;

import java.io.IOException;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// ▼▼▼▼▼ [수정 1] 시작 : import 추가 (아래 [수정 3] 에서 사용하는 클래스) ▼▼▼▼▼
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;
// ▲▲▲▲▲ [수정 1] 끝 ▲▲▲▲▲

/**
 * Servlet implementation class LoginServlet
 *
 * 역할 : 로그인 "처리"를 담당하는 Controller
 *  - 요청에서 사원번호/비밀번호 꺼내기 → Service 에 넘기기 → 결과 보고 어떤 화면으로 갈지 결정
 */
// login.jsp 의 <form action="${contextPath}/login.me" method="post"> 가 submit 되면 여기로 들어옴
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ▼▼▼▼▼ [수정 2] 시작 : 추가 (원본에 없던 줄) ▼▼▼▼▼
		// POST 로 넘어온 한글이 깨지지 않게 인코딩 설정 (getParameter() 로 값을 꺼내기 "전"에 해야 함)
		request.setCharacterEncoding("UTF-8");
		// ▲▲▲▲▲ [수정 2] 끝 ▲▲▲▲▲

		// 1) 요청에서 값 꺼내기
		//    getParameter("이름") 의 "이름" = login.jsp 에 있는 <input> 태그의 name 속성값
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 2) 꺼낸 값 2개를 VO(Employee) 하나에 담기 → Service 에 한 번에 넘기기 편함
		Employee e = new Employee();
		e.setEmpNo(id);
		e.setPwd(pwd);

		// 3) Service 에게 로그인 처리를 맡김
		//    → 일치하는 사원이 있으면 Employee 객체, 없으면 null 이 돌아옴
		EmployeeService eService = new EmployeeService();
		Employee login = eService.login(e);

		// ▼▼▼▼▼ [수정 3] 시작 : 숙제 빈칸 (원본 : 비어 있던 41~42번 줄) ▼▼▼▼▼
		// 4) 결과에 따라 어떤 화면을 보여줄지 결정
		if(login != null) {
			// ---------- 로그인 성공 ----------
			// 세션(session) : 브라우저마다 하나씩 서버에 생기는 저장공간
			//               브라우저를 닫거나 로그아웃(session.invalidate())하기 전까지 유지됨
			// → 여기에 로그인 정보를 넣어두면 다른 JSP 에서도 ${ loginUser } 로 꺼내서
			//   "로그인 했는지 / 누가 로그인 했는지" 확인할 수 있음 (loginbar.jsp 참고)
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", login);

			// 메인 페이지(index.jsp)로 이동
			// sendRedirect : 브라우저에게 "이 주소로 새로 요청해" 라고 시키는 것 → 주소창 URL 이 바뀜
			// (forward 를 쓰면 주소창에 login.me 가 남아서, 새로고침하면 로그인 요청이 또 날아감)
			response.sendRedirect(request.getContextPath());
		} else {
			// ---------- 로그인 실패 ----------
			// 알림창을 띄우고 이전 페이지(로그인 화면)로 되돌려 보내는 <script> 를 응답으로 직접 써서 보냄
			response.setContentType("text/html; charset=UTF-8");	// 응답 한글 깨짐 방지 (반드시 getWriter() 보다 먼저!)
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('사원번호 또는 비밀번호가 일치하지 않습니다.');");
			out.println("history.back();");	// 브라우저 뒤로가기 = 로그인 화면으로 돌아감
			out.println("</script>");
		}
		// ▲▲▲▲▲ [수정 3] 끝 ▲▲▲▲▲
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// login.jsp 의 form 이 method="post" 라서 실제로는 doPost 가 먼저 호출됨
		// → 그대로 doGet 에게 넘겨서 처리 코드를 doGet 한 곳에만 작성
		doGet(request, response);
	}

}
