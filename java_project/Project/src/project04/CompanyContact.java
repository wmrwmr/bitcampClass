package project04;


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
