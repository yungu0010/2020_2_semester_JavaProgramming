
public class Oval implements Shape{
	private int width;
	private int height;
	
	//생성자
	public Oval(int width, int height) {
		this.width = width;
		this.height = height;
	}

	//접근자와 설정자 메소드
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	//추상메소드 구현
	public void draw() {
		System.out.println("너비: "+ width +", 높이:" + height + "에 내접하는 타원입니다.");
	}
	public double getArea() {
		return (width/2)*(height/2)*PI;
	}
	
}