package model;
import java.sql.*;
public class DeptEmpDao {
	// 생성자 메소드
	public DeptEmpDao() {
	}
	// insertDeptEmp 메소드
	public int insertDeptEmp(DeptEmp deptEmp) throws Exception {
		// 받아온 값을 확인
		System.out.println("insertDeptEmp emp_no : "+deptEmp.getEmpNo());
		System.out.println("insertDeptEmp dept_no : "+deptEmp.getDeptNo());
		System.out.println("insertDeptEmp from_date : "+deptEmp.getFromDate());
		System.out.println("insertDeptEmp to_date : "+deptEmp.getToDate());
		
		// DB연결을 위한 DBHelper 메소드 호출
		DBHelper dbHelper = new DBHelper();
		// 연결 정보를 저장할 변수를 만들어 연결 정보 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 작성할 쿼리문을 저장할 변수를 만들어 변수에 작성할 쿼리문 저장
		String sql = "INSERT INTO dept_emp(emp_no, dept_no, from_date, to_date) VALUES(?,?,?,?)";
		// 작성한 쿼리를 쿼리에 연결
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정, 변동값 저장
		stmt.setInt(1, deptEmp.getEmpNo());
		stmt.setString(2, deptEmp.getDeptNo());
		stmt.setString(3, deptEmp.getFromDate());
		stmt.setString(4, deptEmp.getToDate());
		// 쿼리 실행
		int resultRowCnt = stmt.executeUpdate();
		// 실행 결과 확인
		System.out.println("resultRowCnt : "+resultRowCnt);
		return resultRowCnt;
	}
	
	// 리턴값 Dept_Emp 매개변수 int
	public DeptEmp selectDeptEmpOne(int empNo, String deptNo) throws Exception {
		// db 연결 하기위해 DBHelper 메소드 실행
		DBHelper dbHelper = new DBHelper();
		// 연결 정보 값을 저장할 변수를 만들고 저장
		Connection conn = dbHelper.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdgus1!");
		// 쿼리문을 저장할 sql변수를 만들고 변수에 sql저장
		// dept_emp테이블에 있는 데이터는 사원번호,부서번호,들어온날짜,나간날짜이다. 이 네가지의 데이터만 봐서는 부족한 데이터를
		// 추가시키기 위해 외래키인 dept_no와 emp_no를 이용해 departments테이블과 employees테이블을 연결 해서
		// emp_no와 dept_no가 서로 같다면 원하는 no를 가지는 사원의 데이터만 출력하는 쿼리문
		String sql = "SELECT de.from_date, de.to_date, de.dept_no, d.dept_name, de.emp_no, e.first_name FROM dept_emp de INNER JOIN departments d INNER JOIN employees e ON de.dept_no = d.dept_no AND de.emp_no = e.emp_no WHERE de.emp_no=? AND de.dept_no=?";
		// 변수를 쿼리문에 저장
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 수정 변동값 셋팅
		stmt.setInt(1, empNo);
		stmt.setString(2, deptNo);
		// 쿼리 실행 결과물을 저장할 변수를 만들고 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		// 값을 저장하기 위해 메소드를 호출 하고 초기화
		DeptEmp deptEmp = null;
		// 한행만 출력하기 때문에 while문이 아닌 if문을 사용해 쿼리 실행
		if(rs.next()) {
			// 값을 저장하기 위해 메소드 호출
			deptEmp = new DeptEmp();
			// Departments 클래스의 데이터를 매개변수로 가지는 setDepartments 메소드 호출
			deptEmp.setDepartments(new Departments());
			// Departments클래스의 존재하는 쿼리문을 매개변수로 가지는 setDeptName 메소드를 getDepartments에서 메소드 호출
			deptEmp.getDepartments().setDeptName(rs.getString("d.dept_name"));
			deptEmp.setEmployees(new Employees());
			deptEmp.getEmployees().setFirstName(rs.getString("e.first_name"));
			deptEmp.setFromDate(rs.getString("from_date"));
			deptEmp.setToDate(rs.getString("to_date"));
			deptEmp.setEmpNo(rs.getInt("emp_no"));
			deptEmp.setDeptNo(rs.getString("dept_no"));
		}
		// 연결 정보 초기화
		conn.close();
		return deptEmp;
	}
}
