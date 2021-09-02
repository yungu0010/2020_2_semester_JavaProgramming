import java.io.*;
import java.util.*;

public class PhoneBook {
	//이름을 키로, 전화번호를 값으로 하는 HashMap
	private static HashMap<String, String> phone = new HashMap<>();
	
	public static void main(String[] args) throws IOException {		//예외처리
		//FileReader객체를 매개변수로 하는 Scanner객체를 활용하여 파일의 내용을 한 라인씩 읽어옴
		Scanner scan = new Scanner(new FileReader(new File("C:\\temp\\phone.txt")));//
		
		while (scan.hasNext()) {		//다음 줄의 내용이 존재하면
			String name = scan.next();	//공백에 따라 각각 이름과 전화번호를 나누어 저장
			String num = scan.next();
			phone.put(name, num);		//HashMap에 저장
		}
		
		scan.close();
		
		//입력을 위한 출력문
		System.out.println("총 " + phone.size() + " 개의 전화번호를 읽었습니다.");		
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("이름>> ");
			String key = scanner.next();		//입력받은 값 저장
			if (key.equals("그만"))				//입력반은 값이 그만이면 반복문 종료 
				break;
			String phoneNum = phone.get(key);	//입력받은 값을 key로 갖는 값 저장
			if (phoneNum == null)				//값이 없을 때
				System.out.println("찾는 이름이 없습니다.");
			else								//값이 존재하면 출력
				System.out.println(phoneNum);
		}
		scanner.close();

	}

}
