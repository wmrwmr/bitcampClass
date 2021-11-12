package orders;

public class FoodOrders extends Orders {
	
	
	   // 클래스 내부에서 인스턴스를 생성!!!, 이 인스턴스를 직접 접근 안되도록!
	   private static FoodOrders dao = new FoodOrders();

	   // 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!! (싱글톤 패턴)
	   static public FoodOrders getInstance() {
	      return dao;
	   }
	   
	   

	private String fname;
	private int fprice;

	public FoodOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodOrders(int oid, int tid, int fid, int ordertime, String fname, int fprice) {
		super(oid, tid, fid, ordertime);
		this.fname = fname;
		this.fprice = fprice;
		// TODO Auto-generated constructor stub
	}

	public FoodOrders(int tid, String fname, int fprice) {
		this.fname = fname;
		this.fprice = fprice;
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

	@Override
	public String toString() {
		return fname;
	}

}
