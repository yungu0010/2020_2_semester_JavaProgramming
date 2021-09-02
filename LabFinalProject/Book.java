import java.io.Serializable;

public class Book extends Item implements Serializable{		//직렬화를 위한 Serializable 인터페이스
	//추가 속성 작성
	String publisher;
	
	//생성자
	public Book(String name, String makePeaple, String year, String imgPath, String summary, String comments, String star,
			String publisher) {
		super(name, makePeaple, year, imgPath, summary, comments, star);
		this.publisher = publisher;
	}

	@Override
	//출력 메소드
	public String toString() {
		return name;
	}
	//접근자와 설정자
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
