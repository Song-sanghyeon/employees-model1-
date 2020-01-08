<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<%
	// update emplpyees Action
	
	// form에서 받아온 값들 저장할 변수 만들고 변수 확인하기
	int empNo = 0;
	empNo = Integer.parseInt(request.getParameter("empNo"));
	String birthDate = request.getParameter("birthDate");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String gender = request.getParameter("gender");
	String hireDate = request.getParameter("hireDate");
	
	String[] ck = {birthDate, firstName, lastName, gender, hireDate};
	for(int i=0; i<ck.length; i++) {
		System.out.println("updateEmployeesAction.jsp param "+ck[i]+" : "+ck[i]);
	}
	
	// 메소드 호출
	EmployeesDao employeesDao = new EmployeesDao();
	Employees employees = new Employees();

	// 값을 employees 메소드에 저장
	employees.setEmpNo(empNo);
	employees.setBirthDate(birthDate);
	employees.setFirstName(firstName);
	employees.setLastName(lastName);
	employees.setGender(gender);
	employees.setHireDate(hireDate);
	
	employeesDao.updateEmployees(employees);
	
	// 액션을 취한 뒤 list로 다시 재요청 시킨다.
	response.sendRedirect("../SELECT/selectEmployeesList.jsp");
%>