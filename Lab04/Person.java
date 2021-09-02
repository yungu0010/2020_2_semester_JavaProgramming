
public class Person {
	//속성 정보 작성
	private String name;
	private String address;
	private int phone;
	
	//생성자 정의
	public Person(String name, String address, int phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	//생성자 정의, 전화번호 데이터를 받지 않았을 때
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	//name데이터만 받을 때
	public Person(String name) {
		this(name, "\0", 0);
	}
	//전화번호 데이터만 받을 때
	public Person(int phone) {
		this("\0", "\0", phone);
	}

	//각 필드에 대한 접근자, 설정자 메소드 작성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	

}
