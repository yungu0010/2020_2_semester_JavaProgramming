import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyEvent extends JFrame{
	JTextField tf;
	JButton btn1, btn2;
	JLabel lb1;
	int count = 0;
	public MyEvent() {
		setTitle("이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this.setD하면 추천해줌
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//익명 클래스 작성
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//getX, getY 는 프레임 안에서의 상대적 위치값으로 좌표값 얻어옴
				//전체 화면을 기준으로 하면 getXOnScreen 호출
				System.out.println("마우스 위치:" +e.getX() + "," + e.getY());
			}
			
			
		});
		MyListener ml = new MyListener();
		
		tf = new JTextField(10);
		tf.addActionListener(ml);
		btn1 = new JButton("+");
		btn1.addActionListener(ml);
		btn2 = new JButton("-");
		btn2.addActionListener(ml);
		lb1 = new JLabel("결과");
		
		c.add(tf);
		c.add(btn1);
		c.add(btn2);
		c.add(lb1);
		
		setSize(400, 200);
		setVisible(true);
	}
	//내부 클래스로 작성
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o==tf) {  //객체 비교이므로 참조값이 같은지 비교
				lb1.setText("TextField : " + tf.getText());
			}
			else if(o == btn1) {
				//lb1.setText(btn1.getText());
				lb1.setText(""+ ++count);
			}
			else {   //o==btn2
				//lb1.setText(btn2.getText());
				lb1.setText("" + --count);
			}
		}
		
	}
	public static void main(String[] args) {
		new MyEvent();

	}

}
/*
//독립 클래스, ActionListener는 인터페이스이므로 추상메소드 구현해주지 않으면 빨간줄 생김
class MyListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()+"버튼이 눌러졌어요");
		String s = e.getActionCommand();
		if(s.contentEquals("버튼1")){
			System.out.println("A 처리");
		}
		else {
			System.out.println("B 처리");
		}
	}
	
}
*/