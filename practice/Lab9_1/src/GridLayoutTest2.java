import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;

public class GridLayoutTest2 extends JFrame{
	public GridLayoutTest2(){
		setTitle("Ten Color Buttons Frame");	//프레임의 이름 설정
		setSize(600, 300);						//프레임의 크기 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);//close버튼 눌렀을 때 실제 프로그램 종료
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));
		
		Color[] col = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue,
				Color.magenta, Color.gray, Color.pink, Color.LIGHT_GRAY};
		
		for (int i=0; i<10; i++) {
			String n = Integer.toString(i);
			JButton button = new JButton(n);
			button.setOpaque(true);				//배경색 설정을 위한 코드
			button.setBackground(col[i]);		//JButton의 배경색을 col배열을 이용하여 결정
			c.add(button);						//컴포넌트 추가
			}
		setVisible(true);		//프레임을 화면에 출력
		}
	public static void main(String[] args) {
		new GridLayoutTest2();

	}

}
