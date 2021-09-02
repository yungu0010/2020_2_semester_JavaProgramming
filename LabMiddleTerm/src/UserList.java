import java.io.*;
import java.util.*;

public class UserList {
	static Scanner scan = new Scanner(System.in);
	//User객체를 저장하는 벡터사용
	static Vector<User> u = new Vector<>();
	
	//UserList에서 사용할 static 변수
	private static String name;
	private static String id;
	private static String pw;
	private static String phone;
	
	public static void main(String[] args) throws Exception {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"));
			u = (Vector<User>)ois.readObject(); //객체 읽기, Vector로 타입캐스팅
			System.out.println("기존 사용자 정보를 정상적으로 불러왔습니다.");
		}
		catch (EOFException e){
			System.out.println("저장된 사용자 정보가 없습니다. 회원가입부터 해주세요.");
		}
		while(true) {
			System.out.println("==========================================");
			System.out.println("1. 회원가입/ 2. 로그인/ 3. 모든 사용자 출력/ 4. 종료");
			System.out.println("==========================================");
			System.out.print("번호를 입력하시오: ");
			int menu = scan.nextInt();
			if (menu == 1 ) {				//회원가입
				System.out.print("아이디: ");
				name = scan.next();	
				System.out.print("비밀번호: ");
				id = scan.next();
				System.out.print("이름: ");
				pw = scan.next();
				System.out.print("연락처: ");
				phone = scan.next();
				u.add(new User(name, id, pw, phone));	//입력받은 정보를 벡터에 저장
			}
			else if (menu == 2) {			//로그인
				System.out.print("아이디: ");
			    String fid = scan.next();			//findid라는 의미
				System.out.print("비밀번호: ");
				String fpw = scan.next();			//findpw라는 의미
				
				for (int i=0; i<u.size(); i++) {	//벡터의 크기만큼 반복
					User user = u.elementAt(i);		//인덱스로 벡터에 저장된 값 u에 저장
					if (fid.equals(user.getId()) && (fpw.equals(user.getPw()))) {
						System.out.println("로그인 성공하였습니다. " + user.getName() + "님 환영합니다.");
						break;					
					}
					else if (fid.equals(user.getId()) && (!fpw.equals(user.getPw()))) {
						System.out.println("비밀번호가 맞지 않습니다.");
						break;
					}
					if (i==u.size()-1)				//마지막 인덱스까지 일치하는게 없다면
						System.out.println("가입되지 않은 정보입니다. 회원가입해 주세요.");  //정보가 일치하지 않을 때 
				}
			}
				
			else if (menu == 3) {			//사용자 모두 출력
				if (u.size() != 0) {
					System.out.println("전체 " + u.size() + "명의 정보가 있습니다.");					
				}
				else
					System.out.println("저장된 정보가 없습니다.");

				for (int i=0; i<u.size(); i++) {		//벡터의 크기만큼 반복
					System.out.println(u.get(i));		//인덱스에 따라 저장된 값 출력
				}
			}
			else if (menu == 4) {			//종료
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"));
				oos.writeObject(u);		//객체를 출력
				System.out.println("사용자들 정보가 저장되었습니다. 종료합니다.");
				break;
			}	
		}
		scan.close();
	}

}
