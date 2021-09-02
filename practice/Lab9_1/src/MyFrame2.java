import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {
	public MyFrame2() {
		setTitle("FlowLayout Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 50));
		
		for (int i=0; i<10; i++) {
			c.add(new JButton("버튼"+i));
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}
