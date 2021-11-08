package jdbc;
//1. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
//2. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
//3. EMP 테이블에서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을
//작성해보자.
//4. EMP 테이블에서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
//5. 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.

// empno ename job mgr hiredate sal comm deptno
public class Emp {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public Emp(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	public Emp() {}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
	
	
	

}
