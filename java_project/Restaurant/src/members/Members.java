package members;

public class Members {
	private int mid;
	private String mname;
	private String mphone;
	private int bonus;

	public Members() {
	}

	public Members(int mid, String mname, String mphone, int mcount) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mphone = mphone;
		this.bonus = mcount;
	}

	public Members(String mname, String mphone) {
		super();
		this.mname = mname;
		this.mphone = mphone;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public int getMcount() {
		return bonus;
	}

	public void setMcount(int mcount) {
		this.bonus = mcount;
	}

	@Override
	public String toString() {
		return mid + "\t" + mname + "\t" + mphone + "\t" + bonus;
	}

}
