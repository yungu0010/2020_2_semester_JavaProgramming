import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		//크기가 3인 Human 객체와 Student 객체 배열 생성
		Human h[] = new Human[3];  
		Student s[] = new Student[3];
		
		Scanner scan = new Scanner(System.in);
		
		//사용자로부터 이름과 나이를 입력받아 3명의 Human 객체 생성
		for (int i=0; i<h.length; i++) {
			System.out.print("[" + (i+1) + "] Human 입력:");
			String name = scan.next();
			int age = scan.nextInt();
			h[i] = new Human(name, age);
		}
		
		//사용자로부터 이름, 나이, 전공, 학번을 입력받아 3명의 Student 객체 생성
		for (int i=0; i<s.length; i++) {
			System.out.print("[" + (i+1) + "] Student 입력:");
			String name = scan.next();
			int age = scan.nextInt();
			String major = scan.next();
			int sID = scan.nextInt();
			s[i] = new Student(name, age, major, sID);
		}
		
		//각 객체참조변수 이름을 출력문 작성
		for (int i=0; i<h.length; i++) {
			System.out.println(h[i].toString());
		}
		
		for (int i=0; i<s.length; i++) {
			System.out.println(s[i].toString());
		}
		
		scan.close();
	}

}
