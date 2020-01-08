package model;
import java.sql.*;
import java.util.*;

public class TitlesDao {
	// 생성자 메소드
	public TitlesDao() {
	}
	// delete titles
	public void deleteTitles(int empNo) throws Exception {
		// 받아온 매개변수인 empNo값 제대로 받아왔는지 확인
		System.out.println("deleteTitles param empNo : "+empNo);
		// db 연결
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// employees 테이블의 emp_no와 titles 테이블의 emp_no가 일치한다면 해당 행 데이터 삭제
		String sql = "DELETE FROM titles WHERE emp_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, empNo);
		stmt.executeQuery();
	}
	
	// titles 테이블 list 페이징 작업 카운트 메소드
	public int selectTitlesTotalRow() throws Exception {
		int totalRow = 0;
		// totalRow의 값은 titles테이블의 전체 행의 수이기때문에 쿼리문만 돌려서 값을 저장하면된다.
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "SELECT COUNT(*) AS cnt FROM titles";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			totalRow = rs.getInt("cnt");
		}
		System.out.println("selectTitlesTotalRow totalRow : "+totalRow);
		return totalRow;
	}
	
	// titles 테이블의 list 메소드
	public ArrayList<Titles> selectTitlesList(int currentPage, int rowPerPage) throws Exception {
		// currentPage와 rowPerPage의 값이 제대로 들어왔는지 확인
		System.out.println("selectTitlesList currentPage : "+ currentPage);
		System.out.println("selectTitlesList rowPerPage : "+ rowPerPage);
		// beginRow의 값을 구하고 변수 만들기
		int beginRow = (currentPage-1)*rowPerPage;
		// ArrayList 호출
		ArrayList<Titles> list = new ArrayList<Titles>();
		// DB연결 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수 만들고 저장
		String sql = "SELECT emp_no, title, from_date, to_date FROM titles LIMIT ?,?";
		// 쿼리문 적용
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정, 변동값 셋팅
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		// 쿼리 결과물 저장
		ResultSet rs = stmt.executeQuery();
		// 쿼리 실행
		while(rs.next()) {
			// 메소드 호출
			Titles titles = new Titles();
			titles.setEmpNo(rs.getInt("emp_no"));
			titles.setTitle(rs.getString("title"));
			titles.setFromDate(rs.getString("from_date"));
			titles.setToDate(rs.getString("to_date"));
			list.add(titles);
		}
		return list;
	}
	
	
	// insertTitles 메소드
	public int insertTitles(Titles titles) throws Exception {
		// 입력받은 값을 저장하기 위한 확인
		System.out.println("insertTitles emp_no : "+titles.getEmpNo());
		System.out.println("insertTitles title : "+titles.getTitle());
		System.out.println("insertTitles from_date : "+titles.getFromDate());
		System.out.println("insertTitles to_date : "+titles.getToDate());
		
		// DB 연결 정보를 위한 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보를 저장할 변수를 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 적용하기 위해 쿼리문을 저장할 변수를 만들고 변수에 쿼리문 저장
		String sql = "INSERT INTO titles(emp_no, title, from_date, to_date) VALUES(?,?,?,?)";
		// 만든 변수를 쿼리에 적용
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정, 변동값 셋팅
		stmt.setInt(1, titles.getEmpNo());
		stmt.setString(2, titles.getTitle());
		stmt.setString(3, titles.getFromDate());
		stmt.setString(4, titles.getToDate());
		// 셋팅값 확인
		System.out.println("setEmpNo : "+titles.getEmpNo());
		System.out.println("setTitle : "+titles.getTitle());
		System.out.println("setFromDate : "+titles.getFromDate());
		System.out.println("setTodate : "+titles.getToDate());
		// 쿼리 실행
		
		int resultRowCnt = stmt.executeUpdate();
		// 실행 결과 확인
		System.out.println("resultRowCnt : "+resultRowCnt);
		return resultRowCnt;
	}
	
	
	
	// 리턴값 Title 매개변수 int
	public Titles selectTitlesOne(int empNo) throws Exception {
	// db에 연결 DBHelper 메소드와 연결
	DBHelper dbhelper = new DBHelper();
	// 연결 정보 값 저장
	Connection conn = dbhelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
	// 쿼리문 작성할 변수 만들고 쿼리문 저장
	// salaries테이블에 있는 데이터는 사원번호,직책,일시작한날짜,퇴사한날짜 이 네가지의 데이터만 봐서는 부족한 데이터를
	// 추가시키기 위해 외래키인 emp_no를 이용해 employees테이블을 연결 해서
	// 원하는 no를 가지는 사원의 이름을 함께 출력하는 쿼리문
	String sql = "SELECT t.emp_no, e.first_name, t.title, t.from_date, t.to_date FROM titles t INNER JOIN employees e ON t.emp_no = e.emp_no WHERE t.emp_no =?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	// 쿼리문 수정 ) 세팅값 설정
	stmt.setInt(1, empNo);
	// 쿼리 실행 결과물을 저장할 변수를 만들고 실행 결과물 저장
	ResultSet rs = stmt.executeQuery();
	// 값을 저장하기 위해 메소드를 호출 하고 초기화
	Titles titles = null;
	// 한 행만 출력하기 위해 while문이 아닌 if문으로 쿼리 실행
	if(rs.next()) {
		// 값을 저장하기 위해 메소드 호출
		titles = new Titles();
		// Employees 클래스의 데이터를 매개변수로 가지는 setEmployees 메소드 호출
		titles.setEmployees(new Employees());
		// Employees 클래스의 존재하는 쿼리문을 매개변수로 가지는 setFristName 메소드를 getEmployees에서 메소드 호출
		titles.getEmployees().setFirstName(rs.getString("first_name"));
		titles.setEmpNo(rs.getInt("emp_no"));
		titles.setTitle(rs.getString("title"));
		titles.setFromDate(rs.getString("from_date"));
		titles.setToDate(rs.getString("to_date"));
		}
		// 연결 정보 초기화
		conn.close();
		return titles;
	}
}