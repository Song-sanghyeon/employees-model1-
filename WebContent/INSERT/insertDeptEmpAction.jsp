<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<!-- ### insertDeptEmpForm에서 받아온 값들을 메소드에 저장시켜 추가하는 액션 #################### -->

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
		System.out.println("insertDeptEmpAction "+ckT[i]+" : "+ckC[i]);
	}	System.out.println("insertDeptEmpAction empNo : "+empNo);
	
	// 받아온 값들을 DeptEmp 메소드에 저장하기 위해 메소드 호출
	DeptEmp deptEmp = new DeptEmp();
	// 호출한 salaries 메소드에 값 저장
	deptEmp.setEmpNo(empNo);
	deptEmp.setDeptNo(deptNo);
	deptEmp.setFromDate(fromDate);
	deptEmp.setToDate(toDate);
	// salaries 저장되었는지 하나만 확인
	System.out.println(deptEmp.getEmpNo());
	
	// salaries메소드에 저장한 값들을 EmployeesDao 메소드에 있는 insertSalaries메소드에 저장하기위한 메소드 호출
	DeptEmpDao deptEmpDao = new DeptEmpDao();
	// salaries.insertSalaries 메소드를 실행
	deptEmpDao.insertDeptEmp(deptEmp);
	
	// 액션이 실행 된 후 selectSalariesOne 페이지를 다시 재요청 시킨다.
	response.sendRedirect("./selectDeptEmpOne.jsp");
%>