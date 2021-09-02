import java.util.Scanner;

public class Lab1_6 {

	public static void main(String[] args) {
		// 간단한 369게임
		Scanner scan = new Scanner(System.in);
		
		// 입력을 위한 간단한 출력문
		System.out.print("1~99 사이의 정수를 입력하세요>>");
		int num = scan.nextInt();
		
		int one = num%10;  //일의자리 숫자 저장
		int ten;
		if (num>=10) {    
			ten = num/10; //입력받은 숫자가 두자리 수일 때 십의자리 숫자 저장
		}
		else
			ten = 0; //입력받은 숫자가 한자리 수일 때 십의자리 숫자 저장
		
		System.out.print("박수");
		if ((ten==3 || ten==6 || ten==9)&&(one==3 || one==6 || one==9)){ // 두 자리 모두 3, 6, 9 중 하나인 경우
			System.out.print("짝짝");
		}
		else if ((ten==3 || ten==6 || ten==9)||(one==3 || one==6 || one==9)) { //두 자리 수 중 하나만 3, 6, 9 중 하나인 경우
			System.out.print("짝");
		}
		else 
			System.out.print("없음");
		
		scan.close();
	}

}
