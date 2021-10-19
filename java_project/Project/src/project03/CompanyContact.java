package project03;

//2. 그룹에 해당하는 정보들을 추가적으로 정의하는 새로운 클래스들을 정의합니다. 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//① CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//- 회사이름, 부서이름, 직급 변수 추가
//- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
public class CompanyContact extends Contact {

	private String companyName;
	private String department;
	private String position;

	public CompanyContact(String name, String phoneNumber, String email, String address, String birthDay, String group,
			String companyName, String department, String position) {
		super(name, phoneNumber, email, address, birthDay, group);
		this.companyName = companyName;
		this.department = department;
		this.position = position;
	}

	public CompanyContact() {

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("회사: " + this.companyName);
		System.out.println("부서: " + this.department);
		System.out.println("직급: " + this.position);
	}

	@Override
	public String toString() {
		return super.toString() + "회사: " + companyName + "\n" + "부서: " + department + "\n" + "직급: " + position
				+ "\n";

	}

}
