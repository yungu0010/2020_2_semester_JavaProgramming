import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Sup s[] = new Sup[4]; //Sup 객체 4개가 만들어진건 아님! Sup객체를 참조할 수 있는 변수 4개 생성
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<s.length; i++) {
			System.out.println("1. Sup, 2. Sub");
			String menu = scan.next();
			if (menu.equals("1")) {
				System.out.print("숫자 1: ");
				int n1 = scan.nextInt();
				System.out.print("숫자 2: ");
				int n2 = scan.nextInt();
				s[i] = new Sup(n1, n2);  
			}
			else if (menu.equals("2")) {
				System.out.print("숫자: ");
				int n = scan.nextInt();
				s[i] = new Sub(n);	
			}
			else {
				System.out.println("잘못된 입력");
				i--;
			}
			
		}
		for (int i=0; i<s.length; i++) {
			System.out.println(s[i]);
			System.out.println(s[i].calc());
			//System.out.println(s[i].toString() + s[i].calc());
			//덧셈 연산에 참여하는 아이는 숫자 양옆에 들어가는 아이가 숫자이거나 문자일 때만 가능하기 때문에 명시적으로 문자열
			
		}
		scan.close();
	}

}
