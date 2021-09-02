
public class Location {
	private String city;
	private float logitude;	//경도
	private float latitude; //위도
	
	//생성자
	public Location(String city, float logitude, float latitude) {
		super();
		this.city = city;
		this.logitude = logitude;
		this.latitude = latitude;
	}
	
	//접근자와 설정자
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public float getLogitude() {
		return logitude;
	}
	public void setLogitude(float logitude) {
		this.logitude = logitude;
	}

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
		

}
