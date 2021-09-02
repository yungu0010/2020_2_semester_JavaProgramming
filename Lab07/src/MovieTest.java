import java.io.*;
import java.util.*;

class Movie implements Serializable {		//객체를 직렬화된 데이터로 사용하기 위해 Serializable 인터페이스 포함
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

	//toString메소드 오버라이딩
	@Override
	public String toString() {
		return "[제목:" + title + ", 감독:" + director + ", 장르:" + genre + ", 개봉년도" + year + "]";
	}
	
}

public class MovieTest {
	static Scanner scan = new Scanner(System.in);
	//Movie객체를 저장하는 벡터사용
	static Vector<Movie> v = new Vector<>();		
	
	//MovieTest클래스에서 사용할 static 변수
	private static String title;
	private static String director;
	private static String genre;
	private static Integer year;
	
	public static void main(String[] args) throws Exception {		//예외처리
		while(true) {
			System.out.println("===========영화 정보 관리===========");
			System.out.print("1.엉화 입력/2.영화 출력/3.영화 검색/4.파일 저장/5.파일 열기/6. 종료\n메뉴입력>> ");
			int menu = scan.nextInt();
			scan.nextLine();
			if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;			//반복문 종료
			}
			else if (menu == 1) {		//영화 입력
				System.out.print("제목:");
				title = scan.nextLine();		//한 줄을 모두 입력받기 위해 next()가 아닌 nextLine()사용
				System.out.print("감독:");
				director = scan.nextLine();
				System.out.print("장르:");
				genre = scan.nextLine();
				System.out.print("년도:");
				year = scan.nextInt();
				v.add(new Movie(title, director, genre, year));	//입력받은 정보를 벡터에 저장
			}
			else if (menu ==2) {		//영화 출력
				for (int i=0; i<v.size(); i++) {		//벡터의 크기만큼 반복
					System.out.println(v.get(i));		//인덱스에 따라 저장된 값 출력
				}
			}
			else if (menu == 3) {		//영화 검색
				System.out.print("검색할 제목 입력: ");	//입력을 위한 출력문
				String name = scan.nextLine();		//입력한 값 저장 
				for (int i=0; i<v.size(); i++) {	//벡터의 크기만큼 반복
					Movie m = v.elementAt(i);		//인덱스로 벡터에 저장된 값 m에 저장
					if (name.equals(m.getTitle())) {//제목과 입력한 갑 비교
						System.out.println(v.get(i));
						break;						//반복문 종료
					}
					if (i==v.size()-1)				//마지막 인덱스까지 일치하는게 없다면
						System.out.println(name + "은(는) 없는 영화입니다."); //제목과 입력한 값이 모두 일치하지 않을 때
					
				}
					
			}
			else if (menu == 4) {		//파일 저장
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"));
				oos.writeObject(v);		//객체를 출력
				System.out.println("movie.dat에 저장되었습니다.");
			}
			else if (menu == 5) {		//파일 열기
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"));
				v = (Vector<Movie>)ois.readObject(); //객체 읽기, Vector로 타입캐스팅
				System.out.println("movie.dat로부터 정보를 불러왔습니다.");
			}
		}
		scan.close();
	}

}
