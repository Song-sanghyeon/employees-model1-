package model;

// employees 테이블의 한행(튜플)을 저장할 수
public class Employees {
	// 생성자 메소드
	public Employees() {
		this.empNo = 0;
	}
	// 속성 값 저장할 변수 만들기
	private int empNo;
	private String birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private String hireDate;
	
	// ### private 타입의 변수를 다른 클래스에서 호출 하고, 값을 저장 할 수 있게 하기위한 get set 셋팅 ##############
	
	// int 타입의 empNo를 리턴하는 getDeptNo 메소드
	public int getEmpNo() {
		return empNo;
	}
	// 리턴타입은 없고, int타입의 empNo변수를 매개변수로 가지는 setEmpNo 메소드
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}
