<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%
	// form에서 받아온 값을 변수로 만들어서 저장
	String deptNo = request.getParameter("deptNo");
	String deptName = request.getParameter("deptName");
	
	// DepartmentsDao 메소드 호출

	
	// Departments 메소드 호출
	Departments departments = new Departments();
	
	// form에서 받아온 값이 저장되어있는 변수를 departmens 메소드에 저장
	departments.setDeptNo(deptNo);
	departments.setDeptName(deptName);
	// 확인
	System.out.println("setDeptNo : "+deptNo);
	System.out.println("setDeptName : "+deptName);
	
	// DepartmentsDao 메소드 호출
	DepartmentsDao departmentsDao = new DepartmentsDao();
	// DepartmentsDao 메소드 실행
	departmentsDao.insertDepartments(departments);
	
	// action 실행 뒤 selectDepartmentsOne 페이지를 다시 재요청 시킨다.
	response.sendRedirect("../SELECT/selectDepartmentsList.jsp");
%>