
public class Book1 {
	//속성 정보 작성
	String title; //제목
	int page;     //페이지수
	String author;//저자
	public static int count;  //책의 개수
	
	//생성자
	public Book1(String title, int page, String author) {
		this.title = title;
		this.page = page;
		this.author = author;
		count++;
	}
	//생성자, 저자의 데이터가 주어지지 않았을 때
	public Book1(String title, int page) {
		this.title = title;
		this.page = page;
	}

	//각 필드에 대한 접근자와 설정자 메소드 생성
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	//책의 개수에 대해서는 접근자 메소드만 클래스 메소드로 작성
	public static int getBookcount() {
		return count;
	}
	
}
