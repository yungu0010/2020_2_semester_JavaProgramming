import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ColorFontTest extends JFrame{
	//사용할 panel 선언
	private MyPanel panel = new MyPanel();
	public ColorFontTest() {
		setTitle("Color, Font 사용 예제");							//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//close 버튼을 눌렀을 때 실제 프로그램이 종료
		
		setContentPane(panel);									//컨텐트팬을 panel로 설정
		setSize(500, 300);										//프레임 크기 설정
		setVisible(true);										//프레임을 화면에 출력
	}
	
	class MyPanel extends JPanel{								//JPanel을 상속받은 패널 구현
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);								//색 지정
			g.setFont(new Font("궁서", Font.BOLD, 30));			//폰트 지정
			g.drawString("국적: 대한민국(궁서 폰트)", 30, 50);			//출력 스트링과 위치 지정
			
			g.setColor(Color.red);								//색 지정
			g.setFont(new Font("HY얕은샘물M", Font.PLAIN, 30));	//폰트 지정
			g.drawString("주소 : 인천시 서구(HY얕은샘물M)", 30, 100);	//출력 스트링과 위치 지정
			
			g.setColor(Color.orange);							//색 지정
			g.setFont(new Font("휴먼매직체", Font.ITALIC, 30));		//폰트 지정
			g.drawString("성명: 강윤서", 30, 150);					//출력 스트링과 위치 지정

			g.setColor(Color.black);							//색 지정
			g.setFont(new Font("휴먼편지체", Font.PLAIN, 20));		//폰트 지정
			g.drawString("학번: 1914062(휴먼편지체)", 30, 250);		//출력 스트링과 위치 지정

		}
		
	}

	public static void main(String[] args) {
		new ColorFontTest();

	}

}
