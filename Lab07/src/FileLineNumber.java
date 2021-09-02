import java.io.*;
import java.util.Scanner;

public class FileLineNumber {

	public static void main(String[] args) throws IOException{	//예외처리
		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력");
		
		//FileReader객체를 매개변수로 하는 Scanner객체를 생성
		Scanner fscan = new Scanner(new FileReader("c:\\windows\\system.ini")); 
		int num = 1;							//입력해줄 라인 번호
		while (fscan.hasNext()) {				//다음 줄의 내용이 존재하면
			String line = fscan.nextLine();		//한 줄씩 입력받기
			System.out.printf("%4d", num++);	//줄 번호 출력 후 num 값 증가
			System.out.println(": " + line);	//저장한 한 줄의 값 출력
		}
		fscan.close();
	}

}
