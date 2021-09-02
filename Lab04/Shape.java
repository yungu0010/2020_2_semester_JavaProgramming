
interface Shape {
	final double PI = 3.14;
	void draw(); //도형을 그리는 추상 메소드
	double getArea(); //도형의 면적을 리턴하는 추상 메소드
	default public void redraw() {  //디폴트 메소드
		System.out.print("--- 다시 그립니다. ");
		draw();
	}

}
