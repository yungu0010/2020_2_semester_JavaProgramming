class Dice{
	//멤버 변수 선언
	private int value;
	
	// 생성자
	public Dice() {
		value = 0;
	}
	
	//랜덤함수를 사용하여 1~6사이의 값을 저장
	void roll() {
		value = (int)(Math.random()*6+1);
	}
	
	//주사위 변의 값을 반환
	int getValue() {
		return value;
	}
}

public class DiceTest {
	public static void main(String[] args) {
		//주사위 2개 객체 생성
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		int count = 0; //주사위 굴린 횟수를 세는 변수 선언 및 초기화
		
		do {
			//주사위 2개 각각 굴리는 메소드 호출
			d1.roll();  
			d2.roll();
			//실행 결과와 같이 주사위의 각 면의 값을 출력
			System.out.println("주사위1= "+d1.getValue()+ " 주사위2= "+ d2.getValue());
			count++; //실행 횟수 증가
		}while((d1.getValue()!=1 || d2.getValue()!=1));  //반복 조건 작성, 두 주사위 모두 1이 나올 때 까지 반복
		System.out.println("(1,1)이 나오는데 걸린 횟수 = "+count);

	}
}