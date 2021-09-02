import java.awt.*;
import javax.swing.*;

public class StoryTest extends JFrame{
	public StoryTest() {
		setTitle("SM Story");							//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(350,200);								//프레임의 크기 설정
		
		Container c = getContentPane();
		c.setLayout(null);								//레이아웃을 null로 설정
		
		//절대위치는 실습 예제를 보고 임의로 작성함
		JLabel label0 = new JLabel("SM Story");			//label 생성
		label0.setLocation(15,15);						//label의 절대위치 지정
		label0.setSize(200,20);							//label 사이즈 설정
		c.add(label0);									//label 추가
		
		JLabel label1 = new JLabel("가을은");				//label 생성
		label1.setLocation(80,50);						//label의 절대위치 지정
		label1.setSize(200,20);							//label의 사이즈 설정
		c.add(label1);									//label 추가
			
		JTextField tf = new JTextField();				//textfield 생성
		tf.setLocation(145,85);							//textfield의 절대위치 지정
		tf.setSize(80,20);								//textfield의 사이즈 설정
		c.add(tf);										//textfield 추가
		
		JLabel label2 = new JLabel("이다");				//label 생성
		label2.setLocation(240,120);					//label의 절대위치 지정
		label2.setSize(200,20);							//label 사이즈 설정
		c.add(label2);									//label 추가
		
		setVisible(true);								//프레임을 화면에 출력	
	}
	public static void main(String[] args) {
		new StoryTest();

	}

}
