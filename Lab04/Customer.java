
public class Customer extends Person{
	//추가 속성 정보 생성
	private int cnumber; //고객 번호
	private int mileage;
	
	//생성자
	public Customer(String name, String address, int phone, int cnumber, int mileage) {
		super(name, address, phone);
		this.cnumber = cnumber;
		this.mileage = mileage;
	}
	//생성자, 전화번호 데이터를 받지 않았을 때
	public Customer(String name, String address, int cnumber, int mileage) {
		super(name, address);
		this.cnumber = cnumber;
		this.mileage = mileage;
	}

	//각 필드에 대한 접근자와 설정자 메소드 생성
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}
