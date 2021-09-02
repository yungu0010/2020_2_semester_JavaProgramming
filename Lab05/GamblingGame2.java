import java.util.Scanner;

public class GamblingGame2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//게임에 참여할 선수 입력
		System.out.print("갬블링 게임에 참여할 선수 숫자>>");
		int num = scan.nextInt();  
		//입력받은 크기의 객체 배열 생성
		Person[] person = new Person[num];
		
		for (int i =0; i<num; i++) {
			System.out.print((i+1) + "번째 선수 이름>>");
			String name = scan.next();
			person[i] = new Person(name);	//배열 원소 객체 생성  
		}
		
		//선수 이름 입력 후 사용하는 enter키를 처리하는 역할
		//String enter = scan.nextLine();
		scan.nextLine();
		//게임이 종료될 때 까지 반복
		while (true) {
			for (int i=0; i<num; i++) {		//객체 배열의 크기만큼 반복
				System.out.print("["+person[i].getName() + "]:<Enter>" );
				scan.nextLine();
				if (person[i].gambling()) {		//gambling 메소드의 반환값이 true일 때
					System.out.println(person[i].getName() + "님이 이겼습니다!");
					scan.close();			
					return;					//프로그램 종료
				}		
				System.out.println("아쉽군요!");//gambling 메소드의 반환값이 false일 때
			}
		}
	}

}
