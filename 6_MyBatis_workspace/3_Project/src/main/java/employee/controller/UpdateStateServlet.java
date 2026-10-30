package employee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

import employee.model.service.EmployeeService;

/**
 * Servlet implementation class UpdateStateServlet
 */
@WebServlet("/updateState.me")
public class UpdateStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String empNo = request.getParameter("empNo");
		//System.out.println(empNo);
		//fetch의 JSON.stringify()를 이용해서 데이터를 보내는 방법은 request.getParameter()로 데이터를 받을 수가 없음
		//jackson 라이브러리를 이용해 해결!
		//jackson 라이브러리란? Java객체와 JSON객체를 서로 변환해주는 라이브러리 (Java -> JSON / JSON -> Java)
		//ex. Employee e = new Employee(9999, "0000", "홍길동");
		//		----jackson----> {'empNo':9999, 'pwd':'0000', 'empName':'홍길동'}
		
		ObjectMapper mapper = new ObjectMapper();
		//Employee emp = mapper.readValue(request.getTrader(), Employee.class);
		//System.out.println(emp); // key와 setter명이 맞아야 자동 매핑
		HashMap<String, Object> map = mapper.readValue(request.getReader(), HashMap.class);
		//System.out.println(map);
		
		int id = (Integer)map.get("empNo");
		String col = (String)map.get("column");
		String value = (String)map.get("value");
		int result =new EmployeeService().UpdateStateServlet(id, col, value);
		
		HashMap<String, Object> responseData = new HashMap<>();
		responseData.put("message", result == 1 ? "success" : "faul");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(mapper.writeValueAsString(responseData));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
