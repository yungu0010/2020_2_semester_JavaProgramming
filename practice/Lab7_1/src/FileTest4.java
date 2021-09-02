import java.io.BufferedOutputStream;
import java.io.FileReader;

public class FileTest4 {

	public static void main(String[] args) throws Exception{
		BufferedOutputStream bout = new BufferedOutputStream(System.out, 20);
		FileReader fin = new FileReader("c:\\windows\\system.ini");
		
		int c, n=0;
		while((c = fin.read()) != -1) {
			System.out.println(n);
			bout.write((char)c);
			n++;  
		}
		fin.close();
		bout.close();

	}

}
