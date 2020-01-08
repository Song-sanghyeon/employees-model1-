<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<!-- ### insertTitlesForm에서 받아온 값들을 메소드에 저장시켜 추가하는 액션 #################### -->

<%
	// form에서 받아온 4개의 값을 저장할 변수를 만들고 변수에 값을 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String title = request.getParameter("title");
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	// 값을 제대로 받아왔는지 확인
	String[] ckT = {"title","fromDate","toDate"};
	String[] ckC = {title,fromDate,toDate};
	for(int i=0; i<3; i++){
		System.out.println("insertTitlesAction "+ckT[i]+" : "+ckC[i]);
	}	System.out.println("insertTitlesAction empNo : "+empNo);
	
	// 받아온 값들을 Salaries 메소드에 저장하기 위해 메소드 호출
	Titles titles = new Titles();
	// 호출한 salaries 메소드에 값 저장
	titles.setEmpNo(empNo);
	titles.setTitle(title);
	titles.setFromDate(fromDate);
	titles.setToDate(toDate);
	// salaries 저장되었는지 하나만 확인
	System.out.println(titles.getEmpNo());
	
	// salaries메소드에 저장한 값들을 EmployeesDao 메소드에 있는 insertSalaries메소드에 저장하기위한 메소드 호출
	TitlesDao titlesDao = new TitlesDao();
	// salaries.insertSalaries 메소드를 실행
	titlesDao.insertTitles(titles);
	
	// 액션이 실행 된 후 selectSalariesOne 페이지를 다시 재요청 시킨다.
	response.sendRedirect("../SELECT/selectTitlesList.jsp");
%>