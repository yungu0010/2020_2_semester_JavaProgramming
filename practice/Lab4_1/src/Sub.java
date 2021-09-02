
public class Sub extends Sup {
	int m;

	public Sub(int m) {
		//해결책 1. 부모클래스에 매개변수가 없는 생성자를 만들어준다.
		//해결책 2. 부모클래스가 가지고 있는 생성자의 형식에 따라서 명시적인 호출을 한다.
		super(10,20); 
		this.m = m;
	}
	
	public Sub(int x, int y, int m) {
		super(x,y); 
		this.m = m;
	}
	public int calc() {
		//return x + y + m; 불가능
		//return getX() + getY() + m; 가능
		return super.calc() + m;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return super.toString() + "Sub [m=" + m + "]";
		//return "Sub ["x=" + getX() + ", y=" + getY() + "m=" + m + "]";
	}
}
