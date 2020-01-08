<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDeptEmpOne</title>
</head>
<body>
<%
	// empNo 값 저장할 변수 만들기
	int empNo = 10001;
	String deptNo = "d005";

	// 메소드 실행
	DeptEmpDao deptEmpDao = new DeptEmpDao();
	// empNo값 저장하기
	DeptEmp deptEmp = deptEmpDao.selectDeptEmpOne(empNo,deptNo);
	// 테이블 생성
%>
	<table border=1>
		<tr>
			<td>from_date</td>
			<td><%=deptEmp.getFromDate()%></td>
		</tr>
		<tr>
			<td>to_date</td>
			<td><%=deptEmp.getToDate()%></td>
		</tr>
		<tr>
			<td>dept_no</td>
			<td><%=deptEmp.getDeptNo()%></td>
		</tr>
		<tr>
			<td>dept_name</td>
			<!-- depyEmp클래스에 getDepartments()메소드를 호출하는데 getDepartments메소드는 getDeptName메소드를 호출한다. -->
			<td><%=deptEmp.getDepartments().getDeptName()%></td>
		</tr>
		<tr>
			<td>emp_no</td>
			<td><%=deptEmp.getEmpNo()%></td>
		</tr>
		<tr>
			<td>first_name</td>
			<td><%=deptEmp.getEmployees().getFirstName()%></td>
		</tr>
		<tr>
			<td><a href="./insertDeptEmpForm.jsp">추가</a></td>
		</tr>
	</table>
</body>
</html>