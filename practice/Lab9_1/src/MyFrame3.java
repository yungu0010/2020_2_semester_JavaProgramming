import java.awt.*;
import javax.swing.*;

public class MyFrame3 extends JFrame{
	public MyFrame3() {
		setTitle("BorderLayout Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10, 10));
		
		JPanel p0 = new JPanel();		//panel의 default는 flowlayout인데 flowlayout의 default는 가운데
		p0.add(new JLabel("보더레이아웃 테스트"));
		c.add(p0, BorderLayout.NORTH);
		
		JPanel p1 = new JPanel();		//west
		p1.setLayout(new GridLayout(0,1));
		p1.add(new JLabel("메뉴1"));
		p1.add(new JLabel("메뉴2"));
		c.add(p1, BorderLayout.WEST);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0,1));
		p2.add(new JTextField(20));
		p2.add(new JTextField(20));
		c.add(p2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(0,1));
		p3.add(new JLabel("텍스트1"));
		p3.add(new JLabel("텍스트2"));
		p3.add(new JLabel("텍스트3"));
		c.add(p3, BorderLayout.EAST);
		
		JPanel p4 = new JPanel();
		p4.add(new JButton("확인"));
		p4.add(new JButton("취소"));
		c.add(p4, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame3();

	}

}
