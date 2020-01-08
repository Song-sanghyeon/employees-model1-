package model;

// Dept_Manager 테이블의 모든 컬럼
public class DeptManager {
	// 생성자 메소드
	public DeptManager() {
		this.deptNo = null;
		this.empNo = 0;
		this.fromDate = null;
		this.toDate = null;
	}
	// 테이블을 보는것이아닌 이 코드만 봐서는 변수들을 가지고 무엇을 나타내는 건지 알 수 없다.
	// empNo와 deptNo는 테이블에서 외래키이기 떄문에 알 수 있도록 수정이 필요하다.
	
	// 속성값을 저장하기 위한 변수 만들기
	// Employees 테이블의 데이터를 호출하기 위한 메소드 호출
	private Employees employees;
	private Departments departments;
	private String deptNo;
	private int empNo;
	private String fromDate;
	private String toDate;
	
	// Employees 메소드를 리턴하는 getEmployees 메소드 호출
	public Employees getEmployees() {
		return employees;
	}
	// 리턴값은 없고, Employees클래스에 존재하는 데이터를 매개변수로 가지는 setEmployees 메소드 호출
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
