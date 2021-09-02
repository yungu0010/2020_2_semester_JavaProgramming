import java.awt.*;
import javax.swing.*;

public class GridTest extends JFrame{
	public GridTest() {		
		setTitle("Grid TEST");					//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(500, 250);						//프레임의 크기 설정
		GridLayout grid = new GridLayout(5, 4);	//5*4인 GridLayout 생성
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());		//레이아웃을 BorderLayout으로 설정
		
		JPanel j0 = new JPanel();				//JPanel 생성, panel은 기본적으로 flowlayout인데 flowlayout 정렬의 default는 가운데이다.
		j0.add(new JLabel("학생 정보 입력"));		//JPanel에 JLabel 추가
		c.add(j0, BorderLayout.NORTH);			//BorderLayout의 인덱스 위치에 JPanel추가
		
		JPanel j1 = new JPanel();				//JPanel 생성
		j1.setLayout(grid);						//JPanel의 layout을 grid로 설정
		j1.add(new JLabel("이 름"));				//순서대로 JLabel 추가
		j1.add(new JLabel("학 번"));
		j1.add(new JLabel("학 과"));
		j1.add(new JLabel("연락처"));
		
		for (int i=0; i<16; i++) {
			j1.add(new JTextField());			//JTextField 추가
		}
		c.add(j1, BorderLayout.CENTER);			//BorderLayout의 인덱스 위치에 JPanel추가
		 
		JPanel j2 = new JPanel();				//JPanel 생성
		j2.add(new JButton("추가"));				//JPanel에 버튼 추가
		j2.add(new JButton("취소"));
		c.add(j2, BorderLayout.SOUTH);			//BorderLayout의 인덱스 위치에 JPanel추가
		setVisible(true);						//프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new GridTest();

	}

}
