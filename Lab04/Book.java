
public class Book extends Item {
	//추가 속성 작성
	private String writer ;
	
	//생성자 작성, 이름, 가격, 저자를 매개변수로 받아서 설정
	public Book(String name, int price, String writer) {
		super(name, price);
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "[Book]"+ name + ", 저자:" + writer;
	}

}
