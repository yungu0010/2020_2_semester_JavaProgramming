import java.io.*;

public class PhoneOpen {

	public static void main(String[] args) throws IOException{ //예외처리
		File f = new File("c:\\temp\\phone.txt"); 	//해당 경로를 가지는 파일 객체 생성
		FileReader fr = new FileReader(f);			//파일 입력 문자 스트림 생성
		
		System.out.println(f.getPath()+"를 출력합니다."); //getPath를 통해 파일의 경로 출력
		while(true) {
			int c = fr.read();						//문자 하나를 읽어옴
			if (c == -1)							//파일 끝을 만나면 반복문 종료
				break;
			System.out.print((char)c);				//읽어온 문자를 char로 타입캐스팅 하여 출력
		}
		fr.close();
	}

}
