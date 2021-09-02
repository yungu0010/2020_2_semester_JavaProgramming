import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame{
	Container c = getContentPane();
	JLabel lb;
	public ClickPracticeFrame() {
		setTitle("클릭 연습 용 응용프로그램");		//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(300, 300);					//프레임의 크기 설정
		c.setLayout(null);					//레이아웃 null로 지정
		lb = new JLabel("C");				//JLabel값 설정
		lb.setSize(10,10);					//JLabel의 사이즈 지정
		lb.setLocation(100, 100);			//JLabel의 초기 위치 지정
		
		c.add(lb);							//JLabel추가
		lb.addMouseListener(new MyMouseListener());		//이벤트 리스너 등록, C를 클릭할 때만 발생하도록 lb에 등록
		setVisible(true);								//프레임을 화면에 출력
		
		//포커스 지정
		c.setFocusable(true);
		c.requestFocus();
	}
	
	//내부 클래스로 작성
	class MyMouseListener extends MouseAdapter {		//adapter 사용
		int x, y;
		public void mousePressed(MouseEvent e) {		//마우스 버튼이 눌러지는 순간 호출
			//c.getWidth()와 c.getHeight는 범위를 벗어나서 스노우보드처럼 내부 패널을 확인 한 후 반올림하여 범위를 지정
			x = (int)(Math.random()*275);		//내부 패널의 너비 내에서 랜덤 발생
			y = (int)(Math.random()*250);		//내부 패널의 너비 내에서 랜덤 발생	
			lb.setLocation(x, y);						//lb의 위치 재지정
		}
	}
	public static void main(String[] args) {
		new ClickPracticeFrame();
	}

}
