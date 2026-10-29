package el.controller;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import person.model.vo.Person;

public class ELServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이름, 성별, 나이, 음료, 물건들, 책, 영화
		String name = request.getParameter("name"); 
		char gender = request.getParameter("gender").charAt(0); 
		int age = Integer.parseInt(request.getParameter("age")); 
		String  beverage= request.getParameter("beverage"); 
		String [] products = request.getParameterValues("product"); 
		String book= request.getParameter("book"); 
		String movie = request.getParameter("movie"); 
		
		Person p = new Person(name, gender, age);
		
		//view에 전달할 데이터 request에담기
		request.setAttribute("person", p);
		request.setAttribute("beverage", beverage);
		request.setAttribute("year", 2026);
		request.setAttribute("products", products);
		
		HttpSession session = request.getSession(); // session영역
		session.setAttribute("book", book);
		ServletContext application = request.getServletContext(); // application영역
		application.setAttribute("movie", movie);
		
		RequestDispatcher view = request.getRequestDispatcher("/el/01_2_elEnd.jsp"); // 경로
		view.forward(request, response); // 보내는역할
		
		
		
	}
}
