import java.util.Scanner;

public class Lab1_8 {

	public static void main(String[] args) {
		// 직사각형의 충돌 여부를 판별하는 프로그램
		Scanner scan = new Scanner(System.in);
		
		// 입력을 받기 위한 출력문
		System.out.print("x1, y1 입력>>");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		
		System.out.print("x2, y2 입력>>");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		
		if ((x1>=100 && x1<=200) && (y1>=100 && y1<= 200)) {
			System.out.print("충돌 발생"); //왼쪽 상단 좌표가 주어진 사각형 내에 있을 때
		}
		else if ((x2>=100 && x2<=200) && (y2>=100 && y2<= 200)) {
			System.out.print("충돌 발생"); //오른쪽 하단 좌표가 주어진 사각형 내에 있을 때
		}
		else if ((x1<=100 && y1<=100) && (x2>=200 && y2>= 200)) {
			System.out.print("충돌 발생"); //입력한 사각형이 주어진 사각형을 포함할 때 
		}
		else if ((x1>=100 && y1>=100) && (x2<=200 && y2<= 200)) {
			System.out.print("충돌 발생"); //입력한 사각형이 주어진 사각형 내부에 있을 때 
		}
		else
			System.out.print("충돌 없음");
		 
		 scan.close();
	}

}
