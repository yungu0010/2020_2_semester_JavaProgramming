
public class Rect implements Shape {
	private int w;
	private int h;
	
	//생성자 생성
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}

	//접근자와 설정자 생성
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	//추상 메소드 구현
	public void draw() {
		System.out.println("너비: "+w + ", 높이:" + h +"의 사각형입니다.");
	}
	public double getArea() {
		return w*h;
	}
	
	
	
	
	
}
