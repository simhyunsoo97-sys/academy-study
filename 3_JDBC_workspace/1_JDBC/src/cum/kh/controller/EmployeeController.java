package cum.kh.controller;

import java.util.ArrayList;

import cum.kh.model.dao.EmployeeDAO;
import cum.kh.model.vo.Employee;
import cum.kh.view.Menu;

public class EmployeeController {
	private EmployeeDAO empDAO = new EmployeeDAO();
	private Menu menu =  new Menu();
	
	public void selectAll() {
		ArrayList <Employee> list = empDAO.selectAll();
		
		if(list.isEmpty()) { // list가 비어있으면
			menu.displayError("조회 결과가 없습니다.");			
		} else {
			menu.selectALL(list);			
		}			
	}

	public void selectEmployee() {
		int empNo = menu.selectEmpNo(); // 사번을 입려받기위한 메소드	
		
		Employee emp = empDAO.selectEmployee(empNo);
		if(emp != null) {
			menu.selectEmployee(emp);
		} else {
			menu.displayError("해당 사번의 검색 결과가 없습니다.");
		}
	}

	public void insertEmployee() {
		Employee e = menu.insertEmployee();		
		
		int result = empDAO.insertEmployee(e);
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 추가되었습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}

	public void updateEmployee() {
		int empNo = menu.selectEmpNo();
		
		Employee emp = menu.updateEmployee();
		emp.setEmpNo(empNo);
		
		int result = empDAO.updateEmployee(emp);
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 수정되였습니다.");
		} else {
			menu.displayError("데이터 수정 과정 중 오류 발생");
		}
	}

	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();
		
		char check = menu.deleteEmployee();
		if(check == 'y') {
			int result = empDAO.deleteEmployee(empNo);
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 삭제되었습니다.");
			} else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
		} else if(check == 'n') {
			menu.displaySuccess("사원 정보 삭제 취소");
		} else {
			menu.displayError("잘못 입력하셨습니다.(y 또는 n 입력)");
		}
	

	}
}