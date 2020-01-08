<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectSalariesOne</title>
</head>
<body>
<%
	// 사원번호 입력
	int empNo = 10001;

	// 메소드 호출
	SalariesDao salariesDao = new SalariesDao();
	// 메소드에 empNo값을 저장
	Salaries salaries = salariesDao.selectSalariesOne(empNo);
	
	// 테이블 생성
%>
	<table border=1>
		<tr>
			<td>emp_no</td>
			<td><%=salaries.getEmpNo()%></td>
		</tr>
		<tr>
			<td>first_name</td>
			<td><%=salaries.getEmployees().getFirstName()%></td>
		</tr>
		<tr>
			<td>salary</td>
			<td><%=salaries.getSalary()%></td>
		</tr>
		<tr>
			<td>from_date</td>
			<td><%=salaries.getFromDate()%></td>
		</tr>
		<tr>
			<td>to_date</td>
			<td><%=salaries.getToDate()%></td>
		</tr>
		<tr>
			<td><a href="./insertSalariesForm.jsp">추가</a></td>
		</tr>
	</table>
</body>
</html>