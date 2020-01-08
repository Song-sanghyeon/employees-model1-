<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDepartmentsList</title>
</head>
<body>
<%
	/*
		현재 페이지를 받아오고 값이 없다면 값을 1로 처리
		rowPerPage를 10으로 정해서 생성
		Departments 메소드를 호출
		Departments list에 한 행씩 저장되어있는 데이터들을 반복문을 통해 한행씩 출력
	*/


	// 한 페이지에 몇 행의 데이터가 출력이 될지를 값을 저장 할 변수 만들고 값 저장
	int rowPerPage = 10;
	// currentPage
	int currentPage = 1;

	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	
	ArrayList<Departments> list = new ArrayList<Departments>();
	
	// 메소드 호출
	Departments departments = new Departments();
	// 메소드 호출
	DepartmentsDao departmentsDao = new DepartmentsDao();
	list = departmentsDao.selectDepartmentsList(currentPage, rowPerPage);
	
	int totalRow = 0;
	
	totalRow = departmentsDao.selectDepartmentsTotalRow();
	System.out.println("totalRow = "+totalRow);
	// 리스트 메소드 호출
	
	int endPage = 0;
	if((totalRow % rowPerPage) == 0) {
		endPage = totalRow/rowPerPage;
	} else {
		endPage = (totalRow/rowPerPage)+1;
	}
	
	// 테이블 생성
%>
	<table border=1>
		<tr>
			<td>dept_no</td>
			<td>dept_name</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
<%
		for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getDeptNo()%></td>
			<td><%=list.get(i).getDeptName()%></td>
			<td><a href="../DELETE/deleteDepartmentsAction.jsp?deptNo=<%=list.get(i).getDeptNo()%>">삭제</a></td>
			<td><a href="../UPDATE/updateDepartmentsForm.jsp?deptNo=<%=list.get(i).getDeptNo()%>">수정</a></td>
			
		</tr>
<%
		}
%>
	</table>
			<a href="../INSERT/insertDepartmentsForm.jsp">추가</a>
<%
	if(currentPage > 1) {
%>
			<a href="../SELECT/selectDepartmentsList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<%
	}
	if(currentPage < endPage) {
%>
			<a href="../SELECT/selectDepartmentsList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>
</body>
</html>