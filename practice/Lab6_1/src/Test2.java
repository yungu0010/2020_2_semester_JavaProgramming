import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		//사용자로부터 여러개의 정수를 입력받아서 저장
		//잘못된 숫자를 넣었을 때  처리를 넣고 싶으면 예외처리 코드를 작성
		while(true) {
			System.out.print("정수 입력(0~), -1 입력하면 종료: ");
			int n = scan.nextInt();
			if (n==-1) break;
			al.add(n);
		}
		
		//계산
		int sum=0;
		for(int i=0; i<al.size(); i++) {
			sum+=al.get(i);
		}
		System.out.println("평균은 " + sum/al.size());

	}

}
