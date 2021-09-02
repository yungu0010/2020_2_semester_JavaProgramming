import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame{
	//사용할 변수 선언
	JPanel resultPanel;
	JRadioButton gullim, dodum, gungseo;
	JCheckBox bold, italic;
	JTextField size, text;
	JLabel result;
	//폰트 설정시 사용하는 변수 선언
	Font font;
	int fontsize; 
	String fontset = "굴림";
	int style = font.PLAIN;
	
	public FontTest() {
		setTitle("Font 설정");								//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//close 버튼을 눌렀을 때 실제 프로그램이 종료
		setSize(350,250);									//프레임 크기 설정
		Container c = getContentPane();
		c.setLayout(new BorderLayout());					//레이아웃 설정
		MyListener ml = new MyListener();					//리스너 선언
		actListener al = new actListener();		
		
		JPanel panelCenter = new JPanel();					//JPanel 생성
		panelCenter.setLayout(new GridLayout(4,2));			//JPanel의 레이아웃 설정
		
		JPanel panelFont = new JPanel();					//JPanel 생성
		ButtonGroup font = new ButtonGroup();				//라디오 버튼 그룹 생성
		gullim = new JRadioButton("굴림", true);				//라디오 버튼 생성, true로 하여 초기에 선택하도록 함
		gullim.addItemListener(ml);							//리스너 등록
		dodum = new JRadioButton("돋움");						//gullim과 같음
		dodum.addItemListener(ml);
		gungseo = new JRadioButton("궁서");
		gungseo.addItemListener(ml);
		font.add(gullim);									//라디오 버튼 그룹에 각각의 라디오 버튼 추가
		font.add(dodum);
		font.add(gungseo);
		panelFont.add(gullim);								//panel에 라디오 버튼 추가
		panelFont.add(dodum);
		panelFont.add(gungseo);
		
		JPanel panelStyle = new JPanel();					//JPanel 생성
		bold = new JCheckBox("BOLD");						//체크박스 생성
		bold.addItemListener(ml);							//리스너 등록
		italic = new JCheckBox("ITALIC");					//체크박스 생성
		italic.addItemListener(ml);							//리스너 등록
		panelStyle.add(bold);								//panel에 추가
		panelStyle.add(italic);
		
		JPanel panelSize = new JPanel();					//JPanel 생성
		size = new JTextField(15);							//textField 생성
		size.addActionListener(al);							//리스너 등록
		panelSize.add(size);								//panel에 추가
		
		JPanel panelText = new JPanel();					//JPanel 생성
		text = new JTextField(15);							//textField 생성
		text.addActionListener(al);							//리스너 등록
		panelText.add(text);								//panel에 추가

		//panelCenter에 지금까지 만든 것 그리드레이아웃에 맞춰 순서대로 추가
		panelCenter.add(new JLabel("Font 설정"));
		panelCenter.add(panelFont);
		panelCenter.add(new JLabel("Style 설정"));
		panelCenter.add(panelStyle);
		panelCenter.add(new JLabel("Size 설정"));
		panelCenter.add(panelSize);
		panelCenter.add(new JLabel("Text내용"));
		panelCenter.add(panelText);
		
		resultPanel = new JPanel();							//JPanel 생성
		Border resultBorder = BorderFactory.createTitledBorder("Font 설정 결과");	//테두리 설정
		resultPanel.setBorder(resultBorder);	
		result = new JLabel(text.getText());				//Label 생성
		resultPanel.add(result);							//Label panel에 추가
		
		c.add(panelCenter, BorderLayout.CENTER);			//panelCenter는 borderLayout의 CENTER에 추가
		c.add(resultPanel, BorderLayout.SOUTH);				//resultPanel은 borderLayout의 SOUTH에 추가
		
		setVisible(true);									//프레임을 화면에 출력
	}
	
	class MyListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			//선택된 라디오버튼에 따라 fontset변수값 지정
			if(gullim.isSelected())							
				fontset ="굴림";
			else if (dodum.isSelected()) 
				fontset = "돋움";
			else if (gungseo.isSelected())
				fontset = "궁서";
			//체크박스 선택 여부에 따라 style의 값 재설정
			if (bold.isSelected() && (italic.isSelected() == false))
				style = font.BOLD;
			else if (italic.isSelected() && (bold.isSelected() == false))
				style = font.ITALIC;
			else if (italic.isSelected() && (bold.isSelected()))
				style = font.BOLD + font.ITALIC;
			else
				style = font.PLAIN;
			
			//변수값을 가지고 폰트 지정
			result.setFont(new Font(fontset, style, fontsize));
		}
	}
	

	class actListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			fontsize = Integer.parseInt(size.getText());			//size의 값을 가져와 integer로 변환하여 fontsize에 저장
			result.setText(text.getText());							//text의 값을 가져와 result의 값으로 저장
			result.setFont(new Font(fontset, style, fontsize));		//폰트 재지정	
		}		
	}

	public static void main(String[] args) {
		new FontTest();
	}
}
