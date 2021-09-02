import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiTest extends JFrame{
	JTextField tf1, tf2, tf3, tf4;
	JButton btn1, btn2;
	public GuiTest() {
		setTitle("GUI TEST");							//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(400,250);								//프레임의 크기 설정
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10, 10));			//레이아웃 설정, 컴포넌트 사이의 수평 수직 간격 설정
		
		MyListener ml = new MyListener();				//이벤트 리스너 생성
		
		JPanel p0 = new JPanel();						//JPanel 생성
		p0.setLayout(new GridLayout(4, 1));				//JPanel을 4*1의 GridLayout으로 설정
		p0.add(new JLabel("이 름"));						//JPanel에 JLabel 추가
		p0.add(new JLabel("학 번"));
		p0.add(new JLabel("전 공"));
		p0.add(new JLabel("연락처"));
		c.add(p0, BorderLayout.WEST);					//BorderLayout의 인덱스 위치에 JPanel추가
		
		JPanel p1 = new JPanel();						//JPanel 생성
		p1.setLayout(new GridLayout(4, 1));				//JPanel을 4*1의 GridLayout으로 설정
		tf1 = new JTextField(20);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		tf4 = new JTextField(20);
		p1.add(tf1);									//JPanel에 JTextField 추가
		p1.add(tf2);
		p1.add(tf3);
		p1.add(tf4);
		c.add(p1, BorderLayout.CENTER);					//BorderLayout의 인덱스 위치에 JPanel추가
		
		JPanel p2 = new JPanel();						//JPanel 생성
		btn1 = new JButton("확인");
		btn1.addActionListener(ml);
		btn2 = new JButton("취소");
		btn2.addActionListener(ml);
		p2.add(btn1);									//JPanel에 버튼 추가
		p2.add(btn2);
		c.add(p2, BorderLayout.SOUTH);					//BorderLayout의 인덱스 위치에 JPanel추가
		
		setVisible(true);								//프레임을 화면에 출력
	}
	
	//내부 클래스로 작성
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.contentEquals("확인")){					//버튼의 내용이 "확인"과 같다면
				//console창에 출력
				System.out.println(tf1.getText() + "\t" + tf2.getText() + "\t" + tf3.getText() +"\t"+ tf4.getText());
			}
			else if (s.contentEquals("취소")){			//버튼의 내용이 "취소"와 같다면	
				//JTextField 비우기
				tf1.setText(null);
				tf2.setText(null);
				tf3.setText(null);
				tf4.setText(null);
			}
		}
		
	}
	public static void main(String[] args) {
		new GuiTest();

	}

}
