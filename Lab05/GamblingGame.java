import java.util.Scanner;

public class GamblingGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//선수 이름을 받아 Person객체 생성
		System.out.print("1번째 선수 이름>>");
		String name = scan.next();
		Person p1 = new Person(name);
		
		System.out.print("2번째 선수 이름>>");
		name = scan.next();
		Person p2 = new Person(name);
		//2번째 선수 이름 입력 후 사용하는 enter 키를 처리하는 역할 
		scan.nextLine();		

		while (true) {		//게임이 종료될 때 까지 반복
			System.out.print("["+p1.getName() + "]:<Enter>" );
			scan.nextLine();
			if (p1.gambling()) {		//gambling 메소드의 반환값이 true일 때
				System.out.println(p1.getName() + "님이 이겼습니다!");
				break;				//while문 종료
			}
			System.out.println("아쉽군요!");//gambling 메소드의 반환값이 false일 때 실행
			
			// p2도 p1과 같은 방법으로 진행
			System.out.print("["+p2.getName() + "]:<Enter>" );
			scan.nextLine();
			if (p1.gambling()) {		//gambling 메소드의 반환값이 true일 때
				System.out.println(p2.getName() + "님이 이겼습니다!");
				break;				//while문 종료
			}
			System.out.println("아쉽군요!");//gambling 메소드의 반환값이 false일 때 실행
		}
		scan.close();
	}

}
