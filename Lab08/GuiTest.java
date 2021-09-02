import java.awt.*;
import javax.swing.*;

public class GuiTest extends JFrame {
	public GuiTest() {
		setTitle("GUI TEST");		//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(400,250);			//프레임의 크기 설정
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10, 10));			//레이아웃 설정, 컴포넌트 사이의 수평 수직 간격 설정
		
		JPanel p0 = new JPanel();						//JPanel 생성
		p0.setLayout(new GridLayout(4, 1));				//JPanel을 4*1의 GridLayout으로 설정
		p0.add(new JLabel("이 름"));						//JPanel에 JLabel 추가
		p0.add(new JLabel("학 번"));
		p0.add(new JLabel("전 공"));
		p0.add(new JLabel("연락처"));
		c.add(p0, BorderLayout.WEST);					//BorderLayout의 인덱스 위치에 JPanel추가
		
		JPanel p1 = new JPanel();						//JPanel 생성
		p1.setLayout(new GridLayout(4, 1));				//JPanel을 4*1의 GridLayout으로 설정
		p1.add(new JTextField(20));						//JPanel에 JTextField 추가
		p1.add(new JTextField(20));
		p1.add(new JTextField(20));
		p1.add(new JTextField(20));
		c.add(p1, BorderLayout.CENTER);					//BorderLayout의 인덱스 위치에 JPanel추가
		
		JPanel p2 = new JPanel();						//JPanel 생성
		p2.add(new JButton("확인"));						//JPanel에 버튼 추가
		p2.add(new JButton("취소"));
		c.add(p2, BorderLayout.SOUTH);					//BorderLayout의 인덱스 위치에 JPanel추가
		setVisible(true);								//프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new GuiTest();

	}

}
