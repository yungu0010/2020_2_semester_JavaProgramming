import java.io.*;
import java.util.*;
public class FileTest2 {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		FileWriter fw = null;
		
		fw = new FileWriter("data2.txt");
		while(true) {
			String line = scan.nextLine();
			if (line.length() == 0)
				break;
			//fw.write(line, 0, line.length());
			//fw.write("\r\n", 0, 2);  //줄의 제일 앞쪽으로 + newline
			fw.write(line+"\r\n");	//오프셋이 뭐지?
		}
		fw.close();
		scan.close();
	}

}
