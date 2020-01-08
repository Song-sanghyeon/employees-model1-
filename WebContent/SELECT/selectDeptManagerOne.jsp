<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDeptManagerOne</title>
</head>
<body>
<%
	// empNo 값 저장할 변수 만들고 값 저장
	int empNo = 110022;
	String deptNo = "d001";

	// 메소드 호출
	DeptManagerDao deptManagerDao = new DeptManagerDao();
	// 메소드에 empNo값 저장
	DeptManager deptManager = deptManagerDao.selectDeptManagerOne(empNo,deptNo);
	
	// 테이블 생성
%>
	<table border=1>
		<tr>
			<td>dept_no</td>
			<td><%=deptManager.getDeptNo()%></td>
		</tr>
		<tr>
			<td>dept_name</td>
			<td><%=deptManager.getDepartments().getDeptName()%></td>
		</tr>
		<tr>
			<td>emp_no</td>
			<td><%=deptManager.getEmpNo()%></td>
		</tr>
		<tr>
			<td>first_name</td>
			<td><%=deptManager.getEmployees().getFirstName()%></td>
		</tr>
		<tr>
			<td>from_date</td>
			<td><%=deptManager.getFromDate()%></td>
		</tr>
		
		<tr>
			<td>to_date</td>
			<td><%=deptManager.getToDate()%></td>
		</tr>
		<tr>
			<td><a href="./insertDeptManagerForm.jsp">추가</a></td>
		</tr>
	</table>
</body>
</html>