import java.util.Scanner;

public class PrintAlphabet {

	public static void main(String[] args) {
		// 소문자 알파벳 하나를 입력받아 a부터 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("소문자 알파벳 하나를 입력하시오>> "); 
		String s = scanner.next(); //소문자 알파벳 입력
		char c = s.charAt(0); //문자열의 첫번째 문자를 c에 저장
		
		//a부터 입력받은 소문자까지 출력하는 반복문 작성
		for (int i=0; i<=c-'a'; i++) { //유니코드의 차이만큼 알파벳 출력
			for (char j='a'; j<=c-i; j++) { //c-i를 통해 출력문자를 하나씩 줄임
				System.out.print(j);
			}
			System.out.println(); //한 줄 입력 후 줄바꿈
				
		}
		scanner.close();
	}

}
