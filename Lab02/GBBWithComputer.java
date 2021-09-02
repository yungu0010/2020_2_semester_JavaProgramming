import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		// 가위바위보 프로그램
		Scanner scan = new Scanner(System.in);
		String str[]= {"가위", "바위", "보"};
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		while(true) {
			System.out.print("가위 바위 보!>>");
			String ans = scan.next();   //사용자 입력 

			int n =(int)(Math.random()*3);  //컴퓨터 값 임의로 받음
			
			if (ans.equals("그만")) {     //그만을 입력하면 반복문을 빠져나옴
				System.out.println("게임을 종료합니다...");
				break;             
			}
			else if (ans.equals(str[n])){   //가위 바위 보 결과에 따라 예시와 같이 결과를 출력해줌
				System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 비겼습니다.");
			}
			else if (ans.equals("가위")){
				if(n==1)
					System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 사용자가 졌습니다.");
				else
					System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
			}
			else if (ans.equals("바위")){
				if(n==0)
					System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
				else
					System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 사용자가 졌습니다.");
			}
			else {
				if(n==0)
					System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 사용자가 졌습니다.");
				else
					System.out.println("사용자 = "+ans + " , 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
			}
		}
		scan.close();
	}
}
