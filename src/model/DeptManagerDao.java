package model;
import java.sql.*;
public class DeptManagerDao {
	// 생성자 메소드
	public DeptManagerDao() {
	}
	// insertDeptManager 메소드
	public int insertDeptManager(DeptManager deptManager) throws Exception {
		// 받아온 값을 확인
		System.out.println("insertDeptManager dept_no : "+deptManager.getDeptNo());
		System.out.println("insertDeptManager emp_no : "+deptManager.getEmpNo());
		System.out.println("insertDeptManager from_date : "+deptManager.getFromDate());
		System.out.println("insertDeptManager to_date : "+deptManager.getToDate());
		// DB 연결 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보를 저장할 변수를 만들어 변수에 연결정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들어 데이터 저장
		String sql = "INSERT INTO dept_manager(dept_no, emp_no, from_date, to_date) VALUES(?,?,?,?)";
		// 쿼리문을 쿼리에 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정, 변동값 셋팅
		stmt.setString(1, deptManager.getDeptNo());
		stmt.setInt(2, deptManager.getEmpNo());
		stmt.setString(3, deptManager.getFromDate());
		stmt.setString(4, deptManager.getToDate());
		// 쿼리를 실행
		int resultRowCnt = stmt.executeUpdate();
		// 실행 결과 확인
		System.out.println("resultRowCnt : "+resultRowCnt);
		return resultRowCnt;
	}
	
	
	// 리턴값 Dept_Manager 매개변수 int
	public DeptManager selectDeptManagerOne(int empNo, String deptNo) throws Exception {
		// mariadb에 연결 하기위해 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보 저장할 변수 만들고 연결 정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 쿼리문을 저장할 변수를 만들고 변수에 쿼리문 저장
		// dept_manager테이블에 있는 데이터는 사원번호,부서번호,들어온날짜,나간날짜이다. 이 네가지의 데이터만 봐서는 부족한 데이터를
		// 추가시키기 위해 외래키인 dept_no와 emp_no를 이용해 departments테이블과 employees테이블을 연결 해서
		// emp_no와 dept_no가 서로 같다면 원하는 no를 가지는 사원의 데이터만 출력하는 쿼리문
		String sql = "SELECT de.dept_no, d.dept_name, de.emp_no, e.first_name, de.from_date, de.to_date FROM dept_manager de INNER JOIN departments d INNER JOIN employees e ON de.dept_no = d.dept_no AND de.emp_no = e.emp_no WHERE de.dept_no =? AND de.emp_no =?";
		// 쿼리문을 연결
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 변동값 셋팅
		stmt.setString(1, deptNo);
		stmt.setInt(2, empNo);
		// 쿼리 실행 결과물을 저장할 변수를 만들고 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		// 값을 저장하기 위해 메소드를 호출 하고 초기화
		DeptManager deptManager = null;
		// 한행만 출력하기 때문에 while문이 아닌 if문을 사용해 쿼리 실행
		if(rs.next()) {
			// 값을 저장하기 위해 메소드 호출
			deptManager = new DeptManager();
			// Departments 클래스의 데이터를 매개변수로 가지는 setDepartments 메소드 호출
			deptManager.setDepartments(new Departments());
			// Departments클래스의 존재하는 쿼리문을 매개변수로 가지는 setDeptName 메소드를 getDepartments에서 메소드 호출
			deptManager.getDepartments().setDeptName(rs.getString("dept_name"));
			deptManager.setEmployees(new Employees());
			deptManager.getEmployees().setFirstName(rs.getString("first_name"));
			deptManager.setDeptNo(rs.getString("dept_no"));
			deptManager.setEmpNo(rs.getInt("emp_no"));
			deptManager.setFromDate(rs.getString("from_date"));
			deptManager.setToDate(rs.getString("to_date"));
		}
		// 연결 정보 초기화
		conn.close();
		return deptManager;
	}
}
