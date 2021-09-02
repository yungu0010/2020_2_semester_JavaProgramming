import java.util.Scanner;
class Phone{
	private String name;
	private String tel;
	
	//생성자, 객체 멤버 변수와 메소드 변수의 이름을 구별하기 위해 this 레퍼런스 사용
	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	//검색한 이름과 비교할 때 이름을 반환해주는 메소드
	public String getName() {
		return name;
	}
	
	//전화번호를 반환해주는 메소드
	public String getTel() {
		return tel;
	}
}
public class PhoneBook {

	public static void main(String[] args) {
		// 이름과 전화번호를 저장하고 검색하는 프로그램 작성
		Scanner scanner = new Scanner(System.in);
		System.out.print("인원수>>");
		int num = scanner.nextInt();
		
		Phone phone[] = new Phone[num];  //입력받은 크기의 객체 배열 생성
		
		for (int i=0; i<num; i++) {  //배열의 크기만큼 반복
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String name = scanner.next();
			String tel = scanner.next();
			phone[i] = new Phone(name,tel); //배열 원소 객체 생성
		}
		System.out.println("저장되었습니다...");
		
		while(true) {
			System.out.print("검색할 이름>>");
			String search = scanner.next();
			
			if (search.equals("그만")) {  //그만을 입력하면 반복문 멈춤
				break;
			}
			for (int i=0; i<num; i++) {
				if (search.equals(phone[i].getName())) {  //검색한 이름과 객체의 이름이 같으면
					System.out.println(search+"의 번호는"+phone[i].getTel()+"입니다.");
				}
			}
		}
	scanner.close();
	}

}
