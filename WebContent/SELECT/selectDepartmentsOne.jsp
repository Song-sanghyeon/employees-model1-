<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDepartmentsOne</title>
</head>
<body>
<%
	// dept_no 값 만들기
	String deptNo = "d001";

	// 메소드 호출
	DepartmentsDao departmentsDao = new DepartmentsDao();

	// deptNo 값 저장
	Departments departments = departmentsDao.selectDepartmentsOne(deptNo);
	
	// 테이블 만들기
%>
	<table border=1>
		<tr>
			<td>dept_no</td>
			<td><%=departments.getDeptNo()%></td>
		</tr>
		<tr>
			<td>dept_name</td>
			<td><%=departments.getDeptName()%></td>
		</tr>
		<tr>
			<td><a href="./insertDepartmentsFrom.jsp">추가</a></td>
		</tr>
	</table>
</body>
</html>