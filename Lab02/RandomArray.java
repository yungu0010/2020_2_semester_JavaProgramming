import java.util.Scanner;

public class RandomArray {

	public static void main(String[] args) {
		// 정수를 랜덤하게 생성해서 배열에 저장하는 프로그램
		Scanner scan = new Scanner(System.in);
		int randomArray[]; //배열 선언
		
		System.out.print("정수 몇개? ");   //입력을 받기 위한 출력문
		int num = scan.nextInt();       //개수(배열의 크기) 입력
		randomArray = new int[num];     //입력된 개수와 같은 크기를 같은 배열 생성
		
		for(int i=0; i<num; i++) {      //배열의 크기만큼 반복
			int r = (int)(Math.random()*100+1); //1~100 범위의 랜덤 정수 r생성
			randomArray[i]=r;           //배열에 저장
			for(int j=0; j<i; j++) {
				if(randomArray[i]==randomArray[j]) { //배열 내에 같은 수가 있는지 검사
					i--;                //같은 수가 있다면 개수를 세지 않음
					continue;           //for문의 반복 후 작업으로 이동
				}
			}
		}
		int line=0;                     //과제 예시처럼 10개씩 출력되도록 개수를 세는 변수
		for(int k=0; k<num; k++) {
			System.out.print(randomArray[k]+" ");  //출력
			line++;
			if (line==10) {             //10개를 출력했을 때
				System.out.println();   //줄바꿈 해줌
				line=0;                //0부터 다시 출력 개수를 세도록 함
			}
		}

		scan.close();
	}
}
