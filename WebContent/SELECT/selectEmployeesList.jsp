<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmployeesList</title>
</head>
<body>
<%
	// 한글화
	request.setCharacterEncoding("utf-8");

	// 겸색 폼에서 받아오는 변수 만들고 값 저장받기
	String gender = request.getParameter("gender");
	String[] searchColunm = request.getParameterValues("searchColunm");
	String word = request.getParameter("word");
			
	// 제대로 받아와 졌는지 확인
	System.out.println("selectEmployeesListForm param gender : "+gender);
	System.out.println("selectEmployeesListForm param searchColunm : "+searchColunm);
	if(searchColunm != null) {
		for(String sc : searchColunm) {
			System.out.println("selectEmployeesListForm param searchColunm : "+sc);
		}
	}
	System.out.println("selectEmployeesListForm param word : "+word);
	
	
	// 현재 페이지 currentPage를 출력하고 값이 존재하지않는다면 값을 1을 저장
	// 한 페이지에 출력될 rowPerPage의 값을 10으로 설정
	// 메소드를 호출하고 list내에 저장되어있는 데이터 한행씩을 테이블형식으로 출력
	
	int currentPage = 1;
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	// 한 페이지당 보일 행의 수는 10으로 설정
	int rowPerPage = 10;
%>
	<!-- 테이블의 데이터를 저장받은 list를 메소드 호출해서 데이터 가져오기 -->
<%
	// ArrayList 메소드 호출
	ArrayList<Employees> list = new ArrayList<Employees>();
	// list가 저장되어있는 Dao 메소드 호출
	EmployeesDao employeesDao = new EmployeesDao();
	// 선언한 list 안에 selectEmployeesList 메소드에 저장되어있는 값을 저장받기위해 매개변수 currentpage와 rowPerPage 값 저장

	// 성별이 null값이거나 전체 (all) 일떄
	if(gender == null || gender.equals("all")) {
		if(word == null && searchColunm == null || word.equals("") && searchColunm == null) {
			list = employeesDao.selectEmployeesList(currentPage, rowPerPage);
			System.out.println("gender : null word : null searchColunm : null or gender : all word : 공백 searchColunm : null ");
		
		} else if ((searchColunm == null && word.length() > 1) || (searchColunm.length > 1 && word.length() > 1)) {
			list = employeesDao.selectEmployeesSearchAllWord(currentPage, rowPerPage, word);
			System.out.println("gender : all word : 2자이상 searchColunm : null or gender : all word : 2자 이상 searchColunm : 둘다 선택");
		
		} else if (searchColunm[0].equals("firstName") && word.length() > 1) {
			list = employeesDao.selectEmployeesSearchAllFirstName(currentPage, rowPerPage, word);
			System.out.println("gender : all word : 2자이상 searchColunm : firstName");	
		
		} else if (searchColunm[0].equals("lastName") && word.length() > 1) {
			list = employeesDao.selectEmployeesSearchAllLastName(currentPage, rowPerPage, word);
			System.out.println("gender : all word : 2자이상 searchColunm : lastName");	
		}
		
	// 성별이 선택 되었을때
	} else if(gender.equals("M") || gender.equals("F")) {
		if(searchColunm == null && word.equals("") || searchColunm == null && word == null) {
			list = employeesDao.selectEmployeesSearchGender(currentPage, rowPerPage, gender);
			System.out.println("gender : M or F word : 공백 searchColunm : null");

		} else if (searchColunm[0].equals("firstName") && word.length() > 1) {
			
			System.out.println("word : 2자이상 searchColunm : firstName");
			
		} else if (searchColunm[0].equals("lastName") && word.length() > 1) {
			System.out.println("word : 2자이상 searchColunm : lastName");
	
		} else if (searchColunm.length > 1 && word.length() > 1) {
			System.out.println("word : 2자이상 searchColunm : firstName + lastName");
		}
		
	// 조건 틀렸을때 확인용
	} else {
		System.out.println("x");
	}
	
%>
	<!-- 행의 수인 totalRow를 가지고와서 메소드에 저장되어있는 값 가져오기 -->
<%
	// totalRow의 값을 저장받기위해 변수 만들고 초기화
	int totalRow = 0;
	// 메소드를 이용하여 totalRow의 값을 저장받기
	totalRow = employeesDao.selectEmployeesTotalRow();
	// 제대로 값이 저장되었는지 확인하는 코드
	System.out.println("selectEmployeesTotalRow : "+totalRow);
%>
	<!-- 페이징 작업을 위한 endPAge 설정 -->
<%
	int endPage = 0;
	if((totalRow % rowPerPage) == 0) {
		endPage = totalRow/rowPerPage;
	} else {
		endPage = (totalRow/rowPerPage)+1;
	}
%>
	<h2>사원 목록</h2>
	<!-- ### 검색 폼 시작 ################################################################## -->
	<form method="post" action="./selectEmployeesList.jsp">
		<div>
			gender :
			<select name="gender">
				<option value="all">전체</option>
				<option value="M">남자</option>
				<option value="F">여자</option>
			</select>
		</div>
		<div>
			<input type="checkbox" name="searchColunm" value="firstName">first_name
			<input type="checkbox" name="searchColunm" value="lastName">last_name
		</div>
		<div>
			<input type="text" name="word">
			<button type="submit">검색</button>
		</div>
	</form>
	<!-- ### 검색 폼 끝 ############################################################## -->
	<hr>
	<!-- 리스트 출력 테이블 생성 -->
	<table border=1>
		<tr>
			<td>emp_no</td>
			<td>birth_date</td>
			<td>first_name</td>
			<td>last_name</td>
			<td>gender</td>
			<td>hire_date</td>
		</tr>
<%
	// list에서 한 행의 데이터씩 출력해야하기떄문에 for문 사용
	for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><a href="./selectEmployeesOne.jsp?empNo=<%=list.get(i).getEmpNo()%>"><%=list.get(i).getEmpNo()%></a></td>
			<td><%=list.get(i).getBirthDate()%></td>
			<td><%=list.get(i).getFirstName()%></td>
			<td><%=list.get(i).getLastName()%></td>
			<td><%=list.get(i).getGender()%></td>
			<td><%=list.get(i).getHireDate()%></td>
		</tr>
<%
	}
%>
	</table>
		<a href="../INSERT/insertEmployeesForm.jsp">추가</a>
	<!-- 페이징 작업 시작 -->
<%
	if(currentPage > 1) {
%>
		<a href="./selectEmployeesList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<%
	}

	if(currentPage < endPage) {
%>
		<a href="./selectEmployeesList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>
</body>
</html>