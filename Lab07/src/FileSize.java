import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		File f = new File("c:\\");			//
		File [] files = f.listFiles();		//File클래스로 c:\\에 있는 파일리스트 가져오기
		
		long biggest = 0;					//파일 크기를 저장할 변수
		File bigFile = null;				//파일을 저장할 변수
		
		for (int i=0; i<files.length; i++) {	//파일리스트의 크기만큼 반복
			File file = files[i];				
			if (!file.isFile())					//디렉토리인 경우 넘어감 
				continue;						
			
			long size = file.length();			//파일의 크기를 size에 저장
			if (biggest < size) {				//biggest가 size보다 작다면
				biggest = size;					//size의 값 대입
				bigFile = file;					//bigFile변수에 파일 객체 저장
			}
		}
		
		if (bigFile == null)					//bigFile이 비었다면 해당 폴더 내 파일이 존재하지 않음
			System.out.println("파일이 없습니다.");
		else									//아니라면 출력
			System.out.println("가장 큰 파일은 " + bigFile.getPath() + " " + biggest + "바이트");

	}

}
