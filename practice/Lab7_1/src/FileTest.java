import java.io.FileReader;
import java.io.IOException;

public class FileTest {

//	public static void main(String[] args) throws Exception {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("data.txt");
			int c;
			while((c=fr.read()) != -1) {
				System.out.print((char)c);
			}
			fr.close();	
		}
		catch(IOException e) {		
			//FileNotFoundException이 IOException의 하위범주이므로 한번에 해결
			System.out.println("입출력 관련 예외");
		}
	}

}
