
public class Movie extends Item {
	//추가 속성 작성
	private String director;

	//생성자 작성, 이름, 가격, 감독을 매개변수로 받아서 설정
	public Movie(String name, int price, String director) {
		super(name, price);
		this.director = director;
	}

	//toString 메소드 재정의
	@Override
	public String toString() {
		return "[Movie]" + name + ", 감독:" + director;
	}
}
