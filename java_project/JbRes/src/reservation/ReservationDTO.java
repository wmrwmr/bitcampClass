package reservation;

public class ReservationDTO {

	private int rid;
	private String rname;
	private String rphonenumber;
	private int rcount;
	private String rdate;
	private int tid;

	public ReservationDTO() {
	}

	public ReservationDTO(int rid, String rdate, String rname, String rphonenumber, int rcount, int tid) {
		this.rid = rid;
		this.rname = rname;
		this.rphonenumber = rphonenumber;
		this.rcount = rcount;
		this.rdate = rdate;
		this.tid = tid;
	}

	public ReservationDTO(String rdate, String rname, String rphonenumber, int rcount, int tid) {

		this.rname = rname;
		this.rdate = rdate;
		this.rphonenumber = rphonenumber;
		this.rcount = rcount;
		this.tid = tid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRphonenumber() {
		return rphonenumber;
	}

	public void setRphonenumber(String rphonenumber) {
		this.rphonenumber = rphonenumber;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "  " + rid + " \t" + rname + "\t" + rphonenumber + "\t" + "  " + rcount + "\t" + rdate + "\t" + "  "
				+ tid;
	}

	public boolean equals(Object o) {
		if (o instanceof ReservationDTO) {
			ReservationDTO r = (ReservationDTO) o;
			if (rid == r.rid) {
				return true;
			}
		}

		return false;
	}

}
