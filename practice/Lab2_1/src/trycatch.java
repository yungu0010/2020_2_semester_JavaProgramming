import java.util.InputMismatchException;
import java.util.Scanner;

public class trycatch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 3개를 입력하세요");
		int sum=0, n=0;
		System.out.print(0+">>");
		try {
			n=scan.nextInt();
			System.out.println("실행될까?");
		}
		catch(InputMismatchException e){
			System.out.println("정수 아님");
			scan.nextLine();	
		}
		sum+=n;
		System.out.println("Rmx");
		scan.close();

	}

}
