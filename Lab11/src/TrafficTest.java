import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TrafficTest extends JFrame{
	int color = 1;											//색을 지정할 때 쓰일 변수
	public TrafficTest() {
		setTitle("");										//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		Container c = getContentPane();
		JButton btn = new JButton("traffic light turn on");	//JButton 생성
		MyListener ml = new MyListener();					//이벤트 리스너 생성
		
		c.add(new MyPanel(), BorderLayout.CENTER);			//panel을 center에 추가
		c.add(btn, BorderLayout.SOUTH);						//JButton을 south에 추가
		btn.addActionListener(ml);							//이벤트 리스너 등록
		setSize(300, 500);									//프레임 크기 설정
		setVisible(true);									//프레임을 화면에 출력
	}
	
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (color == 3)									//color변수 값이 3이면
				color = 1;
			else
				color++;									//color값 1씩 증가
			repaint();										//다시 그리기
		}	
	}
	
	//JPanel을 상속받은 패널 구현
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(100, 100, 80, 80);					//신호등이 될 도형 그리기
			g.drawOval(100, 180, 80, 80);
			g.drawOval(100, 260, 80, 80);
			
			//color가 1면 해당 위치 도형을 빨간색으로 칠함
			if (color == 1) {
				g.setColor(Color.RED);
				g.fillOval(100, 100, 80, 80);
			}
			//color가 2면 해당 위치 도형을 초록색으로 칠함
			else if (color == 2) {
				g.setColor(Color.GREEN);
				g.fillOval(100, 180, 80, 80);	
			}
			//color가 3이면 해당 위치 도형을 노란색으로 칠함
			else if (color == 3) {
				g.setColor(Color.YELLOW);
				g.fillOval(100, 260, 80, 80);
			}
		}
		
	}
	public static void main(String[] args) {
		new TrafficTest();

	}

}
