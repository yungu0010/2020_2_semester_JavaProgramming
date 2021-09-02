
public class Circle implements Shape {
	private int radius;
	
	//생성자
	public Circle(int radius) {
		this.radius = radius;
	}
	
	//접근자와 설정자 메소드
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	//추상메소드 구현
	public void draw() {
		System.out.println("반지름이 "+ getRadius() +"인 원입니다.");
	}
	public double getArea() {
		return PI *radius*radius;
	}
	
	
}
