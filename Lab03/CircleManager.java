import java.util.Scanner;
class Circle{
	//멤버 변수 선언
	private double x, y;
	private int radius;
	
	//생성자, 객체 멤버 변수와 메소드 변수의 이름을 구별하기 위해 this 레퍼런스 사용
	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	//화면에 출력
	public void show() {
		System.out.println("("+x+","+y+")"+radius);
	}
	
	//원의 면적을 계산하여 반환하는 메소드
	public double getArea() {
		return radius*radius*Math.PI;
	}
	
}
public class CircleManager {
	public static void main(String[] args) {
		// 객체 정보를 입력받아 가장 큰 면적을 가진 원의 정보를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Circle c[] = new Circle[3];  //크기가 3인 객체 배열 생성
		
		for (int i=0; i<c.length; i++) {  //배열의 크기만큼 반복
			System.out.print("x, y, radius >>");
			double x = scanner.nextDouble(); //x값 읽기
			double y = scanner.nextDouble(); //y값 읽기
			int radius = scanner.nextInt(); //반지름 값 읽기
			c[i] = new Circle(x, y, radius); //배열 원소에 Circle 객체 생성
		}
		
		//모든 Circle 객체 출력
		for (int i =0; i<c.length; i++)
			c[i].show();
		
		int biggestIndex=0;  //면적을 비교할 때 사용할 변수 생성
		for (int i=1; i<c.length; i++) { //biggestIndex가 0이므로 i는 1부터
			if (c[biggestIndex].getArea() < c[i].getArea())
				biggestIndex = i;
		}
		System.out.print("가장 면적이 큰 원은 ");
		c[biggestIndex].show();
		scanner.close();

	}

}
