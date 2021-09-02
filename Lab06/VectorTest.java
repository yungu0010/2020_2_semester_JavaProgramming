import java.util.Scanner;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		//양의 정수 요소로 가지는 벡터 생성
		Vector<Integer> v = new Vector<Integer>();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수(-1이 입력될 때까지)>> ");
		while(true) {
			int n = scan.nextInt();
			if (n==-1) 			//입력값이 -1일 때
				break;			//정수 -1을 입력하면 반복문 종료
			v.add(n);			//요소 삽입
		}
		System.out.print("삭제 전:[");
		for (int i=0; i<v.size()-1;i++) {		//요소 출력
			System.out.print(v.get(i) + ", ");
		}
		System.out.println(v.get(v.size()-1) + "]");
		
		int biggest=0;		//수를 비교할 때 사용
		int index = 0;		//삭제할 인덱스 저장
		for (int i=0; i<v.size(); i++) {
			if (biggest < v.get(i)) {		//biggest보다 큰 수가 있으면
				biggest = v.get(i);			//수와 인덱스를 바꾸어 저장
				index = i;
			}
		}
		v.remove(index);					//인덱스 요소 삭제
		System.out.println("가장 큰 수 " + biggest + " 삭제");
		
		System.out.print("[");
		for (int i=0; i<v.size()-1;i++) {	//삭제된 요소 출력
			System.out.print(v.get(i) + ", ");
		}
		System.out.println(v.get(v.size()-1) + "]");
		
		int smallest = v.get(0);			//요소들과 비교하기 위해 첫번째 수를 저장
		for (int i=0; i<v.size(); i++) {
			if (smallest > v.get(i)) {		//smallest보다 작은 수가 있으면
				smallest = v.get(i);		//수와 인덱스를 바꾸어 저장
				index = i;
			}
		}
		v.remove(index);					//가장 작은 수를 저장한 인덱스 삭제
		System.out.println("가장 작은 수 " + smallest + " 삭제");
		
		System.out.print("삭제 후:[");
		for (int i=0; i<v.size()-1;i++) {	//출력
			System.out.print(v.get(i) + ", ");
		}
		System.out.println(v.get(v.size()-1) + "]");
		scan.close();

	}

}
