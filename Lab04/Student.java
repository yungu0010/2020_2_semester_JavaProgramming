
public class Student extends Human{
	//추가 속성 정의
	private String major;
	private int sID;
	
	//생성자, 매개변수로 이름, 나이, 전공, 학번을 받아와서 초기화
	public Student(String name, int age, String major, int sID) {
		super(name, age);  //부모 클래스의 생성자 호출
		//매개변수로 받아온 값으로 멤버 변수의 전공과 학번을 초기화
		this.major = major;
		this.sID = sID;
	}

	//필드에 대하여 접근자와 변경자 메소드 생성
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}

	//부모의 toString 호출하여 받아온 문자열 값에 추가로 전공 값 연결하여 문자열 반환 
	@Override
	public String toString() {
		return "[학생 정보]" + super.toString() + ", 전공:" + major + ", 학번:" + sID;
	}
}	
