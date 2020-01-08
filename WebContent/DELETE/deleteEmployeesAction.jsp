<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<%
	// 요청 분석
	int empNo = 0;
	System.out.println("deleteEmployeesAction : "+empNo);
	// 조건문을 이용해서 값을 받아오지못하였을경우에 페이지 재요청
	if(request.getParameter("empNo") != null) {
		empNo = Integer.parseInt(request.getParameter("empNo"));
		System.out.println("deleteEmployeesAction if : "+empNo);
	} else {
		response.sendRedirect("../SELECT/selectEmployeesList.jsp");
		System.out.println("오류");
		return;
	}
	
	// 메소드 호출 뒤 메소드에 값 저장
	EmployeesDao employeesDao = new EmployeesDao();
	employeesDao.deleteEmployees(empNo);
	
	// 실행 뒤 list로 다시 재요청 시키기
	response.sendRedirect("../SELECT/selectEmployeesList.jsp");
%>