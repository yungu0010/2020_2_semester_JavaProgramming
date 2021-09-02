package app; //패키지 분리

import base.Shape;		//사용할 Shape클래스의 경로명 알림
import derived.Circle2; //사용할 Circle2클래스의 경로명 알림

public class GraphicEditor {
	public static void main(String[] args) {
		Shape shape = new Circle2();
		shape.draw();
	}

}
