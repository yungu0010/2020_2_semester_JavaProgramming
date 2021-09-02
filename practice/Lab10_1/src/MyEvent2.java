import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyEvent2 extends JFrame {
	JButton btn = new JButton("hello");
	final int STEP = 10;
	public MyEvent2() {
		setTitle("키 이벤트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		btn.setBounds(50, 50, 100, 30);
		c.add(btn);
		c.addKeyListener(new KeyAdapter() {
//밖으로 나가지 않을 때 어떻게 작성해야하는지 작성해보기
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					btn.setLocation(btn.getX()-STEP, btn.getY()); break;
				}
			}
		});
		
		setSize(300, 200);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	public static void main(String[] args) {
		new MyEvent2();

	}

}
