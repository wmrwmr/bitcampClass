package orders;

public class FoodOrders extends Orders {

	private String fname;
	private int fprice;

	public FoodOrders() {}

	public FoodOrders(int oid, int tid, int fid, int ordertime, String fname, int fprice) {
		super(oid, tid, fid, ordertime);
		this.fname = fname;
		this.fprice = fprice;
	}

	public FoodOrders(int tid, String fname, int fprice) {
		this.fname = fname;
		this.fprice = fprice;
	}
	
	@Override
	public String toString() {
		return fname;
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


	
	
	private static FoodOrders dao = new FoodOrders();
	static public FoodOrders getInstance() {
		
		return dao;
	}

}
