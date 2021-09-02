
public class Magazine extends Book1 {
	//추가 속성 정보 작성
	private String date;  //발매일

	//생성자
	public Magazine(String title, int page, String author, String date) {
		super(title, page, author);//생성자 내에서 부모 생성자 호출
		this.date = date;
	}
	//생성자, 저자의 데이터가 주어지지 않았을 때 
	public Magazine(String title, int page, String date) {
		super(title, page); //생성자 내에서 부모 생성자 호출
		this.date = date;
	}

	//각 필드에 대한 접근자 메소드와 설정자 메소드 작성
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
