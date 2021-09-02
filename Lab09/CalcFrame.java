import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CalcFrame extends JFrame{
	Container c = getContentPane();
	JTextField num1, num2, result;
	JButton btn;
	JLabel lb;
	int count;
	
	public CalcFrame() {
		setTitle("계산기");								//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(400,250);								//프레임의 크기 설정
		
		c.setLayout(new FlowLayout());					//FlowLayout으로 설정
		
		MyListener ml = new MyListener();				//이벤트 리스너 생성
		
		//필요한 컴포넌트 생성
		num1 = new JTextField(5);						//JTextField 생성
		num2 = new JTextField(5);
		result = new JTextField(10);
		lb = new JLabel("X");							//JLabel 생성
		btn = new JButton("=");							//JButton 생성
		btn.addActionListener(ml);						//이벤트 리스너 등록
		
		//컴포넌트 추가
		c.add(num1);
		c.add(lb);
		c.add(num2);
		c.add(btn);
		c.add(result);
		
		setVisible(true);								//프레임을 화면에 출력
	}
	
	//내부 클래스로 작성
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o==btn) {  //객체 비교이므로 참조값이 같은지 비교
				//JTextField의 값을 integer로 바꾸어 계산
				count = Integer.valueOf(num1.getText())*Integer.valueOf(num2.getText());
				result.setText(""+count);		//result의 값 재지정
			}
		}	
	}

	public static void main(String[] args) {
		new CalcFrame();

	}

}
