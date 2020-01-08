package model;
import java.sql.*;
import java.util.*;
public class SalariesDao {
	// 생성자 메소드
	public SalariesDao() {
	}
	// salaries 테이블 list 메소드
	public ArrayList<Salaries> selectSalariesList(int currentPage, int rowPerPage) {
		// ArrayList를 통해 salaries 테이블의 데이터를 한행씩 list에 저장 메소드
		// 매개변수 currentPage와 rowPerPage의 변수의 값이 제대로 받았는지 확인
		System.out.println("selectSalariesList param currentPage : "+currentPage);
		System.out.println("selectSalariesList param rowPerPage : "+rowPerPage);
		// 보여줄 리스트에 첫 데이터 행이될 beginRow를 변수로 만들어 값을 러장
		int beginRow = (currentPage-1)*rowPerPage;
		// ArrayList 호출
		ArrayList<Salaries> list = new ArrayList<Salaries>();
		
		
		return list;
	}
	
	
	
	
	// insertSalaries 메소드
	public int insertSalaries(Salaries salaries) throws Exception {
		// 매개변수로 받아 온 값 확인
		System.out.println("insertSalaries param empNo : "+salaries.getEmpNo());
		System.out.println("insertSalaries param salary : "+salaries.getSalary());
		System.out.println("insertSalaries param fromDate : "+salaries.getFromDate());
		System.out.println("insertSalaries param toDate : "+salaries.getToDate());

		// DB연결하기 위해 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// DB연결하기 위해 연결정보를 저장할 변수를 만들고 변수에 정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		// 작성할 쿼리문을 저장할 변수를 만들고 변수에 작성할 쿼리문 저장
		String sql = "INSERT INTO salaries(emp_no, salary, from_date, to_date) VALUES(?,?,?,?)";
		// 변수를 매개변수로 저장할 stmt 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리 수정 , 변동값 셋팅
		stmt.setInt(1, salaries.getEmpNo());
		stmt.setString(2, salaries.getSalary());
		stmt.setString(3, salaries.getFromDate());
		stmt.setString(4, salaries.getToDate());
		
		int resultRowCnt = stmt.executeUpdate();
		// 확인
		System.out.println("resultRowCnt : "+resultRowCnt);
		return resultRowCnt;
	}
	
	
	
	// 리턴값 Salaries 매개변수 int
	public Salaries selectSalariesOne(int empNo) throws Exception {
		// db 연결 하기위한 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// db 연결정보를 저장할 변수 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		// 쿼리문을 저장할 변수를 만들고 쿼리문 저장
		// salaries테이블에 있는 데이터는 사원번호,연봉,일시작한날짜,1년주기되는날짜 이 네가지의 데이터만 봐서는 부족한 데이터를
		// 추가시키기 위해 외래키인 emp_no를 이용해 employees테이블을 연결 해서
		// 원하는 no를 가지는 사원의 이름을 함께 출력하는 쿼리문
		String sql = "SELECT s.emp_no, e.first_name, s.salary, s.from_date, s.to_date FROM salaries s INNER JOIN employees e ON s.emp_no = e.emp_no WHERE s.emp_no=?";
		// 쿼리문 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 및 변동 값 세팅
		stmt.setInt(1, empNo);
		// 쿼리 실행 결과물을 저장할 변수를 만들고 저장
		ResultSet rs = stmt.executeQuery();
		
		// 값을 저장하기 위해 메소드를 호출 하고 초기화
		Salaries salaries = null;
		// 한 행만 출력하기 위해 while문이 아닌 if문으로 쿼리 실행
		if(rs.next()) {
			// 값을 저장하기 위해 메소드 호출
			salaries = new Salaries();
			// Employees 클래스의 데이터를 매개변수로 가지는 setEmployees 메소드 호출
			salaries.setEmployees(new Employees());
			// Employees 클래스의 존재하는 쿼리문을 매개변수로 가지는 setFristName 메소드를 getEmployees에서 메소드 호출
			salaries.getEmployees().setFirstName(rs.getString("first_name"));
			salaries.setEmpNo(rs.getInt("emp_no"));
			salaries.setSalary(rs.getString("salary"));
			salaries.setFromDate(rs.getString("from_date"));
			salaries.setToDate(rs.getString("to_date"));
		}
		// 연결 정보 초기화
		conn.close();
		return salaries;
	}
}
