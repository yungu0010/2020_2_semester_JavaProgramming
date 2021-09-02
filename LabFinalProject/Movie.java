import java.io.Serializable;

public class Movie extends Item implements Serializable{		//직렬화를 위한 Serializable 인터페이스
	//추가 속성 정보 작성
	String actor;
	String genre;
	String rank;

	//생성자
	public Movie(String name, String makePeaple, String year, String imgPath, String summary, String comments, String star,
			String actor, String genre, String rank) {
		super(name, makePeaple, year, imgPath, summary, comments, star);
		this.actor = actor;
		this.genre = genre;
		this.rank = rank;
	}
	
	//접근자와 생성자
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	//출력 메소드
	@Override
	public String toString() {
		return name;
	}
	
	
}
