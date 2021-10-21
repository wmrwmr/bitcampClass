package project06;


public class CustomerContact extends Contact {

	private String customerName;
	private String item;
	private String customerPosition;

	public CustomerContact(String name, String phoneNumber, String email, String address, String birthDay, String group,
			String customerName, String item, String customerPosition) {
		super(name, phoneNumber, email, address, birthDay, group);
		this.customerName = customerName;
		this.item = item;
		this.customerPosition = customerPosition;
	}

	public CustomerContact() {

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCustomerPosition() {
		return customerPosition;
	}

	public void setCustomerPosition(String customerPosition) {
		this.customerPosition = customerPosition;
	}

	@Override
	public void showData() {
		System.out.println("이름: " + super.getName());
		System.out.println("전화: " + super.getPhoneNumber());
		System.out.println("메일: " + super.getEmail());
		System.out.println("주소: " + super.getAddress());
		System.out.println("생일: " + super.getBirthDay());
		System.out.println("그룹: " + super.getGroup());
		System.out.println("회사: " + this.customerName);
		System.out.println("품목: " + this.item);
		System.out.println("직급: " + this.customerPosition);
	}

	@Override
	public String toString() {

		return super.toString() + "회사: " + customerName + "\n" + "품목: " + item + "\n" + "직급: " + customerPosition
				+ "\n";
	}

}
