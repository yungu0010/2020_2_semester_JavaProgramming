import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		//필요한 속성들을 설정
		setTitle("첫번째 프레임 만들기");
		setSize(300,300);
		setVisible(true);		//디폴트 false라 꼭 설정해주어야함
	}

	public static void main(String[] args) {
		new MyFrame();

	}

}
