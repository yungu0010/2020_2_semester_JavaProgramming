import java.util.*;

public class LocationManager {
	static Scanner scan = new Scanner(System.in);
	//key를 도시이름으로, value를 Location객체로 갖는 HashMap컬렉션 사용
	static HashMap<String, Location> h = new HashMap<String, Location>();
	
	public static void put() {						//도시정보를 입력받는 메소드
		System.out.println("도시,경도,위도를 입력하세요.");	//입력을 위한 출력문
		for (int i =0; i<4; i++) {					//4개의 도시를 저장하기 위한 반복문
			System.out.print(">> ");
			String text = scan.nextLine();			//하나의 문자열로 입력 받기
			StringTokenizer token = new StringTokenizer(text, ",");	//,를 기준으로 문자열 분리 
			String city = token.nextToken().trim();					//분리된 문자열을 나누어 저장
			float logitude = Float.parseFloat(token.nextToken().trim());	//문자열을 실수로 변환할 때 Wrapper클래스 활용
			float latitude = Float.parseFloat(token.nextToken().trim());
			
			Location loc = new Location(city, logitude, latitude);	//location 객체 생성
			h.put(city, loc);		//도시이름을 key로, location객체를 value로 해시맵에 저장
		}
	}
	
	public static void print() {					//모든 도시를 출력하는 메소드
		Set<String> key = h.keySet();				//key문자열을 가진 집합 Set 컬렉션 리턴
		Iterator<String> it = key.iterator();		//key문자열을 순서대로 접근할 수 있는 Iterator 리턴
		while(it.hasNext()) {						//방문할 요소가 남아 있으면 true를 리턴
			String city = it.next();				//다음요소리턴
			Location loc = h.get(city);				//도시이름을 key로 값 읽기
			//출력
			System.out.print(loc.getCity() + "\t");
			System.out.print(loc.getLogitude() + "\t");
			System.out.println(loc.getLatitude());
		}
	}
	public static void search() {					//도시이름으로 반복해서 검색하는 메소드
		while(true) {
			System.out.print("도시 이름 >> ");
			String city = scan.nextLine();
			if (city.contentEquals("그만"))			//그만을 입력하면 종료
				return;
			
			Location loc = h.get(city);				//도시이름을 key로 검색
			if (loc == null) {						//도시가 해시맵에 없다면
				System.out.println(city + "는 없습니다.");
			}
			else {									//도시가 해시맵에 있다면
				System.out.print(loc.getCity() + "\t");
				System.out.print(loc.getLogitude() + "\t");
				System.out.println(loc.getLatitude());
			}
		}
	}
	public static void main(String[] args) {
		put();										//도시정보 입력
		System.out.println("------------------------");
		print();									//모든 도시 출력
		System.out.println("------------------------");
		search();									//도시정보 검색
	}

}
