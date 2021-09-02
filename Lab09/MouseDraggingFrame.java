import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDraggingFrame extends JFrame{
	Container c = getContentPane();
	public MouseDraggingFrame() {
		setTitle("드래깅동안 YELLO");						//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		c.setBackground(Color.green);					//배경색 지정
		c.addMouseMotionListener(new MyMouseMotionListener());	//이벤트 등록
		c.addMouseListener(new MyMouseListener());		//이벤트 등록
		setSize(400, 200);								//프레임의 크기 설정
		setVisible(true);								//프레임을 화면에 출력
	}
	
	//내부 클래스 작성
	public class MyMouseMotionListener extends MouseMotionAdapter{	//adapter 사용
		public void mouseDragged(MouseEvent e) {		//마우스 드래그 시
			c.setBackground(Color.yellow);				//배경색 지정
		}
	}
	
	//내무 클래스 작성
	public class MyMouseListener extends MouseAdapter{	//adapter 사용
		public void mouseReleased(MouseEvent e) {		//눌러진 마우스 버튼이 떼어질 때 
			c.setBackground(Color.green);				//배경색 지정
		}
	}
	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
