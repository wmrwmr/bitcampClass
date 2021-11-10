package tables;

public class Tables {
	
	private int tid;

	public Tables(int tid) {
		super();
		this.tid = tid;
	}
	
	public Tables() {}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "테이블 [" + tid + "]";
	}
	
	

	
	
}
