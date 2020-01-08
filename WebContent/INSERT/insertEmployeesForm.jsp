<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertEmployeesForm</title>
</head>
<body>
	<form method="post" action="./insertEmployeesAction.jsp">
		<table>
			<thead>
				<tr>
					<th>사원 추가</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>emp_no</td>
					<td><input type="text" name="empNo" value="1"></td>
				</tr>
				<tr>
					<td>birth_date</td>
					<td><input type="text" name="birthDate" value="9999-01-01"></td>
				</tr>
				<tr>
					<td>first_name</td>
					<td><input type="text" name="firstName" value="first"></td>
				</tr>
				<tr>
					<td>last_name</td>
					<td><input type="text" name="lastName" value="second"></td>
				</tr>
				<tr>
					<td>gender</td>
					<td><input type="text" name="gender" value="M"></td>
				</tr>
				<tr>
					<td>hire_date</td>
					<td><input type="text" name="hireDate" value="9999-01-01"></td>
				</tr>
				<tr>
					<td><button type="submit">추가</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>