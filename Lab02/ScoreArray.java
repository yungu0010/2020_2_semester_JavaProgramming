import java.util.Scanner;

public class ScoreArray {

	public static void main(String[] args) {
		// 과목별 점수 출력하는 프로그램
		String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score[] = {95,88,76,62,55};
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("과목 이름>>");   //입력을 위한 출력문
			String name = scan.next();      //입력

			if (name.equals("그만"))         //그만을 입력하면 반복문을 빠져나옴
				break;
			
			for(int i=0; i<5; i++) {        //입력값에 맞는 점수 출력
				if(course[i].equals(name)) {
					int n = score[i];
					System.out.println(course[i]+"의 점수는 "+n);
					break;
				}
				if(i==4)
					System.out.println("없는 과목입니다.");
			}
		}
		scan.close();

	}

}
