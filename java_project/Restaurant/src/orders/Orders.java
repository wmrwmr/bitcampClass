package orders;

public class Orders {
	
	private int oid;
	private int tid;
	private int fid;
	
	public Orders(int oid, int tid, int fid) {
		super();
		this.oid = oid;
		this.tid = tid;
		this.fid = fid;
	}
	
	public Orders() {}

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
	
	
	
}
