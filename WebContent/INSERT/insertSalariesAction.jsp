<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<!-- ### insertSalariesForm에서 받아온 값들을 메소드에 저장시켜 추가하는 액션 #################### -->

<%
	// form에서 받아온 4개의 값을 저장할 변수를 만들고 변수에 값을 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String salary = request.getParameter("salary");
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	// 값을 제대로 받아왔는지 확인
	String[] ckT = {"salary","fromDate","toDate"};
	String[] ckC = {salary,fromDate,toDate};
	for(int i=0; i<3; i++){
		System.out.println("insertSalariesAction "+ckT[i]+" : "+ckC[i]);
	}	System.out.println("insertSalariesAction empNo : "+empNo);
	
	// 받아온 값들을 Salaries 메소드에 저장하기 위해 메소드 호출
	Salaries salaries = new Salaries();
	// 호출한 salaries 메소드에 값 저장
	salaries.setEmpNo(empNo);
	salaries.setSalary(salary);
	salaries.setFromDate(fromDate);
	salaries.setToDate(toDate);
	// salaries 저장되었는지 하나만 확인
	System.out.println(salaries.getEmpNo());
	
	// salaries메소드에 저장한 값들을 EmployeesDao 메소드에 있는 insertSalaries메소드에 저장하기위한 메소드 호출
	SalariesDao salariesDao = new SalariesDao();
	// salaries.insertSalaries 메소드를 실행
	salariesDao.insertSalaries(salaries);
	
	// 액션이 실행 된 후 selectSalariesOne 페이지를 다시 재요청 시킨다.
	response.sendRedirect("./selectSalariesOne.jsp");
%>