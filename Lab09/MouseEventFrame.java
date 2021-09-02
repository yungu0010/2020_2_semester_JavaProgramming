import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventFrame extends JFrame{
	Container c = getContentPane();
	public MouseEventFrame() {
		setTitle("마우스 올리기 내리기");						//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		c.setLayout(new FlowLayout());					//레이아웃 설정
		JLabel label = new JLabel("사랑해");				//JLabel의 값 지정
		c.add(label);									//컴포넌트 추가
		
		//익명 클래스 작성
		label.addMouseListener(new MouseAdapter() {		//JLabel 컴포넌트에 등록
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 컴포넌트 위에 올라올 때
				label.setText("Love Java");				//JLabel의 값 재지정
			}
			public void mouseExited(MouseEvent e) {		//마우스가 컴포넌트를 벗어날 때
				label.setText("사랑해");					//JLabel의 값 재지정
			}
		});
		
		setSize(400, 200);			//프레임의 크기 설정
		setVisible(true);			//프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new MouseEventFrame();

	}

}
