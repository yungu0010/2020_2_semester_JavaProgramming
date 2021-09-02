import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneSave {

	public static void main(String[] args) throws IOException {	//예외처리
		Scanner scan = new Scanner(System.in);					
		File f = new File("c:\\temp\\phone.txt");				//해당 경로를 가지는 파일 객체 생성
		FileWriter fw = new FileWriter(f);						//파일 출력 스트림 생성
		System.out.println("전화번호 입력 프로그램입니다.");
		while(true) {		
			System.out.print("이름 전화번호 >> ");
			String line = scan.nextLine();						//이름과 전화번호를 한 줄로 받아옴
			if (line.equals("그만"))								//입력받은 값이 그만이면 종료
				break;
			fw.write(line + "\r\n");							//값을 입력받은 뒤 파일에 줄바꿈과 문자열의 처음으로 돌아가기 입력
		}
		System.out.println(f.getPath() + "에 저장하였습니다.");		//getPath를 이용하여 경로 출력
		
		scan.close();
		fw.close();

	}

}
