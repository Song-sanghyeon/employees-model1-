package model;

public class Departments {
	// 생성자 메소드
	public Departments() {
		this.deptNo = null;
		this.deptName = null;
	}
	// 속성 값 저장할 변수 만들기
	private String deptNo;
	private String deptName;
	
	// ### private 타입의 변수를 다른 클래스에서 호출 하고, 값을 저장 할 수 있게 하기위한 get set 셋팅 ##############
	
	// String 타입의 deptNo를 리턴하는 getDeptNo 메소드
	public String getDeptNo() {
		return deptNo;
	}
	// 리턴타입은 없고, String타입의 deptNo변수를 매개변수로 가지는 setDeptNo 메소드
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
