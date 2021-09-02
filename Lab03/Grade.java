import java.util.Scanner;

public class Grade {
	//동일 클래스 내에만 접근 허용하도록 private 사용
	private int math;
	private int science;
	private int english;
	
	//생성자, 객체 멤버 변수와 메소드 변수의 이름을 구별하기 위해 this 레퍼런스 사용
	public Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	//평균 계산 메소드, public으로 설정하여 모든 클래스에 접근 허용
	public int average() {
		return (math+science+english)/3;
	}

	public static void main(String[] args) {
		//3 과목의 점수를 입력 받아 Grade 객체를 생성하고 성적 평균을 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);  
		
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");//점수를 입력받을 출력문
		//주어진 순서대로 변수를 생성하여 입력된 값 저장
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		
		//Grade 객체 생성
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 "+ me.average());  //평균 계산하여 리턴
		scanner.close();
	}

}
