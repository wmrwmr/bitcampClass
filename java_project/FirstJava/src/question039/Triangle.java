package question039;

//문제1.
//밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 삼각형의 넓이를 계
//산해서 반환하는 메서드도 함께 정의하자.

public class Triangle {
	int base;
	int height;

	void change(int base, int height) {
		Triangle t = new Triangle();
		t.base = base;
		t.height = height;
	}

	double area(Triangle t) {

		int area = (t.base * t.height) / 2;
		return area;
	}
}
