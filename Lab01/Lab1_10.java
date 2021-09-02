import java.util.Scanner;

public class Lab1_10 {

	public static void main(String[] args) {
		// 두 원의 겹침을 판단하는 프로그램
		// 필요한 변수 선언
		int x1, y1;
		int x2, y2;
		double r1, r2, distance;
		
		Scanner scan = new Scanner(System.in);
		
		// 첫번째 원의 정보를 입력받기 위한 출력문
		System.out.print("원의 중심 x1, y1, radius1 >> ");
		// 입력
		x1 = scan.nextInt();
		y1 = scan.nextInt();
		r1 = scan.nextDouble();
		
		// 두번째 원의 정보를 입력받기 위한 출력문
		System.out.print("원의 중심 x2, y2, radius2 >> ");
		// 입력
		x2 = scan.nextInt();
		y2 = scan.nextInt();
		r2 = scan.nextDouble();
		
		// 두 원의 중심의 거리
		distance = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		
		//겹침 여부 판단
		if (distance <= r1+r2) {
			System.out.print("두 원은 서로 겹친다."); //두 원의 반지름의 합보다 중심사이의 거리가 짧을 때
		}
		else {
			System.out.print("두 원은 서로 겹치지 않는다."); //두 원의 반지름 합보다 중심사이의 거리가 길 때
		}
		scan.close();
	}
}
