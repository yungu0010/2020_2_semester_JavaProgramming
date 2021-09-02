import java.io.Serializable;

public class Item implements Serializable {		//직렬화를 위한 Serializable 인터페이스
	//속성 정보 작성
	String name;
	String makePeaple;		//감독이나 저자
	String year;
	String imgPath;
	String summary;
	String comments;
	String star;
	
	//생성자
	public Item(String name, String makePeaple, String year, String imgPath, String summary, String comments, String star) {
		super();
		this.name = name;
		this.makePeaple = makePeaple;
		this.year = year;
		this.imgPath = imgPath;
		this.summary = summary;
		this.comments = comments;
		this.star = star;
	}
	//접근자와 설정자
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMakePeaple() {
		return makePeaple;
	}
	public void setMakePeaple(String makePeaple) {
		this.makePeaple = makePeaple;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}

	@Override
	//출력 메소드
	public String toString() {
		return name;
	}
	
	
}
