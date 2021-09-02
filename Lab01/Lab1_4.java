import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		// 3개의 수 중 중간 크기의 수를 출력하는 프로그램
		Scanner scan = new Scanner(System.in);
		// 입력을 받기 위한 출력문
		System.out.print("정수 3개 입력>>");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		//중간값 판별
		if ((a<b && b<c)||(c<b && b<a)) {
			System.out.print("중간 값은 " + b);
		}
		else if ((b<a && a<c)||(c<a && a<b)) {
			System.out.print("중간 값은 " + a);
		}
		else 
			System.out.print("중간 값은 " + c);
		
		scan.close();

	}

}
