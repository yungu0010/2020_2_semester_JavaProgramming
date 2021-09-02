import java.util.Scanner;
import java.util.Vector;

public class VectorRainfall {

	public static void main(String[] args) {
		//강수량을 요소로 가지는 벡터 생성
		Vector<Integer> v = new Vector<>();
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;		//평균을 구할 때 필요한 강수량의 합
		int avg = 0;		//평균을 저장할 속성
		while(true) {		//0을 입력할 때 까지 반복
			System.out.print("강수량 입력 (0 입력시 종료)>> ");
			int rain = scan.nextInt();
			if (rain==0)	//강수량이 0일 때
				break;		//반복문 종료
			v.add(rain);	//요소 삽입
			
			for (int i = 0; i<v.size(); i++) {	//모든 요소 출력하기
				System.out.print(v.get(i) + " ");
			}
			sum += rain;						//평균을 구할 때 쓰이는 합
			avg = sum/v.size();					//강수량의 평균
			System.out.print("\n");
			System.out.println("현재 평균 " + avg);
		}
		scan.close();

	}

}
