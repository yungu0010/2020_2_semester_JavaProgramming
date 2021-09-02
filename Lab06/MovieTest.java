import java.util.*;

public class MovieTest {
	static Scanner scan = new Scanner(System.in);
	//key를 영화제목으로, value를 Movie객체로 갖는 HashMap컬렉션 사용
	static HashMap<String, Movie> h = new HashMap<>();		
	
	//MovieTest클래스에서 사용할 static 변수
	private static String title;
	private static String director;
	private static String genre;
	private static Integer year;
	
	public static void input() {		//영화정보 입력
		System.out.print("제목:");
		title = scan.nextLine();		//한 줄을 모두 입력받기 위해 next()가 아닌 nextLine()사용
		System.out.print("감독:");
		director = scan.nextLine();
		System.out.print("장르:");
		genre = scan.nextLine();
		System.out.print("년도:");
		year = scan.nextInt();
		h.put(title, new Movie(title, director, genre, year));	//입력받은 정보로 h에 key와 value값 저장
	}
	
	public static void print() {		//모든 영화정보 출력
		Set<String> keys = h.keySet();	//key문자열을 가진 집합 Set 컬렉션 리턴
		Iterator<String> it = keys.iterator();	//key문자열을 순서대로 접근할 수 있는 Iterator 리턴
		
		while(it.hasNext()) {			//방문할 요소가 남아 있으면 true를 리턴
			String text = it.next();	//다음요소리턴
			Movie m = h.get(text);		//영화제목을 key로 값 읽기
			//출력
			System.out.println("[제목:" + m.getTitle() + ", 감독:" + m.getDirector() + ", 장르:" + m.getGenre() + ", 개봉년도:" + m.getYear() + "]");
		}
	}
	
	public static void search() {		//영화정보 검색
		System.out.print("검색할 제목 입력: ");	//입력을 위한 출력문
		title = scan.nextLine();		
		Movie m = h.get(title);			//입력받은 값을 key로 값 읽기
		if (m==null)					//key가 존재하지 않을 때
			System.out.println(title + "은(는) 없는 영화입니다.");
		else							//key가 존재할 때
			System.out.println("[제목:" + m.getTitle() + ", 감독:" + m.getDirector() + ", 장르:" + m.getGenre() + ", 개봉년도:" + m.getYear() + "]");
	}
	
	public static void modify() {		//영화정보 수정
		System.out.print("수정할 제목 입력: ");	//입력을 위한 출력문
		title = scan.nextLine();
		Movie m = h.get(title);			//입력받은 값을 key로 값 읽기
		if (m==null)					//key가 존재하지 않을 때
			System.out.println(title + "은(는) 없는 영화입니다.");
		else {							//key가 존재할 때
			System.out.println("[제목:" + m.getTitle() + ", 감독:" + m.getDirector() + ", 장르:" + m.getGenre() + ", 개봉년도:" + m.getYear() + "]");
			//수정할 정보 입력
			System.out.print("제목:");
			title = scan.nextLine();
			System.out.print("감독:");
			director = scan.nextLine();
			System.out.print("장르:");
			genre = scan.nextLine();
			System.out.print("년도:");
			year = scan.nextInt();
			h.put(title, new Movie(title, director, genre, year));	//입력받은 정보로 h에 key와 value값 저장
		}
			
	}
	
	public static void delete() {		//영화정보 삭제
		System.out.print("삭제할 제목 입력: ");	//입력을 위한 출력문
		title = scan.nextLine();
		Movie m = h.get(title);			//입력받은 값을 key로 값 읽기
		if (m==null)					//key가 존재하지 않을 때
			System.out.println(title + "은 없는 영화입니다.");
		else {							//key가 존재할 때
			h.remove(title);			//key로 요소 삭제
			System.out.println(title + "이(가) 삭제되었습니다.");
		}
			
	}
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("===========영화 정보 관리===========");
			System.out.print("1. 입력/2. 출력/3. 검색/4. 수정/5. 삭제/6. 종료\n메뉴입력>> ");
			int menu = scan.nextInt();
			scan.nextLine();
			if (menu == 6) { 
				System.out.println("프로그램을 종료합니다.");
				break;			//반복문 종료
			}
			else if (menu == 1)
				input();		//영화정보 입력
			else if (menu ==2)
				print();		//영화정보 출력
			else if (menu == 3)
				search();		//영화정보 검색
			else if (menu == 4)
				modify();		//영화정보 수정
			else if (menu == 5)
				delete();		//영화정보 삭제
		}
		scan.close();

	}

}
