<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateDepartmentsForm</title>
</head>
<body>
<%
	// list에서 넘겨받은 dept_no를 통해 해당 no의 행 데이터를 가지고와서 수정 가능한 폼
	
	// 받아올 deptNo를 저장할 변수를 만들고 변수에 받아오기
	String deptNo = request.getParameter("deptNo");
	// 확인
	System.out.println("deptNo");
	
	// 메소드 호출 -> 리스트에서 선택한 deptNo의 값을 매개변수로 하는 selectDepartmentsOne 메소드 실행 리턴값을 departments로 저장
	DepartmentsDao departmentsDao = new DepartmentsDao();
	Departments departments = departmentsDao.selectDepartmentsOne(deptNo);
	
	
%>
	<form method="post" action="./updateDepartmentsAction.jsp">
		<table border=1>
			<tr>
				<td>dept_no</td>
				<td><input type="text" name="deptNo" value="<%=departments.getDeptNo()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>dept_name</td>
				<td><input type="text" name="deptName" value="<%=departments.getDeptName()%>"></td>
			</tr>
		</table>
			<button type="submit">수정</button>
	</form>
</body>
</html>