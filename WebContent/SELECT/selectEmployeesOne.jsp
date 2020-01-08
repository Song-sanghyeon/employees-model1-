<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmployeesOne</title>
</head>
<body>
<%
	// list에서 empNo를 클릭했을때 해당 empNo를 토대로 상세정보가 나오는 페이지
	
	// empNo를 저장받을 변수를 만들고 초기화
	int empNo = 0;
	// 받아온 empNo의 값이 null값이라면 다시 list를 재요청 시키는 조건문을 사용해서 null값이아니라면 값을 만든 변수에 저장시키는 코드
	if(request.getParameter("empNo") != null) {
		empNo = Integer.parseInt(request.getParameter("empNo"));
		// 값이 받아졌는지  확인
		System.out.println("selectEmployeesOne.jsp param empNo : "+empNo);
	} else {
		response.sendRedirect("./selectEmployeesList.jsp");
		return;
	}
	
	// ### 메소드화 시키고 분리 #######################################################################
/*
	// 기능 첫번째 : connection 가져오는 기능
	DBHelper dbhelper = new DBHelper();
	// DBHelper 메소드에 getConnection의 매개변수 driver,dbid,dbpw의 값을 저장
	Connection conn = dbhelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
	
	// 기능 두번째 : select쿼리 실행 후 ResultSet 가져오는 기능
	String sql = "SELECT * FROM employees WHERE emp_no=?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, empNo);
	ResultSet rs = stmt.executeQuery();
*/
	EmployeesDao employeesDao = new EmployeesDao();
	Employees employees = employeesDao.selectEmployeesOne(empNo);
%>
	<table border="1">
		<tr>
			<td>empNo</td>
			<!-- 쿼리문을 *로 전체 컬럼을 적용했을경우 그저 컬럼 순서를 입력해서 출력해도 가능하다. -->
			<td><%=employees.getEmpNo()%></td>
		</tr>
		<tr>
			<td>birthDate</td>
			<td><%=employees.getBirthDate()%></td>
		</tr>
		<tr>
			<td>firstName</td>
			<td><%=employees.getFirstName()%></td>
		</tr>
		<tr>
			<td>lastName</td>
			<td><%=employees.getLastName()%></td>
		</tr>
		<tr>
			<td>gender</td>
			<td><%=employees.getGender()%></td>
		</tr>
		<tr>
			<td>hireDate</td>
			<td><%=employees.getHireDate()%></td>
		</tr>
	</table>
			<a href="../UPDATE/updateEmployeesForm.jsp?empNo=<%=employees.getEmpNo()%>">수정</a>
			<a href="../DELETE/deleteEmployeesAction.jsp?empNo=<%=employees.getEmpNo()%>">삭제</a>
</body>
</html>