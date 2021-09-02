import java.util.*;

public class CustomerManager {
	static Scanner scan = new Scanner(System.in);
	//key를 고객이름으로, value를 포인트로 갖는 HashMap컬렉션 사용
	static HashMap<String, Integer> h = new HashMap<String, Integer>();
	
	public static void print() {			//저장된 고객과 포인트 출력
		Set<String> keys = h.keySet();		//해시맵의 모든 key를 담은 Set컬렉션 리턴
		Iterator<String> it = keys.iterator();	////key문자열을 순서대로 접근할 수 있는 Iterator 리턴
		while(it.hasNext()) {				//방문할 요소가 남아 있으면 true를 리턴
			String key = it.next();			//다음요소리턴
			int value = h.get(key);			//고객이름을 key로 값 읽기
			System.out.print("(" + key + "," + value + ")");
		}
		System.out.println();				//고객정보 모두 출력 후 줄바꿈
	}
	public static void main(String[] args) {
		System.out.println("** 포인트 관리 프로그램입니다 **");
		
		while(true) {
			System.out.print("이름과 포인트 입력>> ");	//입력을 위한 출력문
			String key = scan.next();
			if (key.equals("그만"))				//입력받은 문자열 비교
				break;							//반복문 종료
			int value = scan.nextInt();			//포인트 값 입력
			
			Integer n = h.get(key);				//고객이름을 key로 값 읽기
			if(n != null) {						//이미포인트가 존재할 때
				value += n;						//포인트 누적 계산
			}
			h.put(key, value);					//새로운 또는 수정된 정보 저장
			print();							//고객정보 출력
		}
		scan.close();
				
	}

}

