
public class Human {
	//속성
	private String name;
	private int age;
	
	//매개변수로 이름과 나이를 받아와서 멤버 변수 값 초기화
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//각 필드에 대해 접근자와 변경자 메소드 작성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	//현재 값들을 문자열로 반환하는 toString() 메소드 작성
	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age;
	}
	
	
	
}
