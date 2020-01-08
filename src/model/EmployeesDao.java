package model;
import java.sql.*;
import java.util.*;
// employees 테이블과 관련된 기능을 묶은 클래스
public class EmployeesDao {
	// 생성자 메소드
	public EmployeesDao() {
	}
	public ArrayList<Employees> selectEmployeesSearchGenderFirstName(int currentPage, int rowPerPage, String word) throws Exception {
		System.out.println("selectEmployeesList param currentPage : "+currentPage);
		System.out.println("selectEmployeesList param rowPerPage : "+rowPerPage);
		System.out.println("selectEmployeesList param word : "+word);
		int beginRow = (currentPage-1)*rowPerPage;
		ArrayList<Employees> list = new ArrayList<Employees>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE gender=? AND first_name LIKE ? LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+word+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		return list;
	}
	
	
	
	
	public ArrayList<Employees> selectEmployeesSearchAllLastName(int currentPage, int rowPerPage, String word) throws Exception {
		System.out.println("selectEmployeesList param currentPage : "+currentPage);
		System.out.println("selectEmployeesList param rowPerPage : "+rowPerPage);
		System.out.println("selectEmployeesList param word : "+word);
		int beginRow = (currentPage-1)*rowPerPage;
		ArrayList<Employees> list = new ArrayList<Employees>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE last_name LIKE ? LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+word+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		return list;
	}
	
	
	public ArrayList<Employees> selectEmployeesSearchAllFirstName(int currentPage, int rowPerPage, String word) throws Exception {
		System.out.println("selectEmployeesList param currentPage : "+currentPage);
		System.out.println("selectEmployeesList param rowPerPage : "+rowPerPage);
		System.out.println("selectEmployeesList param word : "+word);
		int beginRow = (currentPage-1)*rowPerPage;
		ArrayList<Employees> list = new ArrayList<Employees>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE first_name LIKE ? LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+word+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		return list;
	}
	
	
	public ArrayList<Employees> selectEmployeesSearchAllWord(int currentPage, int rowPerPage, String word) throws Exception {
		System.out.println("selectEmployeesList param currentPage : "+currentPage);
		System.out.println("selectEmployeesList param rowPerPage : "+rowPerPage);
		System.out.println("selectEmployeesList param currentPage : "+word);
		int beginRow = (currentPage-1)*rowPerPage;
		ArrayList<Employees> list = new ArrayList<Employees>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE first_name OR last_name LIKE ? LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+word+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		return list;
	}
	
	public ArrayList<Employees> selectEmployeesSearchGender(int currentPage, int rowPerPage, String gender) throws Exception {
		int beginRow = (currentPage-1)*rowPerPage;
		ArrayList<Employees> list = new ArrayList<Employees>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE gender=? LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, gender);
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		return list;
	}

	
	// update 메소드
	public void updateEmployees(Employees employees) throws Exception {
		// updateForm에서 받아온 값 확인
		System.out.println("updateEmployees param emp_no : "+employees.getEmpNo());
		System.out.println("updateEmployees param birth_date : "+employees.getBirthDate());
		System.out.println("updateEmployees param first_name : "+employees.getFirstName());
		System.out.println("updateEmployees param last_name : "+employees.getLastName());
		System.out.println("updateEmployees param gender : "+employees.getGender());
		System.out.println("updateEmployees param hire_date : "+employees.getHireDate());
		// 연결 정보 메소드 실행하고 연결정보 값 저장하고 작성할 쿼리문 만들고 쿼리문 저장해서 쿼리 연결 쿼리 실행
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		String sql = "UPDATE employees SET birth_date=?, first_name=?, last_name=?, gender=?, hire_date=? WHERE emp_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, employees.getBirthDate());
		stmt.setString(2, employees.getFirstName());
		stmt.setString(3, employees.getLastName());
		stmt.setString(4, employees.getGender());
		stmt.setString(5, employees.getHireDate());
		stmt.setInt(6, employees.getEmpNo());
		
		stmt.executeUpdate();
		conn.close();
	}
	
	
	
	
	// delete 메소드
	public void deleteEmployees(int empNo) throws Exception {
		// EmpNo의 값 확인
		System.out.println("deleteEmployees param : "+empNo);
		// DB 연결 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보 저장할 변수 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들고 변수에 작성할 쿼리문 저장
		String sql = "DELETE FROM employees WHERE emp_no=?";
		// 쿼리 적용
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리 수정 및 변동값 셋팅
		stmt.setInt(1, empNo);
		// 쿼리 실행
		stmt.executeQuery();
		// 실행 뒤 재요청 시키기
	}
	//list를 출력하기 위해 ArrayList에 테이블 데이터 값을 저장하기 위한 메소드
	// 리턴타입은 Employees 클래스의 값을 가지는 ArrayList이고 매개변수로 현재페이지와 한페이지에 나오는 행의 수를 가진다.
	public ArrayList<Employees> selectEmployeesList(int currentPage, int rowPerPage) throws Exception {
		// 매개변수로 가지고온 currentPage와 rowPerPage의 값을 확인
		System.out.println("selectEmployeesList param currentPage : "+currentPage);
		System.out.println("selectEmployeesList param rowPerPage : "+rowPerPage);
		// 페이징을 위해 페이지에 시작하는 값이 될 변수를 만들고 변수 초기화
		int beginRow = (currentPage-1)*rowPerPage;
			
		// ArrayList 호출
		ArrayList<Employees> list = new ArrayList<Employees>();
		// db 연결 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// db 연결정보를 저장할 변수 만들고 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들고 변수에 쿼리문 저장
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?,?";
		// 작성한 쿼리문을 db에 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리를 수정, 변동값 셋팅
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		// 쿼리 결과물을 저장할 변수를 만들고 저장
		ResultSet rs = stmt.executeQuery();
		// 쿼리 실행 리스트에 저장
		while(rs.next()) {
			// 메소드 실행
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		return list;
	}
		
	// employees 테이블의 데이터 행의 수를 세기위한 메소드
	public int selectEmployeesTotalRow() throws Exception {
		// 행의 수를 세어 값을 저장할 변수를 만들고 변수 초기화
		int totalRow = 0;
		// db 연결 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보 값 저장할 변수 만들고 값 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들고 저장
		String sql = "SELECT COUNT(*) AS cnt FROM employees";
		// 뭐리 적용
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리 저장
		ResultSet rs = stmt.executeQuery();
		// 쿼리 실행
		if(rs.next()) {
			totalRow = rs.getInt("cnt");
		}
		return totalRow;
	}
	
	
	// insertEmployees 메소드 만들기
	public int insertEmployees(Employees employees) throws Exception {
		// 받아온 값을 확인
		System.out.println("insertEmployees param emp_no : "+employees.getEmpNo());
		System.out.println("insertEmployees param birth_date : "+employees.getBirthDate());
		System.out.println("insertEmployees param first_name : "+employees.getFirstName());
		System.out.println("insertEmployees param last_name : "+employees.getLastName());
		System.out.println("insertEmployees param gender : "+employees.getGender());
		System.out.println("insertEmployees param hire_date : "+employees.getHireDate());
		
		// db연결을 위한 연결 정보가 저장되어있는 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보를 저장할 변수를 만들고 데이터 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 쿼리문을 저장할 변수를 만들고 작성할 쿼리문 저장
		String sql = "INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES(?,?,?,?,?,?)";
		// 쿼리문을 실행할 변수를 만들고 sql을 매개변수로 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정, 변동값 설정
		stmt.setInt(1, employees.getEmpNo());
		stmt.setString(2, employees.getBirthDate());
		stmt.setString(3, employees.getFirstName());
		stmt.setString(4, employees.getLastName());
		stmt.setString(5, employees.getGender());
		stmt.setString(6, employees.getHireDate());
		
		// 쿼리 실행
		int resultRowCnt = stmt.executeUpdate();
		// 쿼리 실행 확인 : 값이 1이면 실행 성공
		System.out.println("resultRowCnt : "+resultRowCnt);
		
		// resultRowCnt의 값을 리턴
		return resultRowCnt;
	}
	
	
	
	// 리턴값 : Employees 매개변수 : int
	public Employees selectEmployeesOne(int empNo) throws Exception {
		// 값이 제대로 받아와졌는지 확인
		System.out.println("selectEmployeesOne param empNo : "+empNo);
		// 기능 첫번째 : connection 가져오는 기능
		DBHelper dbhelper = new DBHelper();
		// DBHelper 메소드에 getConnection의 매개변수 driver,dbid,dbpw의 값을 저장
		Connection conn = dbhelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");

		// 기능 두번째 : select쿼리 실행 후 ResultSet 가져오는 기능
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 변동값 세팅
		stmt.setInt(1, empNo);
		ResultSet rs = stmt.executeQuery();
		// 값을 저장하기 위한 메소드 호출과 초기화
		Employees employees = null;
		if(rs.next()) {
			// 값을 저장하기 위한 메소드 호출
			employees = new Employees();
			// employees클래스 속 쿼리문을 매개변수로 가지는 setEmpNo메소드 호출
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
		}
		// 연결 정보 초기화
		conn.close();
		return employees;
	}
}
