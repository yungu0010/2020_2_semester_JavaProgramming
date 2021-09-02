import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ImageTest extends JFrame {
	//사용할 panel 선언
	private MyPanel panel = new MyPanel();
	public ImageTest() {
		setTitle("그래픽 이미지 연습");						//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setContentPane(panel);							//컨텐트팬을 panel로 설정
		setSize(500, 300);								//프레임 크기 설정
		setVisible(true);								//프레임을 화면에 출력
	}
	
	//JPanel을 상속받은 패널 구현
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("Back.jpg");		//이미지 로딩 
		private Image img = icon.getImage();					//이미지 객체 가져오기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w = getWidth();							//프레임의 너비
			int h = getHeight();						//프레임의 높이
			int iw = img.getWidth(this);				//이미지의 높이
			int ih = img.getHeight(this);				//이미지의 너비
			//이미지 출력 (이미지 객체, 이미지를 그릴 화면의 영역, 그릴 이미지 영역)값을 매개변수로 가짐 
			g.drawImage(img, 0, 0, w/2 - 5, h/2 - 5, 0, 0, iw/2, ih/2, this);	//좌상단 이미지
			g.drawImage(img, w/2 + 5, 0, w, h/2 - 5, iw/2, 0, iw, ih/2, this);	//우상단 이미지
			g.drawImage(img, 0, h/2 + 5, w/2 - 5, h, 0, ih/2, iw/2, ih, this);	//좌하단 이미지
			g.drawImage(img, w/2 + 5, h/2 + 5, w, h, iw/2, ih/2, iw, ih, this);	//우하단 이미지
		}
		
	}
	public static void main(String[] args) {
		new ImageTest();

	}

}
