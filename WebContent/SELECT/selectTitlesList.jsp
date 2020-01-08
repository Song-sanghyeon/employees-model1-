<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectTitlesList</title>
</head>
<body>
<%
	// titles 테이블의 리스트를 출력하는 페이지
	
	// 현재 페이지 설정
	int currentPage = 1;
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	// 한페이지 리스트에 몇 행의 데이터가 나오는지 설정
	int rowPerPage = 10;
	
	// selectTitlesList 메소드를 호출 하기 위해 ArrayList 호출
	ArrayList<Titles> list = new ArrayList<Titles>();
	// TitlesDao 메소드 호출하고 매개변수 값 넣어주기
	TitlesDao titlesDao = new TitlesDao();
	// 매개변수 값을 넣어서 실행된 메소드의 리턴값을 list변수에 값 저장하기
	list = titlesDao.selectTitlesList(currentPage, rowPerPage);
	
	// 페이징 작업을 위한 totlaRow메소드 실행
	// 변수 만들고 변수에 메소드 실행 리턴값 저장
	int totalRow = titlesDao.selectTitlesTotalRow();
	// 페이징 작업에 마지막 페이지에 해당하는 변수 만들고 변수 조건문을 통해 변수값 저장
	int endPage = 0;
	// 전체 행의수를 한 페이지에 출력될 수를 나눈 나머지가 0으로 떨어지면 딱 떨어진다는 뜻이기에 
	if((totalRow % rowPerPage) == 0) {
		// 페이지의 수는 나눈 몫이된다는 뜻이고
		endPage = totalRow/rowPerPage;
	} else {
		// 나눈 나머지가 0이아니라면 페이지가 하나 더 존재해야 나머지를 전부 출력할 수 있기때문에 1을 더해준다.
		endPage = (totalRow/rowPerPage)+1;
	}
	// 테이블 보여주기
%>
	<table border=1>
		<tr>
			<td>emp_no</td>
			<td>title</td>
			<td>from_date</td>
			<td>to_date</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
<%
	// list를 출력 해야하기때문에 한 행씩 나오기위해 while문이 아닌 for문을 이용해 반복한다.
	for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getEmpNo()%></td>
			<td><%=list.get(i).getTitle()%></td>
			<td><%=list.get(i).getFromDate()%></td>
			<td><%=list.get(i).getToDate()%></td>
			<td><a href="../DELETE/deleteTitlesAction.jsp?empNo=<%=list.get(i).getEmpNo()%>">삭제</a></td>
			<td><a href="../UPDATE/updateTitlesForm.jsp?empNo=<%=list.get(i).getEmpNo()%>">수정</a></td>
		</tr>
<%
	}
%>
	</table>
	
		<a href="../INSERT/insertTitlesForm.jsp">추가</a>
<%
	// 페이징 작업
	if(currentPage > 1) {
%>
		<a href="./selectTitlesList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<%
	}
	if(currentPage < endPage) {
%>
		<a href="./selectTitlesList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>
</body>
</html>