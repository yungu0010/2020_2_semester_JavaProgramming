import java.awt.*;
import javax.swing.*;

public class GraphicTest extends JFrame {
	public GraphicTest() {
		setTitle("그래픽 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("돋움", Font.BOLD, 30));
			g.drawString("그래픽 테스트", 50, 50);
			g.setColor(Color.blue);
			g.drawRect(50, 50, 100, 30);
			g.setColor(Color.magenta);
			g.drawOval(50, 100, 80, 40);
			g.setColor(Color.green);
			g.drawLine(200, 100, 300, 300);
			g.setColor(Color.red);
			g.drawRoundRect(300, 350, 100, 100, 20, 40);
			g.drawRect(100, 200, 200, 200);
			g.setColor(Color.orange);
			g.drawArc(100, 200, 200, 200, 60, 30);
			
			int x[] = {200, 260, 100, 300, 140};
			int y[] = {100, 300, 160, 160, 300};
			g.setColor(Color.DARK_GRAY);
			g.drawPolygon(x, y, x.length);
			
			g.setColor(Color.BLUE);
			int x2[] = {300, 400, 200};
			int y2[] = {300, 400, 400};
			g.drawPolyline(x2, y2, x2.length);
			
		}
	}
	public static void main(String[] args) {
		new GraphicTest();

	}

}
