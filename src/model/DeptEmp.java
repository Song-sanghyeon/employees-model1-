package model;
public class DeptEmp {
	// 생성자 메소드
	public DeptEmp() {
		this.empNo = 0;
		this.deptNo = null;
		this.fromDate = null;
		this.toDate = null;
	}
	// 테이블을 보는것이아닌 이 코드만 봐서는 변수들을 가지고 무엇을 나타내는 건지 알 수 없다.
	// empNo와 deptNo는 테이블에서 외래키이기 떄문에 알 수 있도록 수정이 필요하다.
	
	// 속성값을 저장하기 위한 변수 만들기
	// Employees 테이블의 데이터를 호출하기 위한 메소드 호출
	private Employees employees;
	private Departments departments;
	private String fromDate;
	private String toDate;
	private int empNo;
	private String deptNo;
	
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
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	/*
	 * 테이블을 분석하고 테이블에있는 데이터를 가지고 보여주는 것 뿐만아니라 부서번호를 가지고 해당 부서가 어떤 부서인지 (dept_name) / 해당 사원이 어떤 사원인지(first_name)을 같이 출력
	 * SELECT de.from_date, de.to_date, de.dept_no, d.dept_name, de.emp_no, e.first_name
	 * FROM dept_emp de INNER JOIN departments d
	 * INEER JOIN employees e
	 * ON de.dept_no = d.dept_no
	 * AND de.emp_no = e.emp_no
	 * WHERE de.emp_no = ? AND de.dept_no = ?
	 */
}
