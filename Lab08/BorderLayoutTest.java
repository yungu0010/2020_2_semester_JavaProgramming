import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		setTitle("BorderLaout Practice");		//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(400, 200);						//프레임의 크기 설정
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 7));	//레이아웃 설정, 컴포넌트 사이의 수평 수직 간격 설정
		
		//JButton을 index공간에 배치
		c.add(new JButton("North"), BorderLayout.NORTH);	
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("Center"), BorderLayout.CENTER);

		setVisible(true);		//프레임을 화면에 출력
	}

	public static void main(String[] args) {
		new BorderLayoutTest();

	}

}
