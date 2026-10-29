// ※ 이 파일은 코드 수정 없음 (학원 원본 그대로 + 설명 주석만 추가)
package employee.model.vo;

/*
 * VO (Value Object) : 데이터를 "담아서 옮기는" 용도의 클래스
 *  - DB 테이블 한 행(row) = Employee 객체 하나
 *  - 필드는 private 으로 숨기고, getter/setter 로만 꺼내고 넣음 (캡슐화)
 *  - Servlet → Service → DAO 로 사원번호/비밀번호를 넘길 때, 값 2개를 따로 넘기지 않고 이 객체 하나에 담아서 넘김
 */
public class Employee {
	private String empNo;	// 사원번호
	private String pwd;		// 비밀번호

	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;	// this.empNo = 필드 / empNo = 매개변수
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	// 객체를 System.out.println() 으로 찍었을 때 보기 좋게 출력되도록 재정의(오버라이딩)
	// (이클립스 Source > Generate toString() 으로 자동 생성한 코드)
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", pwd=" + pwd + ", getEmpNo()=" + getEmpNo() + ", getPwd()=" + getPwd()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
