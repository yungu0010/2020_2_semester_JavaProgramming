import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawFillTest extends JFrame {
	public DrawFillTest(){
		setTitle("Draw Fill 사용 예제");						//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		Container c = getContentPane();
		c.setLayout(new GridLayout(0,3));					//레이아웃 설정
		c.add(new MyPanel1());								//컴포넌트 추가
		c.add(new MyPanel2());								
		c.add(new MyPanel3());								
		setSize(1000, 370);									//프레임 크기 설정
		setVisible(true);									//프레임을 화면에 출력
	}
	
	//JPanel을 상속받은 패널 구현
	class MyPanel1 extends JPanel{
		@Override		//막대 그래프(fillRect)
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRoundRect(10, 10, 300, 300, 30, 30);		//패널의 테두리를 나타내는 roundrect 그리기
			g.setColor(Color.red);							//색 지정
			g.fillRect(30, 80, 50, 200);					//사각형의 좌상단 좌표와 높이, 너비로 그리기
			g.setColor(Color.blue);							
			g.fillRect(100, 110, 50, 170);					
			g.setColor(Color.orange);						
			g.fillRect(170, 140, 50, 140);					
			g.setColor(Color.green);						
			g.fillRect(240, 120, 50, 160);					
		}
		
	}
	class MyPanel2 extends JPanel{
		@Override		//파이차트(fillArc)
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRoundRect(10, 10, 300, 300, 30, 30);		//패널의 테두리를 나타내는 roundrect 그리기
			g.setColor(Color.red);							//색 지정
			g.fillArc(40, 40, 250, 250, 80, 110);			//호를 그릴 사각형의 정보와 호의 시작 각도, 그릴 각도로 채우기
			g.setColor(Color.blue);
			g.fillArc(40, 40, 250, 250, 190, 30);
			g.setColor(Color.yellow);
			g.fillArc(40, 40, 250, 250, 220, 100);
			g.setColor(Color.green);
			g.fillArc(40, 40, 250, 250, 320, 120);
		}	
	}
	class MyPanel3 extends JPanel{
		@Override		//별 그리기(fillPolygon)
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRoundRect(10, 10, 300, 300, 30, 30);		//패널의 테두리를 나타내는 roundrect 그리기
			g.setColor(Color.magenta);						//색 지정
			int x[] = {150, 170, 230, 180, 190, 150, 110, 120, 70, 130};	//도형을 그릴 때 필요한 x좌표 배열
			int y[] = {50, 120, 130, 180, 250, 200, 250, 180, 130, 120};	//도형을 그릴 때 필요한 y좌표 배열
			g.fillPolygon(x, y, x.length);					//x, y 배열을 배열의 크기만큼 좌표를 찍어 채우기
		}
	}
	public static void main(String[] args) {
		new DrawFillTest();

	}

}
