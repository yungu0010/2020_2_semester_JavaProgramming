import java.util.Scanner;

public abstract class twoDArray {

	public static void main(String[] args) {
		// 4x4 2차원 배열에 숫자를 임의로 출력하는 프로그램
		Scanner scan = new Scanner(System.in);
		int n[][] = new int[4][4];    //4x4 2차원 배열 생성
		
		for(int j=0; j<4; j++) {   //배열 0으로 초기화
			for(int k=0; k<4; k++)
				n[j][k]=0;       
		}
		
		for (int i=0; i<10; i++) {
			int row = (int)(Math.random()*4);  //배열의 행 인덱스 랜덤 생성
			int col = (int)(Math.random()*4);  //배열의 열 인덱스 랜덤 생성
			
			if(n[row][col]==0) {       //배열의 원소가 0이라면
				int x = (int)(Math.random()*10+1);   //랜덤 숫자(1~10)생성
				n[row][col] = x;   
			}
			else {       //배열의 원소가 0이 아니면 이미 저장된 값이므로 건너뜀
				i--; 
				continue;
			}
		}
		for(int j=0; j<4; j++) {   //2차원 배열 출력
			for(int k=0; k<4; k++)
				System.out.print(n[j][k]+"\t");
			System.out.println();
		}
	scan.close();
	}
}
