<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
	
	<!-- delete action -->
<%
	// empNo 값을 받을 변수를 만들고 초기화
	int empNo = 0;
	// 조건문을 이용해서 받아온 empNo의 값이 null이라면 다시 list를 재요청 시키는 코드
	if(request.getParameter("empNo") != null) {
		empNo = Integer.parseInt(request.getParameter("empNo"));
	} else {
		// null 값이라면 다시 list를 재요청 시킨다.
		response.sendRedirect("../SELECT/selectTitlesList.jsp");
		// null 값이라면 조건문 이후 코드가 실행되면 안되기째문에 return을 통해 종료
		return;
	}
	
	// 메소드 연결해서 삭제 메소드 실행
	TitlesDao titlesDao = new TitlesDao();
	// titlesDao 클래스 속 deleteTitles메소드를 실행하는데 empNo 매개변수 값을 저장해준다.
	titlesDao.deleteTitles(empNo);
	
	// 실행이 끝났으니 다시 list를 재요청
	response.sendRedirect("../SELECT/selectTitlesList.jsp");
%>