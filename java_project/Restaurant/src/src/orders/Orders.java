package orders;

public class Orders {
	
	   // 클래스 내부에서 인스턴스를 생성!!!, 이 인스턴스를 직접 접근 안되도록!
	   private static Orders dao = new Orders();

	   // 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!! (싱글톤 패턴)
	   static public Orders getInstance() {
	      return dao;
	   }
	   

	private int oid;
	private int tid;
	private int fid;
	private int ordertime;

	public Orders(int oid, int tid, int fid, int ordertime) {
		super();
		this.oid = oid;
		this.tid = tid;
		this.fid = fid;
		this.ordertime = ordertime;
	}

	public Orders(int tid, int fid) {
		super();
		this.tid = tid;
		this.fid = fid;

	}

	public Orders() {
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(int ordertime) {
		this.ordertime = ordertime;
	}

}
