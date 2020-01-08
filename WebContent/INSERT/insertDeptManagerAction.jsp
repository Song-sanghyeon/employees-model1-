<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<!-- ### insertDeptManagerForm에서 받아온 값들을 메소드에 저장시켜 추가하는 액션 #################### -->

<%
	// form에서 받아온 4개의 값을 저장할 변수를 만들고 변수에 값을 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String deptNo = request.getParameter("deptNo");
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	// 값을 제대로 받아왔는지 확인
	String[] ckT = {"deptNo","fromDate","toDate"};
	String[] ckC = {deptNo,fromDate,toDate};
	for(int i=0; i<3; i++){
		System.out.println("insertDeptManagerAction "+ckT[i]+" : "+ckC[i]);
	}	System.out.println("insertDeptManagerAction empNo : "+empNo);
	
	// 받아온 값들을 Salaries 메소드에 저장하기 위해 메소드 호출
	DeptManager deptManager = new DeptManager();
	// 호출한 salaries 메소드에 값 저장
	deptManager.setEmpNo(empNo);
	deptManager.setDeptNo(deptNo);
	deptManager.setFromDate(fromDate);
	deptManager.setToDate(toDate);
	// salaries 저장되었는지 하나만 확인
	System.out.println(deptManager.getEmpNo());
	
	// deptManager메소드에 저장한 값들을 EmployeesDao 메소드에 있는 insertDeptManager메소드에 저장하기위한 메소드 호출
	DeptManagerDao deptManagerDao = new DeptManagerDao();
	// salaries.insertSalaries 메소드를 실행
	deptManagerDao.insertDeptManager(deptManager);
	
	// 액션이 실행 된 후 selectSalariesOne 페이지를 다시 재요청 시킨다.
	response.sendRedirect("./selectDeptManagerOne.jsp");
%>