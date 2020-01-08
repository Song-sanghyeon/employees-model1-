<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<!-- ### insertEmployeesForm에서 받아온 값들을 메소드에 저장시켜 추가하는 액션 #################### -->

<%
	// form에서 받아온 6개의 값을 저장할 변수를 만들고 변수에 값을 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String birthDate = request.getParameter("birthDate");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String gender = request.getParameter("gender");
	String hireDate = request.getParameter("hireDate");
	// 값을 제대로 받아왔는지 확인
	String[] ckT = {"birthDate","firstName","lastName","gender","hireDate"};
	String[] ckC = {birthDate,firstName,lastName,gender,hireDate};
	for(int i=0; i<5; i++){
		System.out.println("insertEmployeesAction "+ckT[i]+" : "+ckC[i]);
	}	System.out.println("insertEmploteesAction empNo : "+empNo);
	
	// 받아온 값들을 Employees 메소드에 저장하기 위해 메소드 호출
	Employees employees = new Employees();
	// 호출한 employees 메소드에 값 저장
	employees.setEmpNo(empNo);
	employees.setBirthDate(birthDate);
	employees.setFirstName(firstName);
	employees.setLastName(lastName);
	employees.setGender(gender);
	employees.setHireDate(hireDate);
	// employees메소드에 저장되었는지 확인
	System.out.println(employees.getEmpNo());
	
	// employees메소드에 저장한 값들을 EmployeesDao 메소드에 있는 insertEmployees메소드에 저장하기위한 메소드 호출
	EmployeesDao employeesDao = new EmployeesDao();
	// employees.insertEmployees 메소드를 실행
	employeesDao.insertEmployees(employees);
	
	// 액션이 실행 된 후 selectEmployeesOne 페이지를 다시 재요청 시킨다.
	response.sendRedirect("../SELECT/selectEmployeesList.jsp");
%>