<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertDepartmentsForm</title>
</head>
<body>
	<form method="post" action="./insertDepartmentsAction.jsp">
		<table>
			<thead>
				<tr>
					<th>부서 추가</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>dept_no</td>
					<td><input type="text" name="deptNo" value="d111"></td>
				</tr>
				<tr>
					<td>dept_name</td>
					<td><input type="text" name="deptName" value="first"></td>
				</tr>
				<tr>
					<td><button type="submit">추가</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>