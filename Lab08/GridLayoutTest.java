import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame{
	public GridLayoutTest() {
		setTitle("Ten uttons Frame");		//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(600, 300);					//프레임의 크기 설정
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 10));	//1*10의 Gridlayout설정
		
		for(int i=0; i<10; i++) {
			String n = Integer.toString(i);	//JButton에 숫자를 삽입하기 위해 String으로 변경
			c.add(new JButton(n));			//JButton 추가
		}

		setVisible(true);					//프레임을 화면에 출력
		
		/* 각 버튼의 배경색을 다르게 설정한 실습코드
		setTitle("Ten Color Buttons Frame");	//프레임의 이름 설정
		setSize(600, 300);						//프레임의 크기 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);//close버튼 눌렀을 때 실제 프로그램 종료
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));		//1*10의 Gridlayout설정
		
		//배열에 색을 저장
		Color[] col = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue,
							Color.magenta, Color.gray, Color.pink, Color.LIGHT_GRAY};
		for (int i=0; i<10; i++) {
		//
			String n = Integer.toString(i);		//JButton에 숫자를 삽입하기 위해 String으로 변경
			JButton button = new JButton(n);	//버튼 생성
			button.setOpaque(true);				//배경색 설정을 위한 코드
			button.setBackground(col[i]);		//JButton의 배경색을 col배열을 이용하여 결정
			c.add(button);						//컴포넌트 추가
			}
		setVisible(true);						//프레임을 화면에 출력
		*/
	}

	public static void main(String[] args) {
		new GridLayoutTest();

	}

}
