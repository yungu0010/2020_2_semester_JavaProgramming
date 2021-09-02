
public class Buyer {
	private int money;
	
	//money를 매개변수로 받아서 멤버 변수 설정
	public Buyer(int money) {
		this.money = money;
	}
	
	//Item과 개수를 매개변수로 받아서 출력결과와 같은 형태로 내용을 출력하는 Buy메소드 작성
	public void buy(Item t, int n) {
		System.out.println(t.toString() + "=>" + n +"개 구매");
		money -= n*t.price;
		if (money>=0) {
			System.out.println("구매 완료 후 잔액 : "+money);
		}
		else {
			money +=n*t.price;
			System.out.println("잔액 부족: " + money);
		}
	}
}