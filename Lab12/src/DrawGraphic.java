import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGraphic extends JFrame{
	Container c;
	Color selectedColor;							//색 지정 다이얼로그 
	MyPanel panel = new MyPanel();					//그릴 panel
	String draw="line";								//그리기 모드를 구분해줄 문자열
	JButton line, square, circle, triangle;				
	public DrawGraphic() {
		setTitle("그래픽 그리기");						//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		c = getContentPane();
		createToolBar();							//툴바 생성
		c.add(panel, BorderLayout.CENTER);			//panel의 위치 설정
		setSize(400, 500);							//프레임의 크기 설정
		setVisible(true);							//프레임의 화면에 출력
	}
	private void createToolBar() {
		JToolBar bar = new JToolBar("GUI Menu");	//JToolBar 생성
		bar.setBackground(Color.LIGHT_GRAY);		//툴바의 배경색 지정
		bar.add(new JLabel("도형"));					//컴포넌트 추가
		
		MyActionListener ml = new MyActionListener();	//리스너 생성
		
		line = new JButton("\\");					//버튼 추가와 리스너 등록
		line.addActionListener(ml);
		square = new JButton("□");
		square.addActionListener(ml);
		circle = new JButton("○");
		circle.addActionListener(ml);
		triangle = new JButton("△");
		triangle.addActionListener(ml);
		
		ImageIcon originIcon = new ImageIcon("color.png");	//ImageIcon 객체 생성	
		Image originImage = originIcon.getImage();			//ImageIcon에서 Image 추출
		Image chagedImage = originImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);	//추출된 Image의 크기를 조절하여 새로운 Image객체 생성
		ImageIcon Icon = new ImageIcon(chagedImage);		//새로운 Image로 ImgaeIcon객체 생성
		
		JButton Color = new JButton(Icon);					//버튼 생성
		Color.addActionListener(new ActionListener() {		//리스너 등록
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedColor = JColorChooser.showDialog(null, "Color", java.awt.Color.BLACK);	//컬러다이얼로그, 기본색 검정 			
			}
			
		});
		bar.add(line);								//툴바에 요소 추가
		bar.add(square);
		bar.add(circle);
		bar.add(triangle);
		bar.add(new JLabel(" 색 선택"));
		bar.add(Color);
		c.add(bar, BorderLayout.NORTH);				//툴바 위치 설정
		
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();		
			if(b.getText().equals("\\"))			//버튼 이름에 따라 draw값 설정, draw는 그리기 모드 설정에 사용
				draw = "line";
			else if(b.getText().equals("□"))
				draw = "square";
			else if(b.getText().equals("○"))
				draw = "circle";
			else if(b.getText().equals("△"))
				draw = "triangle";
		}
	}
	
	class MyPanel extends JPanel{
		int x1, x2, y1, y2;
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				//마우스가 눌릴 때 x, y좌표 저장
				public void mousePressed(MouseEvent e) {
					x1 = e.getX();
					y1 = e.getY();
				}

				@Override
				//마우스버튼을 뗄 대 x, y 좌표 저장
				public void mouseReleased(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
					repaint();		//다시 그리기
				}
			});
			addMouseMotionListener(new MouseAdapter() {
				@Override
				//마우스 드래그 동안의 x,y 좌표 저장
				public void mouseDragged(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
					repaint();		//다시 그리기
				}
				
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(selectedColor);		//컬러 다이얼로그의 색으로 색상 지정
			
			int x = Math.min(x1, x2);		//x1, x2중 최소값을 x라 함
			int y = Math.min(y1, y2);		//y1, y2중 최소값을 y라 함
			int w = Math.abs(x2 - x1);		//x좌표끼리의 차의 절댓값으로 너비 구함
			int h = Math.abs(y2 - y1);		//y좌표끼리의 차이 절댓값으로 높이 구함
			if(draw.equals("line")) {		//draw값에 따라 다른 그리기 실행
				g.drawLine(x1, y1, x2, y2);	//선 그리기
			}
			else if(draw.equals("square")) {
				g.drawRect(x, y, w, h);	//사각형 그리기
			}
			else if(draw.equals("circle"))
				g.drawOval(x, y, w, h);	//타원 그리기
			else if(draw.equals("triangle")) {
				int [] xArray = {x1, (x1+x2)/2, x2};		//삼각형 x좌표 배열
				int [] yArray = {y2, y1, y2};			//삼각형 y좌표 배열
				g.drawPolygon(xArray, yArray, 3);		//삼각형 그리기
			}
		}
		
	}
	public static void main(String[] args) {
		new DrawGraphic();

	}

}
