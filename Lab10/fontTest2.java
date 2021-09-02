import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fontTest2 extends JFrame{
	Container c;
	Color selectedColor;
	MyPanel panel = new MyPanel();
	int x1, y1, x2, y2;
	String draw;
	public fontTest2() {
		setTitle("그래픽 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		createToolBar();
		c.add(panel, BorderLayout.CENTER);
		setSize(400, 500);
		setVisible(true);
	}
	private void createToolBar() {
		JToolBar bar = new JToolBar("GUI Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		bar.add(new JLabel("도형"));
		
		MyActionListener ml = new MyActionListener();
		
		JButton line = new JButton("\\");
		line.addActionListener(ml);
		JButton square = new JButton("□");
		square.addActionListener(ml);
		JButton circle = new JButton("○");
		circle.addActionListener(ml);
		JButton triangle = new JButton("△");
		triangle.addActionListener(ml);
		JButton Color = new JButton("");
		Color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedColor = JColorChooser.showDialog(null, "Color", java.awt.Color.BLACK);			
			}
			
		});
		bar.add(line);
		bar.add(square);
		bar.add(circle);
		bar.add(triangle);
		bar.add(new JLabel(" 색 선택"));
		bar.add(Color);
		c.add(bar, BorderLayout.NORTH);
		
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("\\"))
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
		public MyPanel() {
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
				}
				@Override
				public void mouseDragged(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
				}
			});
		}
		
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(selectedColor);
			if (draw.equals("line"))
				g.drawLine(x1, y1, x2, y2);
			else if (draw.equals("square"))
				g.drawRect(x1, y1, x2, y2);
			else if (draw.equals("circle"))
				g.drawOval(x1, y1, x2, y2);
			else if (draw.equals("triangle"))
				g.drawRect(x1, y1, x2, y2);
				
		}
		
		
	}
	public static void main(String[] args) {
		new fontTest2();

	}

}
