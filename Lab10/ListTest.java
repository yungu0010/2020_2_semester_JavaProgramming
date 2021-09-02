import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame{
	//사용할 변수, 벡터, 리스트 선언
	JTextField input, output;
	JList<String> list = new JList<>();
	JButton delete, modify;
	Vector<String> v = new Vector<String>();
	
	public ListTest() {
		setTitle("리스트 테스트");							//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(300,200);								//프레임 크기 설정
		Container c = getContentPane();
		c.setLayout(new BorderLayout(0, 0));			//레이아웃 설정
		
		JPanel panelTop = new JPanel();					//JPanel 생성
		input = new JTextField(28);						//JTextField 생성
		input.addActionListener(new ActionListener() {	//익명클래스로 리스너 등록
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();	//값 가져옴
				v.add(t.getText());							//벡터에 가져온 값 추가
				t.setText("");								//textField는 비워줌
				list.setListData(v);						//리스트에 벡터 내용 업데이트
			}
		});
		panelTop.add(input);								//panel에 추가
		c.add(panelTop, BorderLayout.NORTH);				//panelCenter는 borderLayout의 NORTH에 추가
		
		JPanel panelCenter = new JPanel();					//JPanel 생성
		list.setVisibleRowCount(5);
		list.setFixedCellWidth(280);
		list.addListSelectionListener(new ListListener());
		panelCenter.add(new JScrollPane(list));
		c.add(new JScrollPane(list), BorderLayout.CENTER);	//panelCenter는 borderLayout의 CENTER에 추가
		
		JPanel panelBottom = new JPanel();				//JPanel 생성
		panelBottom.setLayout(new FlowLayout());		//panelBottom의 레이아웃을 FlowLayout으로 설정
		output = new JTextField(13);					//JTextField생성
		modify = new JButton("수정");						//"수정"값을 가지는 JButton 생성
		modify.addActionListener(new MyListener());		//리스너 등록
		delete = new JButton("삭제");						//"삭제"값을 가지는 JButton 생성
		delete.addActionListener(new MyListener());		//리스너 등록
		panelBottom.add(output);						//panel에 컴포넌트 추가
		panelBottom.add(modify);
		panelBottom.add(delete);
		c.add(panelBottom, BorderLayout.SOUTH);			//panelCenter는 borderLayout의 SOUTH에 추가
		
		setVisible(true);								//프레임을 화면에 출력
	}
	
	
	class ListListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			String name = (String)list.getSelectedValue();	//목록에서 선택된 값
			
			int index = list.getSelectedIndex();			//선택된 리스트의 인덱스
			if(index == -1) {								//선택된 리스트가 없을 때
				output.setText("");							//output은 비워짐
			}
			else {											//선택된 리스트 인덱스가 있을 때
				output.setText(name);						//output값을 선택된 값으로 지정 
			}
			
		}
	}
	
	class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			int index = list.getSelectedIndex();		//선택된 리스트의 인덱스
			if(s.contentEquals("수정")){					//버튼의 내용이 "수정"과 같다면
				String temp = output.getText(); 		//output에 적힌 내용을 저장
				v.set(index, temp);						//벡터 인덱스값 수정
			}
			else if (s.contentEquals("삭제")){			//버튼의 내용이 "삭제"와 같다면
				v.remove(index);						//벡터 인덱스값 삭제
			}
			list.setListData(v);						//리스트 내용 수정된 벡터로 업데이트
		}
		
	}
	public static void main(String[] args) {
		new ListTest();

	}

}
