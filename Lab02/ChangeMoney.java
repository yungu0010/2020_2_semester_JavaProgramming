import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		//입력된 액수를 지폐와 동전으로 변환하는 프로그램
		Scanner scan = new Scanner(System.in);
		
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //배열 객체 생성
		System.out.print("금액을 입력하시오>> "); //입력을 도와주는 출력문
		int money = scan.nextInt(); //금액 입력받아 저장
		
		for(int i=0; i<unit.length; i++) {
			int n= money / unit[i];  //각각의 지폐 및 동전으로 나누어 변환되는 개수 구함
			if (n != 0)              //변환 시 필요한 화폐의 개수가 0개가 아닐 때
				System.out.println(unit[i] + "원 짜리: " + n + "개");
			money -= unit[i]*n;      //변환 된 금액을 제외하고 다시 반복문 실행
		}
		scan.close();
	}

}
