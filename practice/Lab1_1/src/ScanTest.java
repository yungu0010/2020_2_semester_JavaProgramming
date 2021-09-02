import java.util.Scanner;
public class ScanTest {

	public static void main(String[] args) {
		// 사용자 정보를 입력받아서 출력하는 프로그램 작성
		Scanner scan = new Scanner(System.in); //scan은 변수 이름
		// 간단한 입력 받기 위한 출력문
		System.out.print("이름:");
		String name = scan.next();// 입력
		
		System.out.print("도시:");
		String city = scan.next();
		

		scan.nextLine(); //기존 도시 입력에서 남겨진 줄바꿈 문자를 처리
		System.out.print("주소:");
		String address = scan.nextLine(); //next만 하면 공백단위로 읽어옴
		//nextLine은 한 줄로 받지만! 입력값 (Enter) \r\n이기 때문에 nextLine에서 \r\n을 받아와 무시함
		//이전에도 nextLine으로 받아오면 문제가 없음 또는 "scan.nextLine()"추가, 12번째 줄 이후에 들어가도 상관 없음
			
		System.out.println("입력받은 정보는 "+name+","+city+","+address);
		
		int n=10;
		System.out.println("숫자 값 : "+ n + (n>1?"counts":"count"));
		scan.close();
	}

}
