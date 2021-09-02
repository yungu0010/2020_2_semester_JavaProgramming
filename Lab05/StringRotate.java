import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {
		//입력을 위한 출력문 작성
		System.out.println("문자열을 입력하세요. 빈 칸이나 있어도 되고 영어 한글 모두 됩니다.");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		
		for (int i = 0; i<text.length(); i++) {
			String first = text.substring(0,1); //인덱스 0번째 글자만 리턴
			String last = text.substring(1);	//인덱스 1에서 끝까지 리턴
			text = last + first;				//text의 레퍼런스를 last와 first를 순서대로 합하여 생긴 문자열로 변경
			System.out.println(text);
		}
		scanner.close();
		
	}

}
