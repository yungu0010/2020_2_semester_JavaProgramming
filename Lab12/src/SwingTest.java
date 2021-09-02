import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTest extends JFrame {
	JLabel lb = new JLabel("Text");							//프레임에 표시될 JLabel
	MyModalDialog dialog = new MyModalDialog(this, "");		//폰트 메뉴 선택 시 사용할 다이얼로그
	
	public SwingTest() {
		setTitle("Menu 만들기 예제");							//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		Container c = getContentPane();
		
		createMenu();										//메뉴 생성
		c.add(lb,BorderLayout.NORTH);						//lb 위치 설정
		lb.setHorizontalAlignment(JLabel.CENTER);			//lb 가운데 맞춤
		lb.setSize(10,10);									//lb 크기 설정
		lb.setToolTipText("편집에 따라 변경될 영역입니다");			//lb 툴팁 추가
			
		//툴팁이 나타나는 시간 조정
		ToolTipManager m = ToolTipManager.sharedInstance();	
		m.setInitialDelay(0);								
		m.setDismissDelay(2000);
		
		setSize(350, 300);									//프레임의 크기 설정
		setVisible(true);									//프레임을 화면에 출력
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();						//JMenuBar 생성
		JMenuItem [] fileItem = new JMenuItem[3];			//JMenuItem 배열 생성
		String[] fileTitle = {"열기", "저장", "종료"};			//메뉴 이름 저장한 문자열 배열
		JMenu fileMenu = new JMenu("파일");					//JMenu 생성
		
		MenuActionListener listener = new MenuActionListener();	//리스너 생성
		for(int i =0; i<fileItem.length; i++) {
			fileItem[i] = new JMenuItem(fileTitle[i]);		//MenuItem 생성
			fileItem[i].addActionListener(listener);		//리스너 등록
			fileMenu.add(fileItem[i]);						//JMenu에 추가
			if (fileTitle[i].equals("저장")) {				//메뉴 이름이 "저장"이면 분리선 추가
				fileMenu.addSeparator();
			}
		}
		
		JMenuItem [] editItem = new JMenuItem[3];			//JMenuItem 배열 생성
		String[] editTitle = {"색 선택", "폰트", "텍스트 변경"};	//메뉴 이름 저장한 문자열 배열
		JMenu editMenu = new JMenu("편집");					//JMenu 생성
		for(int i =0; i<editItem.length; i++) {
			editItem[i] = new JMenuItem(editTitle[i]);		//MenuItem 생성
			editItem[i].addActionListener(listener);		//리스너 등록
			editMenu.add(editItem[i]);						//JMenu에 추가
		}
		
		JMenu helpMenu = new JMenu("도움말");					//JMenu 생성
		JMenuItem helpItem = new JMenuItem("버전 정보");		//JMenuItem 생성
		helpItem.addActionListener(listener);				//리스너 등록
		helpMenu.add(helpItem);								//JMenu에 추가
		
		//메뉴바에 생성한 메뉴 추가
		setJMenuBar(mb);
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(helpMenu);
	}
	
	class MenuActionListener implements ActionListener{
		private JFileChooser chooser = new JFileChooser();
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();				//선택 메뉴의 이름 저장
			if (cmd.equals("종료")) {							
				//showConfirmDialog 생성
				int exit =JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(exit == JOptionPane.YES_OPTION)			//예 선택 시 종료
					System.exit(0);
			}
			else if(cmd.equals("텍스트 변경")) {
				//showInputDialog 생성
				String text = JOptionPane.showInputDialog("변경할 텍스트를 입력하세요");
				if(text != null)
					lb.setText(text);						//lb값 입력된 값으로 변경
			}
			else if(cmd.equals("버전 정보")) {
				//showMessageDialog 생성, Information아이콘 설정
				JOptionPane.showMessageDialog(null, "테스트 v1.0", "버전 정보", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(cmd.equals("열기")) {
				//showOpenDialog 생성
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {	//파일을 선택하지 않았을 때 경고창 생성
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();	//파일 경로 저장
				lb.setText(filePath + "파일이 선택 되었습니다");				//lb값 출력
			}
			else if(cmd.equals("저장")) {
				//showSaveDialog 생성
				int ret = chooser.showSaveDialog(null);
				String filePath2 = chooser.getSelectedFile().getPath();	//저장 파일 경로 저장
				lb.setText(filePath2 + "파일에 저장 되었습니다");				//lb값 출력
			}
			else if(cmd.equals("색 선택")) {
				Color selectedColor = JColorChooser.showDialog(null, "색상 선택", Color.black);		//컬러 다이얼로그 생성
				if(selectedColor != null)
					lb.setForeground(selectedColor);					//선택한 색으로 변경
			}
			else if(cmd.equals("폰트")) {
				dialog.setVisible(true);								//다이얼로그 보이기
			}
		}
		
	}
	class MyModalDialog extends JDialog{
		//다이얼로그에 사용할 컴포넌트 선언
		private JTextField tf = new JTextField(10);
		private JButton setting = new JButton("설정");
		private JLabel kinds, style, size;
		private JCheckBox bold, italic;
		private String [] cbfont = {"굴림", "돋움", "고딕", "명조"};			//콤보 박스에 사용할 배열
		JComboBox<String> combo = new JComboBox<String>(cbfont);
		
		Font font;
		int fontsize; 
		String fontset = "굴림";
		int fontStyle = font.PLAIN;
		
		public MyModalDialog(JFrame frame, String title) {
			super(frame, title, true);									//모달 다이얼로그로 설정
			setLayout(new BorderLayout());								//레이아웃 설정
			
			actListener al = new actListener();							//액션 리스너 생성
			MyListener ml = new MyListener();							//아이템 리스너 생성
			
			//라벨 생성
			kinds = new JLabel("폰트 종류");			
			style = new JLabel("폰트 스타일");
			size = new JLabel("폰트 크기");
			
			JPanel panelCombo = new JPanel();							//콤보박스를 추가할 JPanel
			combo.addItemListener(ml);									//콤보 박스에 리스너 등록
			panelCombo.add(combo);										//JPanel에 콤보박스 추가
			
			JPanel panelStyle = new JPanel();							//JPanel 생성
			bold = new JCheckBox("bold");								//체크박스 생성, 체크박스에 리스너 등록
			bold.addItemListener(ml);
			italic = new JCheckBox("italic");
			italic.addItemListener(ml);
			panelStyle.add(bold);										//JPanel에 체크박스 추가
			panelStyle.add(italic);
			
			JPanel panelCenter = new JPanel();							//JPanel 생성
			panelCenter.setLayout(new GridLayout(3,2));					//GridLayout으로 설정
			panelCenter.add(kinds);										//컴포넌트 순서대로 추가
			panelCenter.add(panelCombo);
			panelCenter.add(style);
			panelCenter.add(panelStyle);
			panelCenter.add(size);
			panelCenter.add(tf);
			add(panelCenter, BorderLayout.CENTER);						//JPanel 위치 조정
			
			
			setting.addActionListener(al);								//버튼에 액션 리스너 등록
			add(setting, BorderLayout.SOUTH);							//버튼 위치 조정
			setSize(250, 150);											//사이즈 조정
		}
		class MyListener implements ItemListener{

			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = combo.getSelectedIndex();					//선택된 콤보박스 인덱스 값 저장
				//콤보박스 인덱스 값에 따라 fontset설정
				if(index == 0)
					fontset = "굴림";
				else if(index == 1)
					fontset = "돋움";
				else if(index == 2)
					fontset = "고딕";
				else if(index == 3)
					fontset = "명조";
				
				//체크박스 선택 여부에 따라 style의 값 재설정
				if (bold.isSelected() && (italic.isSelected() == false))
					fontStyle = font.BOLD;
				else if (italic.isSelected() && (bold.isSelected() == false))
					fontStyle = font.ITALIC;
				else if (italic.isSelected() && (bold.isSelected()))
					fontStyle = font.BOLD + font.ITALIC;
				else
					fontStyle = font.PLAIN;
				
			}
		}
		class actListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fontsize = Integer.parseInt(tf.getText());			//tf의 값을 가져와 integer로 변환
				}
				catch(NumberFormatException ev){						//입력값이 숫자가 아니면 fontsize 값 15로 저장 
					fontsize = 15;
				}
				
				lb.setFont(new Font(fontset, fontStyle, fontsize));		//lb의 폰트 재설정
				dialog.setVisible(false);								//다이얼로그 보이지 않게 하기
			}		
		}

	}


	public static void main(String[] args) {
		new SwingTest();

	}
}
