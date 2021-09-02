import java.util.InputMismatchException;
import java.util.Scanner;

public class ExTest {
	static Scanner scan = new Scanner(System.in); //Ctrl + Shift + O
	public static void main(String[] args) {
		try {
			a();
			b();
			c();	
		}
		catch(ArrayIndexOutOfBoundsException e) {
			//
		}
		catch(NumberFormatException e) {
			//
		}
		catch(InputMismatchException e) {
			//
			System.out.println("입력 오류");
		}
		System.out.println("나머지 정상적인 실행");
	}
	static void a() throws ArrayIndexOutOfBoundsException{
		int n[] = new int[5];
		n[3] = 10;
		System.out.print("인덱스 입력:");
		int i = scan.nextInt();
		n[i] = 20;
	}
	static void b() throws NumberFormatException {
		System.out.print("정수 입력:");
		String s = scan.next();
		int num = Integer.parseInt(s);
	}
	static void c() throws InputMismatchException {
		System.out.print("정수 입력");
		int no = scan.nextInt();
		
	}

}
