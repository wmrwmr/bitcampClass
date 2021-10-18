package chapter07;

public class UnivFriend extends Friend {
	
	String major; // 전공

	public UnivFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}
	
	// 오버라이딩
	@Override
	public void showData() {
		super.showData();
		System.out.println("전공: " + major);
		
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이름: " + name);
		System.out.println("전화: " + phoneNumber);
		System.out.println("전공: " + major);
		
		
	}

	
}
