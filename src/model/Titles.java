package model;
public class Titles {
	// 생성자 메소드
	public Titles() {
		this.empNo = 0;
		this.title = null;
		this.fromDate = null;
		this.toDate = null;
	}
	// 테이블을 보는것이아닌 이 코드만 봐서는 변수들을 가지고 무엇을 나타내는 건지 알 수 없다.
	// empNo는 테이블에서 외래키이기 떄문에 알 수 있도록 수정이 필요하다.
			
	// 속성값을 저장하기 위한 변수 만들기
	// Employees 테이블의 데이터를 호출하기 위한 메소드 호출
	private int empNo;
	private Employees employees;
	private String title;
	private String fromDate;
	private String toDate;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	// Employees 메소드를 리턴하는 getEmployees 메소드 호출
	public Employees getEmployees() {
		return employees;
	}
	// 리턴값은 없고, Employees클래스에 존재하는 데이터를 매개변수로 가지는 setEmployees 메소드 호출
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
