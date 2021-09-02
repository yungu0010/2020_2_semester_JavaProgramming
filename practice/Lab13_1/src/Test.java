class SharedBoard{
	private int sum =0;
	synchronized public void add() {
		int n = sum;
		Thread.yield();
		n += 10;
		sum = n ;
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
}

class MyThread extends Thread{
	private SharedBoard board;
	public MyThread(String name, SharedBoard board) {
		super(name);
		this.board = board;	
	}
	public void run() {
		for(int i =0; i<10; i++) {
			board.add();
		} 
	}
}
public class Test {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread t1 = new MyThread("A", board);
		Thread t2 = new MyThread("B", board);
		t1.start();
		t2.start();
	}
}
