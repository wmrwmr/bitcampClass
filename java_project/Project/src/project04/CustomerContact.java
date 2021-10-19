package project04;


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
		super.showData();
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
