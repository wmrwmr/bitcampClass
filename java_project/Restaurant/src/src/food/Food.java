package food;

public class Food {
	private int fid;
	private String fname;
	private int fprice;

	public Food(int fid, String fname, int fprice) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fprice = fprice;
	}

	public Food(String fname, int fprice) {
		super();
		this.fname = fname;
		this.fprice = fprice;
	}

	// 기본생성자
	public Food() {
	}

	// getter/setter
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFprice() {
		return fprice;
	}

	public void setFprice(int fprice) {
		this.fprice = fprice;
	}

}
