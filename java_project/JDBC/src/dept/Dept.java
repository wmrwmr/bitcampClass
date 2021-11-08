package dept;

public class Dept {

	private int deptno;
	private String dname;
	private String loc;

	// 생성자 초기화
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	// 기본 생성자: Beans 클래스 생성시 반드시 기본 생성자가 있어야 한다!!!
	public Dept() {}

	
	// VO : 읽기전용, getter 메소드만 존재
	// DTO : 읽고 쓰기 가능, getter/setter
	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return deptno + "\t" + dname + "\t" + loc;
	}
	
	
	

}
