package chapter11.Football;

public class FootballPlayer implements Comparable<FootballPlayer> {

	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {

		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public FootballPlayer() {

	}

	@Override
	public String toString() {

		return name + ", " + String.valueOf(number) + ", " + team + ", " + String.valueOf(age);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		FootballPlayer f = (FootballPlayer) obj;
		if (f.name.equals(this.name) && f.team.equals(this.team) && f.age == this.age) {
			result = true;
		}
		return result;
	}

	@Override
	public int hashCode() {
		return this.number % 10;
	}

	// 3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고,
	// 같은 팀의 선수들은 이름 순으로 정렬하고, 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
	//

	@Override
	public int compareTo(FootballPlayer o) {

		int result = this.team.compareTo(o.team); // 음수 / 양수 / 0
		if (result == 0) {
			result = this.name.compareTo(o.name);
			if (result == 0) {
				result = this.number - o.number;
			}
		}

		return result;

	}

}
