import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileTest3 {

	public static void main(String[] args) throws IOException{
		//파일이름도 입력받을 수 있음
		FileOutputStream fos = new FileOutputStream("data3.txt");
		FileInputStream fis = new FileInputStream("data3.txt");
		byte data[] = {1,3,5,7,11,51,59};
		for (int i=0; i<data.length; i++)
			fos.write(data[i]);
		System.out.println("저장을 완료하였습니다. ");
		System.out.println("데이터를 읽어오려면 Enter키를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
				
		int c;
		while((c=fis.read()) != -1) {
			System.out.print((byte)c + ", ");
		}
		System.out.println("읽어오기가 완료되었습니다");
		fos.close(); fis.close(); scan.close();
	}

}
