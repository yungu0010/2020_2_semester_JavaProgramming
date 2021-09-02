
public class Movie {
	//속성 작성
	private String title;
	private String director;
	private String genre;
	private Integer year;
	
	//생성자
	public Movie(String title, String director, String genre, Integer year) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
	
	//설정자와 접근자
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
}
