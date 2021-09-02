import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame1 extends JFrame{
	public MyFrame1() {
		//필요한 속성들을 설정
		setTitle("두번째 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setBackground(Color.cyan);
		c.setLayout(new FlowLayout());
		c.add(new JButton("1"));
		c.add(new JButton("2"));
		c.add(new JButton("3"));
		setSize(300,300);
		setVisible(true);		//디폴트 false라 꼭 설정해주어야함
	}

	public static void main(String[] args) {
		new MyFrame1();

	}

}
