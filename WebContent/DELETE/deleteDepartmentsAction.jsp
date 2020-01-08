<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<%
	// 1. 요청 분석
	String deptNo = request.getParameter("deptNo");
	if(request.getParameter("deptNo") == null) {
		// 값을 받아오지 못했다면, list페이지로 재요청 시킨다.
		response.sendRedirect("../SELECT/selectDepartmentsList.jsp");
		return; // 잘못된 요청으로 인해 실행됬기때문에 이후 코드 실행 없이 코드 종료
	}
	System.out.println(deptNo);
	
	// 2. delete코드 구현 -> Dao 위임 -> Dao.delete 메소드 호출
	DepartmentsDao departmentsDao = new DepartmentsDao();
	departmentsDao.deleteDepartments(deptNo);
	
	// 3. 코드 종료 후 다시 list 페이지로 재요청 시킨다.
	response.sendRedirect("../SELECT/selectDepartmentsList.jsp");
%>