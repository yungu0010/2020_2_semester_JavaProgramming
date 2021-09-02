public class Sup {
	private int x;
	private int y;
	//source -->
	//public Sup() {}
	public Sup(int x, int y) {  //생성자
		this.x = x;
		this.y = y;
	}	 
	public int calc() {
		return x + y;
	}
	
	public int getX() {   //Getters
		return x;
	}
	public void setX(int x) {   //Setters
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//정보를 출력할 때 유용하게 쓰이는 메소드 쇅. 문자열을 리턴하는 메소드
	@Override   //부모클래스 메소드 재정의하기 때문
	public String toString() {
		return "Sup [x=" + x + ", y=" + y + "]";
	}
}
