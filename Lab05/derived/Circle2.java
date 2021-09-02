package derived; //derived패키지에 분리,

import base.Shape; //Shape 클래스를 상속받으므로 Shape클래스의 경로명 알림 

public class Circle2 extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}
