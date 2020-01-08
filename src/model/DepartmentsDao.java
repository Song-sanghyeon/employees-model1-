package model;

import java.sql.*;
import java.util.ArrayList;

public class DepartmentsDao {
	// 생성자 메소드
	public DepartmentsDao() {
	}
	// update
	public void updateDepartments(Departments departments) {
		// 받아왔는지 확인하는 코드
		System.out.println("updateDepartments param dept_no : "+departments.getDeptNo());
		System.out.println("updateDepartments param dept_name : "+departments.getDeptName());
		// 연결 정보 메소드를 호출하고 연결정보를 저장하고 쿼리문 작성할 변수 만들고 쿼리문 저장시키고 변동값 셋팅 쿼리문 수정하고 쿼리 실행
		DBHelper dbHelper = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
			String sql = "UPDATE departments SET dept_name=? WHERE dept_no=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, departments.getDeptName());
			stmt.setString(2, departments.getDeptNo());
			stmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace(); // console
		} finally  { // 예외가 발생하던지 말던지 실행
			try {
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// delete
	public void deleteDepartments(String deptNo) throws Exception {
		// 확인
		System.out.println("deleteDepartments param : "+deptNo);		
		// DB에 연결하기 위해 연결정보가 있는 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결정보를 저장할 변수를 만들고 변수에 데이터 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 쿼리문을 저장할 변수를 만들고 작성할 쿼리를 저장
		String sql = "DELETE FROM departments WHERE dept_no=?";
		// 변수를 매개변수로 받을 stmt생성 후 sql변수 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 변동값 셋팅
		stmt.setString(1, deptNo);
		// 쿼리 실행
		stmt.executeQuery();
	}
	
	
	
	// ArrayList
	public ArrayList<Departments> selectDepartmentsList(int currentPage, int rowPerPage) throws Exception {
		// 넘겨받은 값 확인
		System.out.println("selectDepartmentsList param currentPage : "+currentPage);
		System.out.println("selectDepartmentsList param rowPerPage : "+rowPerPage);
		
		// beginRow 값 구하기
		int beginRow = (currentPage-1)*rowPerPage;
		
		// size가 0 인 ArrayList를 리턴
		ArrayList<Departments> list = new ArrayList<Departments>();
		// db에 연결 하기 위한 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보를 저장할 데이터를 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들고 변수에 쿼리문을 저장
		String sql = "SELECT dept_no, dept_name FROM departments LIMIT ?, ?";
		// 작성한 변수를 쿼리에 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 변동값 셋팅
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		// 쿼리를 실행 결과물을 저장할 변수를 만들고 변수에 실행 결과물 저장
		ResultSet rs = stmt.executeQuery();
		// 쿼리 실행 결과물을 리스트에 저장
		while(rs.next()) {
			// rs를 departments로 한행 씩 departments 메소드에 보내기 위한 코드 
			Departments departments = new Departments();
			departments.setDeptNo(rs.getString("dept_no"));
			departments.setDeptName(rs.getString("dept_name"));
			// list에 값을 저장
			list.add(departments);
		}
		return list;
	}
	
	// totalCount / rowPerPage 계산해서 페이징 작업
	// 페이징을 위한 전체 카운트
	public int selectDepartmentsTotalRow() throws Exception {
		// 전체 카운트를 세기 위한 변수 만들고 초기화
		int totalRow = 0;
		// db에 연결 하기 위한 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보를 저장할 데이터를 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들고 변수에 쿼리문을 저장
		String sql = "SELECT COUNT(*) as cnt FROM departments";
		// 작성한 변수를 쿼리에 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리를 실행 결과물을 저장할 변수를 만들고 변수에 실행 결과물 저장
		ResultSet rs = stmt.executeQuery();
		// 쿼리 실행 결과물을 리스트에 저장
		if(rs.next()) {
			totalRow = rs.getInt("cnt"); // 하나의 값만 받아오면되기때문에 그냥 숫자 1을 입력해도 받아진다.
		}
		return totalRow;		
	}
	
	
	// pretender 
	
	/*
	 * action -> insertDepartments 호출
	 * String deptNo = request.getParameter("deptNo")
	 * String deptName = request.getParameter("deptName")
	 * Departments departments = new Departments()
	 * departments.setDeptNo(deptNo); 
	 * departments.serDeptName(deptName);
	 * insertDepartments(departments)
	 */
	// insert 하는 메소드 생성
	public int insertDepartments(Departments departments) throws Exception {
		// 확인
		System.out.println("insertDepartments param deptNo : "+departments.getDeptNo());
		System.out.println("insertDepartments param deptName : "+departments.getDeptName());
		
		// DB에 연결하기 위해 연결정보가 있는 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결정보를 저장할 변수를 만들고 변수에 데이터 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 쿼리문을 저장할 변수를 만들고 작성할 쿼리를 저장
		String sql = "INSERT INTO departments(dept_no, dept_name) VALUES(?,?)";
		// 변수를 매개변수로 받을 stmt생성 후 sql변수 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 변동값 셋팅
		stmt.setString(1, departments.getDeptNo());
		stmt.setString(2, departments.getDeptName());
		
		int resultRowCnt = stmt.executeUpdate();
		// resultRowCnt의 값이 1이라면 쿼리 실행 성공
		System.out.println("resultRowCnt : "+resultRowCnt);
		
		return resultRowCnt;
	}
	
	
	
	
	// 리턴값 : Departments 매개변수 : String
	public Departments selectDepartmentsOne(String deptNo) throws Exception {
	
		// db 연결을 위해 db연결 정보가 저장되어있는 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// conn 연결정보를 저장할 변수를 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 쿼리문을 저장할 변수를 만들고 변수에 sql문 저장
		String sql = "SELECT dept_no, dept_name FROM departments WHERE dept_no=?";
		// 변수를 쿼리문에 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리 수정
		stmt.setString(1, deptNo);
		// 쿼리 실행 결과물을 저장할 변수를 만들고 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		// departments를 리턴값으로 받아오기위해 메소드를 호출하고 초기화
		Departments departments = null;
		// 한줄만 출력하기때문에 while문이아닌 if문 사용해서 rs 결과물 저장
		if(rs.next()) {
			// 메소드 호출
			departments = new Departments();
			// departments클래스에 속해있는 쿼리문을 적용해 실행 결과물을 매개변수로 가지는 setDaptNo를 호출
			departments.setDeptNo(rs.getString("dept_no"));
			departments.setDeptName(rs.getString("dept_name"));
			}
		
		// 연결 정보 초기화
		conn.close();
		// if문을 통해 실행한 쿼리의 결과를 리턴
		return departments;
	}
	
}
