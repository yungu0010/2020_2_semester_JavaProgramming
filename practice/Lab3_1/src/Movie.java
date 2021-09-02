
public class Movie {
	// 제목, 감독, 개봉년도
	// 속성 (state, attributes... )
	String title;
	String director;
	int year;
	
	public Movie() {
		this("","",2020);
	}
	public Movie(String s) {
		this(s,"",2020);
	}
	public Movie(String title, String director, int year) {
		this.title = title;
		this.director = director;
		this.year = year;
	}
	
	public void printMovie() {
		System.out.println("["+title+","+director+","+year+"]");
	}

}
