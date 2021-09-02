import java.io.*;
import java.util.Scanner;

public class FileAppend {

	public static void main(String[] args) throws IOException {	//예외처리
		Scanner scan = new Scanner(System.in);
		FileReader fr = null;					
		FileWriter fw = null;
		
		//입력을 위한 출력문과 파일 이름 작성
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		String first = scan.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요>>");
		String second = scan.nextLine();
		System.out.print("합치는 파일 이름을 입력하세요>>");
		String result = scan.nextLine();
		
		fw = new FileWriter(result);		//파일 출력 문자 스트림 생성
		int i = 0;							
		
		fr = new FileReader(first);			//파일 입력 문자 스트림 생성
		while((i = fr.read()) != -1) {		//읽어온 파일 데이터를 모두 스크린에 출력, -1은 파일 끝
			fw.write((char)i);				//읽어온 데이터를 char로 타입캐스팅하여 출력
		}
		fw.write("\r\n");					//값을 입력받은 뒤 파일에 줄바꿈과 문자열의 처음으로 돌아가기 입력
		
		fr = new FileReader(second);		//파일 입력 문자 스트림 생성
		while((i = fr.read()) != -1) {		//읽어온 파일 데이터를 모두 스크린에 출력, -1은 파일 끝
			fw.write((char)i);				//읽어온 데이터를 char로 타입캐스팅하여 출력
		}

		fr.close();
		fw.close();
		System.out.println("프로젝트 폴더 밑에 " + result + "파일에 저장하였습니다.");
		scan.close();

	}

}
