import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		System.out.println(v.capacity());
		v.add(3);
		v.add(5);
		v.add(7);
		v.add(1,10);
		printV(v); 
		v.remove(3);
		printV(v);
		v.set(1, 20); //수정 
		printV(v);
		
		for (int i =0; i<30; i++) {
			v.add(i);
			System.out.println(i+", " + v.capacity()); //capacity가 부족하면 2배씩 증가
		}

	}
	static void printV(Vector<Integer> v) {
		for (int i=0; i<v.size()-1; i++) {
			System.out.print(v.get(i) + ", ");
		}
		System.out.println(v.get(v.size()-1));
	}

}
