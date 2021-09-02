import java.io.Serializable;

public class User implements Serializable {		//객체를 직렬화된 데이터로 사용하기 위해 Serializable 인터페이스 포함
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	//생성자
	public User(String id, String pw, String name, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	//접근자와 설정자
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "[ 아이디: " + id + ", 이름: " + name + ", phone=" + phone + "]";
	}
	
	
}
