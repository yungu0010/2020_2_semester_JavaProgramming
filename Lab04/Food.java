
public class Food extends Item {
	//생성자, 이름과 가격을 매개변수로 받아서 설정
	public Food(String name, int price) {
		super(name, price);
	}

	//toString 메소드 재정의
	@Override
	public String toString() {
		return "[Food]" + name;
	}
	
	
}
