<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmployeesForm</title>
</head>
<body>
<%
	// list에서 넘겨받은 emp_no를 통해 해당 no의 행 데이터를 가지고와서 수정 가능한 폼
	
	// 받아올 empNo를 저장할 변수를 만들고 변수에 받아오기
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	// 확인
	System.out.println("updateEmployeesForm param empNo : "+empNo);
	
	// 메소드 호출
	EmployeesDao employeesDao = new EmployeesDao();
	Employees employees = employeesDao.selectEmployeesOne(empNo);
	
	
%>
	<form method="post" action="./updateEmployeesAction.jsp">
		<table border=1>
			<tr>
				<td>emp_no</td>
				<td><input type="text" name="empNo" value="<%=employees.getEmpNo()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>birth_date</td>
				<td><input type="text" name="birthDate" value="<%=employees.getBirthDate()%>"></td>
			</tr>
			<tr>
				<td>first_name</td>
				<td><input type="text" name="firstName" value="<%=employees.getFirstName()%>"></td>
			</tr>
			<tr>
				<td>last_name</td>
				<td><input type="text" name="lastName" value="<%=employees.getLastName()%>"></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><input type="text" name="gender" value="<%=employees.getGender()%>"></td>
			</tr>
			<tr>
				<td>hire_date</td>
				<td><input type="text" name="hireDate" value="<%=employees.getHireDate()%>"></td>
			</tr>
		</table>
			<button type="submit">수정</button>
	</form>
</body>
</html>