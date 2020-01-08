<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertDeptManagerForm</title>
</head>
<body>
	<form method="post" action="insertDeptManagerAction.jsp">
		<table>
			<thead>
				<tr>
					<th>매니져 사원 추가</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>dept_no</td>
					<td><input type="text" name="deptNo" value="d001"></td>
				</tr>
				<tr>
					<td>emp_no</td>
					<td><input type="text" name="empNo" value="10001"></td>
				</tr>
				<tr>
					<td>from_date</td>
					<td><input type="text" name="fromDate" value="9999-01-01"></td>
				</tr>
				<tr>
					<td>to_date</td>
					<td><input type="text" name="toDate" value="9999-01-01"></td>
				</tr>
				<tr>
					<td><button type="submit">추가</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>