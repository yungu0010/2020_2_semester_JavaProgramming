import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;

class MyModalDialog extends JDialog{
	//다이얼로그에 사용할 컴포넌트 선언
	JRadioButton movie, book;
	String [] genreStr = {"드라마", "미스터리, 스릴러", "범죄", "애니매이션", "액션"};			//콤보 박스에 사용할 배열
	String [] gradeStr = {"전체", "12세 이상", "15세 이상", "청소년 관람 불가"};				//콤보 박스에 사용할 배열
	String [] lbStrM = {"제목", "감독", "배우", "장르", "등급", "개봉년도", "포스터", "별점", "줄거리", "감상평"};
	String [] lbStrB= {"제목", "저자", "출판사", "출판년도", "책이미지", "별점", "책소개", "감상평", "", ""};
	
	//체크박스 생성
	JComboBox<String> genrecb = new JComboBox<String>(genreStr);
	JComboBox<String> gradecb = new JComboBox<String>(gradeStr);
	JComboBox<Integer> yearcb = new JComboBox<Integer>();
	
	//slider 생성
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);	
	
	JLabel [] lb = new JLabel[10];
	JTextField [] tf = new JTextField[3];
	JTextField imgtf = new JTextField();
	JTextArea summaryta, commentta;
	
	JButton okbtn = new JButton("Ok");
	JButton imgbtn = new JButton("불러오기");
	
	JPanel panelInfo = new JPanel();
	JPanel panelContent = new JPanel();
	JPanel panelImg = new JPanel();
	JPanel summarypn = new JPanel();
	JPanel commentpn = new JPanel();
	
	Border Border1 = BorderFactory.createTitledBorder("영화 정보");	//테두리 설정
	Border Border2 = BorderFactory.createTitledBorder("도서 정보");	//테두리 설정
	
	//저장할 변수
	String name, makePeaple, summary, comment, imgPath;
	public String actor, genre, grade, year, publisher;
	public String star;
	

	public MyModalDialog(JFrame frame, String title) {
		super(frame, title, true);									//모달 다이얼로그로 설정
		setLayout(new BorderLayout());								//레이아웃 설정
		
		//JLabel 생성
		for(int i=0; i<10; i++) {
			lb[i] = new JLabel();
			lb[i].setText(lbStrM[i]);	
		}
		
		//textfield 생성
		for(int i=0; i<3; i++) {
			tf[i] = new JTextField();
		}
		
		//textarea 생성
		summaryta = new JTextArea(2, 20);
		summaryta.setLineWrap(true);							//가로 입력 고정
		JScrollPane scroll1 = new JScrollPane(summaryta);		//스크롤바 추가
		summarypn.add(scroll1);
		commentta = new JTextArea(2, 20);
		commentta.setLineWrap(true);							//가로 입력 고정
		JScrollPane scroll2 = new JScrollPane(commentta);		//스크롤바 추가
		commentpn.add(scroll2);
		
		//slider 생성
		slider.setPaintLabels(true);							//label 보이기
		slider.setPaintTicks(true);								//tick 보이기
		slider.setPaintTrack(true);								//track 보이기
		slider.setMajorTickSpacing(1);							//큰 눈금 간격 지정
		
		//년도 콤보박스 생성
		for(int i=2020; i>1999; i--)
			yearcb.addItem(i);
		
		//이미지 불러오기 기능
		ImgButtonListener imgl = new ImgButtonListener();		//버튼 리스너 생성
		imgtf = new JTextField(10);								//이미지 경로값을 적을 textfield
		imgtf.setEditable(false);								//직접 입력하지 못하도록 수정
		imgbtn.addActionListener(imgl);							//버튼 리스너 등록
		panelImg.add(imgtf);									//컴포넌트
		panelImg.add(imgbtn);
		
		JPanel panelTop = new JPanel();							//라디오 버튼를 추가할 JPanel
		ButtonGroup g = new ButtonGroup();						//라디오 버튼의 그룹 생성
		MyItemListener il = new MyItemListener();				//버튼 리스너 생성
		movie = new JRadioButton("movie");							
		movie.setSelected(true);								//영화 버튼을 기본 선택으로 지정
		movie.addItemListener(il);								//리스너 등록
		book = new JRadioButton("book");
		book.addItemListener(il);								//리스너 등록
		g.add(movie);											//라디오 그룹에 라디오 버튼 추가
		g.add(book);
		panelTop.add(movie);									//JPanel에 라디오 버튼 추가
		panelTop.add(book);
		
		for(int i=0; i<10; i++) {								//info패널에 lb 추가
			panelInfo.add(lb[i]);
		}
		
		okbtnListener ol = new okbtnListener();					//ok버튼 리스너 생성과 등록
		okbtn.addActionListener(ol);
		
		panelInfo.setBorder(Border1);
		panelContent.setLayout(new GridLayout(10, 2));
		panelContent.add(lb[0]);		//제목
		panelContent.add(tf[0]);
		panelContent.add(lb[1]);		//감독
		panelContent.add(tf[1]);
		panelContent.add(lb[2]);		//배우
		panelContent.add(tf[2]);
		panelContent.add(lb[3]);		//장르
		panelContent.add(genrecb);
		panelContent.add(lb[4]);		//등급
		panelContent.add(gradecb);
		panelContent.add(lb[5]);		//개봉년도
		panelContent.add(yearcb);
		panelContent.add(lb[6]);		//이미지
		panelContent.add(panelImg);
		panelContent.add(lb[7]);		//별점
		panelContent.add(slider);
		panelContent.add(lb[8]);		//책소개
		panelContent.add(summarypn);
		panelContent.add(lb[9]);		//감상평
		panelContent.add(commentpn);
		
		//패널 배치
		panelInfo.add(panelContent, BorderLayout.CENTER);	
		panelInfo.add(okbtn, BorderLayout.SOUTH);
		
		//ok버튼에 익명 리스너 추가
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);		//다이얼로그 보이지 않게 설정
			}
			
		});
		
		//다이얼로그의 전체 구성에 맞게 패널 추가
		add(panelTop, BorderLayout.NORTH);	
		add(panelInfo, BorderLayout.CENTER);
		
		setSize(450, 650);	//사이즈 설정
	}
	
	//영화, 책 탭 변환
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(movie.isSelected()) {			//영화 버튼이 선택되어있을 때
				for(int i=0; i<10; i++) {
					lb[i].setText(lbStrM[i]);	//라벨 값을 lbStrM으로 순차적 지정
				}
				panelContent.remove(lb[3]);		//출판년도
				panelContent.remove(yearcb);
				panelContent.remove(lb[4]);		//책이미지
				panelContent.remove(panelImg);
				panelContent.remove(lb[5]);		//별점
				panelContent.remove(slider);
				panelContent.remove(lb[6]);		//책소개
				panelContent.remove(summarypn);
				panelContent.remove(lb[7]);		//감상평
				panelContent.remove(commentpn);
				
				panelContent.add(lb[3]);		//장르
				panelContent.add(genrecb);
				panelContent.add(lb[4]);		//등급
				panelContent.add(gradecb);
				panelContent.add(lb[5]);		//개봉년도
				panelContent.add(yearcb);
				panelContent.add(lb[6]);		//이미지
				panelContent.add(panelImg);
				panelContent.add(lb[7]);		//별점
				panelContent.add(slider);
				panelContent.add(lb[8]);		//책소개
				panelContent.add(summarypn);
				panelContent.add(lb[9]);		//감상평
				panelContent.add(commentpn);
				
				panelInfo.setBorder(Border1);	//테두리 설정
			}	
			else if (book.isSelected()) {		//책 버튼이 선택되어있을 때
				for(int i=0; i<10; i++) {
					lb[i].setText(lbStrB[i]);	//라벨 값을 lbStrM으로 순차적 지정
				}
				panelContent.remove(lb[3]);		//장르
				panelContent.remove(genrecb);
				panelContent.remove(lb[4]);		//등급
				panelContent.remove(gradecb);
				panelContent.remove(lb[5]);		//개봉년도
				panelContent.remove(yearcb);
				panelContent.remove(lb[6]);		//이미지
				panelContent.remove(panelImg);
				panelContent.remove(lb[7]);		//별점
				panelContent.remove(slider);
				panelContent.remove(lb[8]);		//책소개
				panelContent.remove(summarypn);
				panelContent.remove(lb[9]);		//감상평
				panelContent.remove(commentpn);
				
				panelContent.add(lb[3]);		//출판년도
				panelContent.add(yearcb);
				panelContent.add(lb[4]);		//책이미지
				panelContent.add(panelImg);
				panelContent.add(lb[5]);		//별점
				panelContent.add(slider);
				panelContent.add(lb[6]);		//책소개
				panelContent.add(summarypn);
				panelContent.add(lb[7]);		//감상평
				panelContent.add(commentpn);
				
				panelInfo.setBorder(Border2);	//테두리 설정
			}
		}	
	}
	
	//이미지 불러오기
	class ImgButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();	//파일 다이얼로그 생성
			chooser.setCurrentDirectory(new File(".\\images"));	//초기 경로는 현재 경로의 이미지 폴더
			JButton b = (JButton)e.getSource();
			//showOpenDialog 생성
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {	//파일을 선택하지 않았을 때 경고창 생성
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String fileName = chooser.getSelectedFile().getName();
			String filePath = "images/"+fileName;	//파일 경로 저장
			imgtf.setText(filePath);				//텍스트필드에 경로 입력
			}
		}
	
	//ok버튼 리스너
	class okbtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int index=0;	//체크박스의 값을 가져올 때 사용
			//다이얼로그에 입력된 값 각 변수에 저장
			name = tf[0].getText();
			makePeaple = tf[1].getText();
			year = yearcb.getSelectedItem().toString();	
			imgPath = imgtf.getText();
			summary = summaryta.getText();
			comment = commentta.getText();
			String star1 = Integer.toString(slider.getValue());
			star = star1;
			
			if(movie.isSelected()) {		//영화 버튼이 선택되어있을 때
				//필요한 변수에 값 저장
				actor = tf[2].getText();
				index = genrecb.getSelectedIndex();
				genre = genreStr[index];
				index = gradecb.getSelectedIndex();
				grade = gradeStr[index];
			}
			else if (book.isSelected()) {	//책 버튼이 선택되어있을 때
				publisher = tf[2].getText();	//필요한 변수에 값 저장
			}		
		}
	}
}