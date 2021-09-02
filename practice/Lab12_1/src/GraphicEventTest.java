import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

class Rect{
	int x1;
	int y1;
	int x2;
	int y2;
	public Rect(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
public class GraphicEventTest extends JFrame{
	//int x, y, width, height;
	Vector<Rect> v= new Vector<>();
	public GraphicEventTest() {
		setTitle("그래픽 이벤트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		//기본은 BorderLayout
		c.add(new JLabel("그래픽 그리기"), BorderLayout.NORTH);
		c.add(new MyPanel(), BorderLayout.CENTER);
		c.add(new JButton("테스트"), BorderLayout.SOUTH);
		setSize(600, 600);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		int x1, x2, y1, y2;
		public MyPanel() {
			this.setBackground(Color.white);
			addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					x1 = e.getX();
					y1 = e.getY();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
					v.add(new Rect(x1, y1, x2, y2));
					//거꾸로 드래그 해도 그려지려면 큰값 작은값을 비교하여 차를 계산
					//width = e.getX() - x;
					//height = e.getY() - y;
					repaint();
				}
			});
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
					//width = e.getX() - x;
					//height = e.getY() - y;
					repaint();
				}
				
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//x1, x2, y1, y2는 panel에 있는 변수
			int x = Math.min(x1, x2);
			int y = Math.min(y1, y2);
			int w = Math.abs(x1 - x2);
			int h = Math.abs(y1 - y2);
			g.drawRect(x, y, w, h);
			//g.drawRect(x,  y, width, height);
			for(int i =0; i<v.size(); i++) {
				x = Math.min(v.get(i).x1, v.get(i).x2);
				y = Math.min(v.get(i).y1, v.get(i).y2);
				w = Math.abs(v.get(i).x1 - v.get(i).x2);
				h = Math.abs(v.get(i).y1 - v.get(i).y2);
				g.drawRect(x, y, w, h);
			}
		}
		
	}
	public static void main(String[] args) {
		new GraphicEventTest();

	}

}
