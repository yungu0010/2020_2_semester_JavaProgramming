
public class B {

	public static void main(String[] args) {
		String s = "Java, Python, C, C++";
		String []s2 = s.split(",");
		for (int i=0; i<s2.length; i++) { //배열 length는 소괄호 필요없지만 문자열 length는 소괄호 필요
			s2[i] = s2[i].trim();
			System.out.println(s2[i]);
		}
		s = "Java Programming!";
		System.out.println(s.substring(5));
		System.out.println(s.substring(5, 12));  //5 <= index < 12
		System.out.println(s.toLowerCase());
		System.out.println(s.indexOf("ing"));
		
		/*String s = "Java Programming!";
		char c = s.charAt(5);
		System.out.println(c);
		String a = "Book";
		String b = "Aool";
		int n = a.compareTo(b);  //a가 가진 값이 b보다 나중에 나오면 양수, 같은값은 0
		System.out.println(n);
		
		String t = s.concat("Test");
		System.out.println(s);
		System.out.println(t);
		//문자열 객체는 수정을 할 수가 없어요.
		// "Java Programming!" 문자열 수정불가
		
		s = "test"; //참조를 변경은 가능!
		System.out.println(s.contains("t")); //문자 자체를 넣는건 안돼서 ""문자열로 변경
		System.out.println(s.length());
		t = s.replace('t', 'T');			//s를 replace해달라했지만 새로운 문자열을 구성한다
		System.out.println(s);
		System.out.println(t); 
		
		
		String a = "Hello";
		String b = "Java";
		String c = "Hello";
		String d = new String("Hello");
		String e = new String("Java");
		String f = new String("Java");
		
		if (a==c)
			System.out.println("a==c같은 참조");
		if (e==f)
			System.out.println("e==f같은 참조");
		if (a==d)
			System.out.println("a==d같은 참조");
		if (b.equals(e))
			System.out.println("b==e같은 문자열 구성");
		if (b.equals(f))
			System.out.println("b==f같은 문자열 구성");*/
				
	}

}
