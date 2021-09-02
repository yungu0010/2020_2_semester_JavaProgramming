import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelRandomTest extends JFrame{
	public JLabelRandomTest() {
		setTitle("Random Labels");					//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(300, 300);							//프레임의 크기 설정
		Container c = getContentPane();
		c.setLayout(null);							//레이아웃을 null로 설정
		
		for (int i=0; i<20; i++) {					//사각형을 그릴 횟수만큼 반복
			String n = Integer.toString(i);			//label에 요소를 추가하기 위해 String으로 변환
			JLabel label = new JLabel(n);			//인덱스가 적혀있는 JLabel 생성
			int x = (int)(Math.random()*200) + 50;	//label의 x, y좌표를 250*250 범위에서 랜덤으로 생성
			int y = (int)(Math.random()*200) + 50;
			label.setLocation(x,y);					//label의 위치 지정
			label.setSize(10, 10);					//label 사이즈 지정
			label.setOpaque(true);					//label의 배경색을 바꾸기 위한 설정
			label.setBackground(Color.blue);		//label의 배경색을 파란색으로 생성
			c.add(label);							//contentpane에 label 추가
		}
		
		setVisible(true);							//프레임을 화면에 출력
	}

	public static void main(String[] args) {
		new JLabelRandomTest();
	}

}
