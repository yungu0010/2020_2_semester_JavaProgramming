
public class Person {
	private String name;
	
	// 생성자 생성
	public Person(String name) {
		this.name = name;
	}
	
	// 접근자 생성
	public String getName() {
		return name;
	}
	
	// 갬블링 게임을 진행할 메소드
	public boolean gambling() {
		int num[] = new int [3];				//난수를 저장하기 위한 배열
		for (int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random()*3+1);  //1~3까지의 난수 발생
		}	
		//난수 출력
		System.out.print("\t" + num[0] + "\t" + num[1] + "\t" + num[2] + "\t");
		
		//승패 판결을 위한 숫자 비교
		if (num[0] == num[1] && num[1] == num[2])
			return true;
		else
			return false;
		
	}
}
