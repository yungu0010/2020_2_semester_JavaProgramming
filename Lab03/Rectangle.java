
public class Rectangle {
	//멤버 변수 선언
	private int x;
	private int y;
	private int width;
	private int height;
	
	//생성자, 객체 멤버 변수와 메소드 변수의 이름을 구별하기 위해 this 레퍼런스 사용
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//사각형의 넓이를 반환하는 메소드
	public int square() {
		return width*height;
	}
	
	//사각형의 정보를 출력하는 메소드
	public void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
	
	// 사각형이 동일하거나 매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴
	// x좌표값 비교, x좌표와 width를 더했을 때 결과 비교
	// y좌표값 비교, y좌표와 height를 더했을 때 결과 비교
	public boolean contains(Rectangle r) {
		if (this.x<=r.x && this.x+this.width>=r.x+r.width) {
			if (this.y<=r.y && this.y+this.height >= r.y+r.height ) {
				return true;
			}
		}
		return false;  //Rectangle r이 더 클 때 false 반환
	}

	public static void main(String[] args) {
		//객체 생성
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show();
		System.out.println("s의 면적은 "+ s.square());
		// 사각형의 포함관계 비교
		if(t.contains(s)) System.out.println("t는 s을 포함합니다.");
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		
		

	}

}
