
public class Print2DArray {

	public static void main(String[] args) {
		// 2차원 배열 n을 출력하는 프로그램
		int n[][]= {{1},
				{1,2,3},
				{1},
				{1,2,3,4},
				{1,2}}; //2차원 배열 선언, 생성, 초기화
		
		for (int i=0; i<n.length; i++) {  //2차원 배열의 행만큼 반복
			for (int j=0; j<n[i].length; j++) { //2차원 배열의 열만큼 반복
				System.out.print(n[i][j]);
				System.out.print("\t");
			}
			System.out.println(); //하나의 행이 종료될 때 줄바꿈
		}

	}

}
