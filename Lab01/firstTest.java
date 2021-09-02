import java.util.Scanner;

public class firstTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		long first = 0;
		long second =1;
		long num = scan.nextInt();
		
		for (int i=0; i<num; i++) {
			first += second;
			second = first - second;
		}
		System.out.print(first);
	}

}
