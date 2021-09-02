import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MouseStringFrame extends JFrame{
	JLabel lb = new JLabel("Love Java");
	public MouseStringFrame() {
		setTitle("Left 키로 문자열 한칸씩 이동");				//프레임의 이름 설정
		setSize(300, 100);								//프레임의 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		Container c = getContentPane();
		c.setLayout(new FlowLayout());					//레이아웃 지정
		c.add(lb);										//컴포넌트 추가
		
		//익명 클래스로 작성
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { 		//키가 눌러질 때
				int KeyCode = e.getKeyCode();			//가상 키 알아내기
				int i=0;
				String text = lb.getText();				//JLabel의 값을 text에 지정
				if(KeyCode == KeyEvent.VK_LEFT) {		//누른 값이 LEFT일 때
					i++;
					lb.setText(text.substring(i) + text.substring(0, i));	//i에 따라 문자열 조합하여 JLabel의 값으로 지정
					if (i == text.length())				//text의 크기와 같다면
						i = 0;							//0으로 초기화
				}
			}
		});
		setVisible(true);								//프레임을 화면에 출력
		
		//포커스 설정
		c.setFocusable(true);
		c.requestFocus();
			
	}

	public static void main(String[] args) {
		new MouseStringFrame();

	}

}
