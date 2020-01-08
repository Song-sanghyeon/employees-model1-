<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<%
	// update Action
	
	// form에서 받아온 값 저장
	String deptNo = request.getParameter("deptNo");
	String deptName = request.getParameter("deptName");
	
	// 값을 받아오지않고 이 페이지가 실행됬을 경우 다시 리스트로 재요청시키는 코드
	
	
	
	// 확인
	System.out.println("updateDepartmentsAction param dept_no : "+deptNo);
	System.out.println("updateDepartmentsAction param dept_name : "+deptName);
	
	// 메소드 호출
	DepartmentsDao departmentsDao = new DepartmentsDao();
	Departments departments = new Departments();
	
	// 받아온 값 departments 메소드에 저장
	departments.setDeptName(deptName);
	departments.setDeptNo(deptNo);
	
	// 메소드의 매개변수값을 넣어주기
	departmentsDao.updateDepartments(departments);
	
	// 액션이 실행 한 뒤 다시 리스트를 재요청 시킨다.
	response.sendRedirect("../SELECT/selectDepartmentsList.jsp");
	
%>