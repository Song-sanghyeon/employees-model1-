<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectTitlesOne</title>
</head>
<body>
<%
	int empNo = 10001;

	// title 테이블 데이터가 저장되어있는 titleDao 메소드를 호출하고 empNo값을 저장
	TitlesDao titlesDao = new TitlesDao();
	// empNo값 10001 저장
	Titles titles = titlesDao.selectTitlesOne(empNo);
	
	// 테이블 생성
%>
	<table border=1>
		<tr>
			<td>emp_no</td>
			<td><%=titles.getEmpNo()%></td>
		</tr>
		<tr>
			<td>first_name</td>
			<td><%=titles.getEmployees().getFirstName()%></td>
		</tr>
		<tr>
			<td>title</td>
			<td><%=titles.getTitle()%></td>
		</tr>
		<tr>
			<td>from_date</td>
			<td><%=titles.getFromDate()%></td>
		</tr>
		<tr>
			<td>to_date</td>
			<td><%=titles.getToDate()%></td>
		</tr>
		<tr>
			<td><a href="./insertTitlesForm.jsp">추가</a></td>
		</tr>
	</table>
</body>
</html>