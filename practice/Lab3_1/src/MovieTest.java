
public class MovieTest {

	public static void main(String[] args) {
		// 영화 정보 관리하는 프로그램
		// 영화에 대한 객체
		Movie m1 = new Movie();
		Movie m2 = new Movie("영화1");
		Movie m3 = new Movie("영화2", "감독2", 2022);
		m1.printMovie();
		m2.printMovie();
		m3.printMovie();
	}

}
