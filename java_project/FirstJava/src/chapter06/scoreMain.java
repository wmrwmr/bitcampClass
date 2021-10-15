package chapter06;

public class scoreMain {
	public static void main(String[] args) {
		ScoreManager manager = new ScoreManager(); // 10개 저장공간

		// 1. 데이터 저장
		manager.insertScore(new Student("손흥민", 100, 100, 100));
		manager.insertScore(new Student("KING", 90, 80, 70));
		manager.insertScore(new Student("SCOTT", 60, 50, 40));

		// 2. 데이터 전체 출력
		manager.showAllData();

		// 3. 데이터 검색
		manager.searchData();

		// 4. 데이터 삭제
		manager.deleteScore();

		// 5. 데이터 검색 또는 전체 데이터 출력
		manager.showAllData();

	}
}
