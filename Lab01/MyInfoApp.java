import java.util.Scanner;

public class MyInfoApp {

	public static void main(String[] args) {
		// 이름, 학과, 학번 등의 정보를 출력하는 프로그램 작성
		Scanner scan = new Scanner(System.in);
		// 입력을 받기 위한 출력문
		System.out.print("이름: ");
		String name = scan.next(); //입력
		
		System.out.print("학과: ");
		String major = scan.next();
		
		System.out.print("학번: ");
		int studentNum = scan.nextInt();
		
		//실습화면 출력
		System.out.print("이름: " + name + "\n학과: " + major + "\n학번: " + studentNum);
		
		scan.close();
	}

}
