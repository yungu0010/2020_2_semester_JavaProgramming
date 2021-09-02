import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class SliderTest extends JFrame {
	//사용할 컴포넌트와 변수 선언
	JTextArea ta;
	JSlider slider;
	int val;
	public SliderTest(){
		setTitle("TextArea Practice Frame");				//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(350,200);									//프레임 크기 설정
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,1));					//레이아웃 설정, 2*1 그리드 레이아웃
		
		JTextArea ta = new JTextArea(5, 28);				//문자열을 입력할 JTextArea생성
		ta.addKeyListener(new textAreaListener());			//ta에 KeyListener 등록
		ta.setLineWrap(true);
		
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);	//slider 생성
		slider.setPaintLabels(true);							//label 보이기
		slider.setPaintTicks(true);								//tick 보이기
		slider.setPaintTrack(true);								//track 보이기
		slider.setMajorTickSpacing(20);							//큰 눈금 간격 지정
		slider.setMinorTickSpacing(5);							//작은 눈금 간격 지정
		slider.addChangeListener(new ChangeListener() {			//익명 클래스로 리스너 등록
			@Override
			public void stateChanged(ChangeEvent e) {
				if(ta.getText().length() <=slider.getValue()) {	//slider의 값보다 textArea의 길이가 작거나 같으면
					slider.setValue(ta.getText().length());		//sldier의 값은 textArea의 길이로 설정
				}
				else {
					try {										//오류가 발생하여 예외처리 해줌
						ta.setText(ta.getText(0, slider.getValue())); 	//ta의 값을 0에서 slider의 값 만큼만 보이도록 지정
					} catch (BadLocationException e1) {}
				}
				
			}
		});
		
		c.add(ta);											//컴포넌트 추가
		c.add(slider);
		
		setVisible(true);									//프레임을 화면에 출력
	}
	class textAreaListener extends KeyAdapter{
		public void keyTyped(KeyEvent e) {
			JTextArea ta = (JTextArea)e.getSource();
			int size = ta.getText().length();				//ta의 길이를 저장
			try {
				if(size>=100)								//길이가 100이상이면
					ta.setText(ta.getText(0, 100));			//ta에 100자만 쓸 수 있도록 지정
			}catch(BadLocationException ex) {}				//예외처리를 해주지 않으면 오류가 발생하여 예외처리해줌
			slider.setValue(size);							//slider의 값을 size로 지정
		}
	}
	
	public static void main(String[] args) {
		new SliderTest();

	}

}
