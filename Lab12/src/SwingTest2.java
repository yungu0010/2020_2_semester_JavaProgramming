import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class SwingTest2 extends JFrame {
	public JLabel lb = new JLabel("Text");
	MyModalDialog dialog = new MyModalDialog(this, "");
	
	public SwingTest2() {
		setTitle("Menu 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		createMenu();
		c.add(lb,BorderLayout.NORTH);
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setSize(10,10);
		lb.setToolTipText("편집에 따라 변경될 영역입니다");
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(2000);
		
		setSize(450, 400);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem [] fileItem = new JMenuItem[3];
		String[] fileTitle = {"열기", "저장", "종료"};
		JMenu fileMenu = new JMenu("파일");
		
		MenuActionListener listener = new MenuActionListener();
		for(int i =0; i<fileItem.length; i++) {
			fileItem[i] = new JMenuItem(fileTitle[i]);
			fileItem[i].addActionListener(listener);
			fileMenu.add(fileItem[i]);
			if (fileTitle[i].equals("저장")) {
				fileMenu.addSeparator();
			}
		}
		
		JMenuItem [] editItem = new JMenuItem[3];
		String[] editTitle = {"색 선택", "폰트", "텍스트 변경"};
		JMenu editMenu = new JMenu("편집");
		for(int i =0; i<editItem.length; i++) {
			editItem[i] = new JMenuItem(editTitle[i]);
			editItem[i].addActionListener(listener);
			editMenu.add(editItem[i]);
		}
		
		JMenu helpMenu = new JMenu("도움말");
		JMenuItem helpItem = new JMenuItem("버전 정보");
		helpItem.addActionListener(listener);
		helpMenu.add(helpItem);
		
		setJMenuBar(mb);
		
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(helpMenu);
	}
	
	class MenuActionListener implements ActionListener{
		private JFileChooser chooser = new JFileChooser();
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("종료")) {
				int exit =JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(exit == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			else if(cmd.equals("텍스트 변경")) {
				String text = JOptionPane.showInputDialog("변경할 텍스트를 입력하세요");
				if(text != null)
					lb.setText(text);
			}
			else if(cmd.equals("버전 정보")) {
				JOptionPane.showMessageDialog(null, "테스트 v1.0", "버전 정보", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(cmd.equals("열기")) {
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();
				lb.setText(filePath + "파일이 선택 되었습니다");
			}
			else if(cmd.equals("저장")) {
				int ret = chooser.showSaveDialog(null);
				String filePath2 = chooser.getSelectedFile().getPath();
				lb.setText(filePath2 + "파일에 저장 되었습니다");
			}
			else if(cmd.equals("색 선택")) {
				Color selectedColor = JColorChooser.showDialog(null, "색상 선택", Color.black);
				if(selectedColor != null)
					lb.setForeground(selectedColor);
			}
			else if(cmd.equals("폰트")) {
				dialog.setVisible(true);
			}
		}
		
	}
	class MyModalDialog extends JDialog{
		private JTextField tf = new JTextField(10);
		private JButton setting = new JButton("설정");
		private JLabel kinds, style, size;
		private JCheckBox bold, italic;
		private String [] cbfont = {"굴림", "돋움", "고딕", "명조"};
		JComboBox<String> combo = new JComboBox<String>(cbfont);
		
		Font font;
		int fontsize; 
		String fontset = "굴림";
		int fontStyle = font.PLAIN;
		
		public MyModalDialog(JFrame frame, String title) {
			super(frame, title, true);
			setLayout(new BorderLayout());
			
			actListener al = new actListener();
			MyListener ml = new MyListener();
			
			kinds = new JLabel("폰트 종류");
			style = new JLabel("폰트 스타일");
			size = new JLabel("폰트 크기");
			
			JPanel panelCombo = new JPanel();
			combo.addItemListener(ml);
			panelCombo.add(combo);
			
			JPanel panelStyle = new JPanel();					//JPanel 생성
			bold = new JCheckBox("bold");						//체크박스 생성
			bold.addItemListener(ml);
			italic = new JCheckBox("italic");
			italic.addItemListener(ml);
			panelStyle.add(bold);
			panelStyle.add(italic);
			
			JPanel panelCenter = new JPanel();
			panelCenter.setLayout(new GridLayout(3,2));
			panelCenter.add(kinds);
			panelCenter.add(panelCombo);
			panelCenter.add(style);
			panelCenter.add(panelStyle);
			panelCenter.add(size);
			panelCenter.add(tf);
			add(panelCenter, BorderLayout.CENTER);
			
			
			setting.addActionListener(al);
			add(setting, BorderLayout.SOUTH);
			setSize(250, 150);
		}
		class MyListener implements ItemListener{

			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = combo.getSelectedIndex();
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
					fontsize = Integer.parseInt(tf.getText());			//size의 값을 가져와 integer로 변환
					System.out.println("언애 하이");
				}
				catch(NumberFormatException ev){
					
				}
				
				lb.setFont(new Font(fontset, fontStyle, fontsize));
				dialog.setVisible(false);
			}		
		}

	}


	public static void main(String[] args) {
		new SwingTest2();

	}
}

