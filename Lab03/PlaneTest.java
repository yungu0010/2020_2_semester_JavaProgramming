class Plane{
	//멤버 변수 선언
	private String model;
	private int seats;
	//정적변수
	public static int planes=0; 
	
	//생성자 중복정의
	//모든 데이터 받을 때
	public Plane(String model, int seats) {
		this.model = model;
		this.seats = seats;
		planes++;
	}	
	//승객 데이터만 받을 때
	public Plane(int seats) {
		this("\0",seats);
	}
	//모델 데이터만 받을 때
	public Plane(String model) {
		this(model, 0);
	}
	//데이터를 받지 않을 때
	public Plane() {
		this("\0",0);
	}
	
	//모든 필드에 대한 접근자 메소드 작성
	public String getModel() {
		return model;
	}
	public int getSeats() {
		return seats;
	}
	
	//모든 필드의 설정자 메소드 정의
	public void setModel(String smodel) {
		model = smodel;
	}
	public void setSeats(int sseats) {
		seats = sseats;
	}
	
	// 정적변수 planes의 값을 반환하는 정적 메소드
	public static int getPlanes() {
		return planes;
	}
	
	// 객체의 정보를 문자열로 반환하는 메소드, 반환타입을 void로 해주었으나 오류가 발생하여 null반환으로 수정
	public String toString() {
		System.out.println("Plane [model="+model+", seats="+ seats+"]");
		return null;
	}
}

public class PlaneTest {
	public static void main(String[] args) {
		// Plane 객체 여러개 생성
		Plane p1 = new Plane("보잉 777", 100); //설정자로 값을 변환하기 위해 seats의 값을 100으로 생성
		Plane p2 = new Plane("에어버스 - A380", 500);
		Plane p3 = new Plane("보잉 737", 120);
		
		p1.setSeats(200);  //설정자 메소드 호출
		p2.getModel();     //접근자 메소드 호출
		
		System.out.println("전체 보유 비행기 수 = "+Plane.getPlanes());
		
		System.out.println("각 비행기 정보 출력");
		//비행기 정보 출력
		p1.toString();
		p2.toString();
		p3.toString();

	}

}
