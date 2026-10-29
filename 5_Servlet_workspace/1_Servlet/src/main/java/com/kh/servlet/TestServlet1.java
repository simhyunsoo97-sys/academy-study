package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		String gender = request.getParameter("gender"); 
		String age = request.getParameter("age"); 
		String city = request.getParameter("city"); 
		String height = request.getParameter("height"); 
		//String food = request.getParameter("food"); 
		String[] food = request.getParameterValues("food");
		System.out.println(name  +  gender  +  age  +  city  +  height  +  Arrays.toString(food));
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("h2{background-color: hotpink;}");
		out.print("span{font-weight: bold;}");
		out.print("#name{background-color: orange;}");
		out.print("#gender{background-color: gold;}");
		out.print("#age{background-color: greenyellow;}");
		out.print("#city{background-color: skyblue;}");
		out.print("#height{background-color: plum;}");
		out.print("#food{background-color: black; color: white;}");	
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>개인 취향 테스트 결과</h2>");
		out.print("<span id='name'>" + name + "</span>님은 <span id='age'>" + age + "</span>이시며, ");
		out.print("<span id='city'>" + city + "</span>에 사는 키 <span id='height'>" + height + "</span>cm인, ");
		out.println("<span id='gender'>" + gender + "</span>입니다.");
		out.println("whgdkgksms dmatlrdms <span id='food'>");
		if(food != null) {
			for
			(int i = 0; i < food.length; i++) {
				if(i == 0) {
					out.printf("%s", food[i]);
				} else {
					out.printf(", %s", food[i]);
				}
			}
		} else {
			out.print("(없음)");
		}
		out.println("</span>입니다.");
		out.print("</body>");
		out.print("</html>");
	}
}
