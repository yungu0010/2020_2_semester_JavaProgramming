import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		// 십의자리와 일의자리가 같은지 비교하는 프로그램 작성
		Scanner scan = new Scanner(System.in); //Scanner 객체 생성
		
		System.out.print("2자리수 정수 입력(10~99)>>");  //입력을 받기 위한 출력문
		int num = scan.nextInt();  //사용자로부터 숫자 입력받아 저장
		int tens = num/10; //십의자리 저장
		int units = num%10; // 일의자리 저장
		
		System.out.print((tens==units?("Yes! 10의 자리와 1의 자리가 같습니다"):("No! 10의 자리와 1의 자리가 다릅니다"))); //삼중연산자 사용

		scan.close();
	}

}
