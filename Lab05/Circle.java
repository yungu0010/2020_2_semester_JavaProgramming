
public class Circle {
	//멤버 변수 선언
	private int x;
	private int y;
	private int radius;
	
	//x, y, radius를 받아 필드를 초기화하는 생성자
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	// Object 클래스의 toString() 메소드 재정의
	public String toString() {
		return "Circle(" + x + "," + y + ")반지름" + radius;
	}

	@Override
	// Object 클래스의 equals() 메소드 재정의	
	public boolean equals(Object obj) {
		Circle c = (Circle)obj;
		if ((x == c.x && y == c.y))
			return true;
		else return false;
	}
	
}
