package project03;

//② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//- 거래처회사이름, 거래품목, 직급 변수 추가
//- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
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

		return super.toString() + "\n" + "회사: " + customerName + "\n" + "품목: " + item + "\n" + "직급: " + customerPosition
				+ "\n";
	}

}
