import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import java.util.Calendar;
import java.util.Vector;

public class MyNotes extends JFrame{
	
	JButton addbtn = new JButton("추가");
	JButton edit = new JButton("수정");
	JButton delete = new JButton("삭제");
	
	JTextField searchtf;
	JPanel info, panelLook;						//상세보기 패널과 라벨 부분
	panelImg pi = new panelImg();				//이미지를 출력할 패널
	JTextArea commentta, summaryta;				//줄거리와 감상평을 출력할 곳 
	JLabel [] jlb = new JLabel[14];				//상세보기 페이지의 라벨
	MyPanel1 mp = new MyPanel1();				//이미지가 없을 때 띄울 패널
	
	int index;
	Item item;
	ItemCollections ic = new ItemCollections();	//메소드 실행을 위한 선언
	
	//이미지를 출력할 때 사용할 ImageIcon과 Image
	ImageIcon icon;
	Image img;
	
	String [] search = {"제목", "별점"};			//검색 패널 콤보 박스에 사용할 배열
	JComboBox<String> searchcb = new JComboBox<String>(search);	
	
	public MyNotes() {
		setTitle("JAVA 004 1914062 강윤서");							//프레임의 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//close 버튼을 눌렀을 때 실제 프로그램이 종료
		Container c = getContentPane();
		MyActionListener ml = new MyActionListener();				//버튼 리스너 생성
		
		createMenu();												//메뉴 생성
		JPanel panelWest = new JPanel();
		JPanel panelAdd = new JPanel();								//추가 버튼 자리
		
		panelAdd.add(addbtn);										//"추가" 버튼 배치
		addbtn.addActionListener(ml);								//버튼에 리스너 등록
		panelWest.setLayout(new BorderLayout());					//레이아웃 설정
		JTabbedPane pane = createTabbedPane();						//탭 생성
		panelWest.add(pane, BorderLayout.CENTER);					//panelWest에 Center자리에 탭 추가
		panelWest.add(panelAdd, BorderLayout.SOUTH);				//panelWest에 South자리에 탭 추가
		
		allListener a = new allListener();							//리스트 리스너 생성
		mListener m = new mListener();
		bListener b = new bListener();
		searchListener s = new searchListener();
		ic.allList.addListSelectionListener(a);						//각 리스트에 리스너 추가
		ic.mList.addListSelectionListener(m);
		ic.bList.addListSelectionListener(b);
		ic.searchList.addListSelectionListener(s);
		
		JPanel panelTitle = new JPanel();							//상단 타이틀 부분의 panel 생성
		panelTitle.setLayout(new GridLayout(1, 2));
		JLabel mynotes = new JLabel("My Notes");					//JLabel 생성
		mynotes.setHorizontalAlignment(JLabel.CENTER);				//라벨 가운데 맞춤
		mynotes.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 25));		//폰트 지정
		mynotes.setForeground(Color.blue);							//색 지정
		MyLabel time = new MyLabel();								//현재시간 라벨 생성
		time.setHorizontalAlignment(JLabel.RIGHT);					//라벨 오른쪽 맞춤
		panelTitle.add(mynotes);									
		panelTitle.add(time);										//panel에 추가
		
		JPanel panelCenter = new JPanel();							//panelCenter 생성
		panelCenter.setLayout(new BorderLayout());
		
		JPanel panelDetail = new JPanel();							//상세보기 패널 생성
		panelDetail.setLayout(new GridLayout(3,1));
		Border Border = BorderFactory.createTitledBorder("상세 보기");	//테두리 설정
		panelDetail.setBorder(Border);
		
		panelLook = new JPanel();									//상단 정보 출력하는 panel 생성
		panelLook.setLayout(new GridLayout(1,2));
		info = new JPanel();										//정보출력 라벨 panel 생성
		info.setLayout(new GridLayout(7,2));						//레이아웃 설정
		
		for(int i =0; i<jlb.length; i++)							//정보출력 라벨에 필요한 라벨 생성
			jlb[i] = new JLabel();
		for(int i=0; i<jlb.length; i++)								//정보출력 라벨에 필요한 라벨 추가
			info.add(jlb[i]);
		
		panelLook.add(mp);											//panel에 요소 추가, mp는 이미지가 없을 때 띄우는 이미지 없음 panel
		panelLook.add(info);
		
		JPanel panelSummary = new JPanel();							//줄거리 출력하는 패널 생성
		Border summaryBd = BorderFactory.createTitledBorder("줄거리");	//테두리 설정
		panelSummary.setBorder(summaryBd);
		summaryta = new JTextArea(8, 60);
		summaryta.setLineWrap(true);							//가로 입력 고정
		JScrollPane scrollSmy = new JScrollPane(summaryta);		//스크롤바 추가, 가로 스크롤 없애기
		panelSummary.add(scrollSmy);
		
		JPanel panelComment = new JPanel();							//감상평을 출력하는 패널 생성
		Border commentBd = BorderFactory.createTitledBorder("감상평");	//테두리 설정
		panelComment.setBorder(commentBd);
		commentta = new JTextArea(8, 60);
		commentta.setLineWrap(true);							//가로 입력 고정
		JScrollPane scrollCmt = new JScrollPane(commentta);		//스크롤바 추가, 가로 스크롤 없애기
		panelComment.add(scrollCmt);
		
		panelDetail.add(panelLook);								//panelDetail에 각 패널 추가
		panelDetail.add(panelSummary);
		panelDetail.add(panelComment);

		JPanel button = new JPanel();							//수정과 삭제 버튼이 위치할 패널 생성
		edit.addActionListener(ml);								//벝튼 리스너 추가
		delete.addActionListener(ml);
		button.add(edit);										//버튼을 패널에 추가
		button.add(delete);
		
		panelCenter.add(panelDetail, BorderLayout.CENTER);		//panel 배치
		panelCenter.add(button, BorderLayout.SOUTH);

		c.add(panelTitle, BorderLayout.NORTH);					//전체 패널 배치
		c.add(panelWest, BorderLayout.WEST);
		c.add(panelCenter, BorderLayout.CENTER);
		setSize(1000, 800);										//프레임의 크기 설정
		setVisible(true);										//프레임을 화면에 출력
	}
	
	//메뉴 생성
	private void createMenu() {
		JMenuBar mb = new JMenuBar();							//JMenuBar 생성
		JMenuItem [] fileItem = new JMenuItem[3];				//JMenuItem 배열 생성
		String[] fileTitle = {"불러오기", "저장하기", "종료"};			//메뉴 이름 저장한 문자열 배열
		JMenu fileMenu = new JMenu("파일");						//JMenu 생성
		
		MenuActionListener listener = new MenuActionListener();	//메뉴리스너 생성
		for(int i =0; i<fileItem.length; i++) {
			fileItem[i] = new JMenuItem(fileTitle[i]);			//MenuItem 생성
			fileItem[i].addActionListener(listener);			//리스너 등록
			fileMenu.add(fileItem[i]);							//JMenu에 추가
			if (fileTitle[i].equals("저장하기")) {					//메뉴 이름이 "저장"이면 분리선 추가
				fileMenu.addSeparator();
			}
		}
		
		JMenu helpMenu = new JMenu("도움말");						//JMenu 생성
		JMenuItem helpItem = new JMenuItem("시스템 정보");			//JMenuItem 생성
		helpItem.addActionListener(listener);					//리스너 등록
		helpMenu.add(helpItem);									//JMenu에 추가
		
		//메뉴바에 생성한 메뉴 추가
		setJMenuBar(mb);		
		mb.add(fileMenu);
		mb.add(helpMenu);
	}
	
	//탭 생성
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP);
		MyActionListener sml = new MyActionListener();			//검색 버튼을 위한 리스너 생성
		
		JPanel p4 = new JPanel();								
		p4.setLayout(new BorderLayout());
		JPanel p4Top = new JPanel();							//검색 탭의 컴포넌트 배치를 위한 패널 생성
		searchtf = new JTextField(10);							//검색어 입력창
		JButton searchbtn = new JButton("검색");					//검색버튼 생성
		searchbtn.addActionListener(sml);						//리스너 등록
		p4Top.add(searchcb);									//컴포넌트 배치
		p4Top.add(searchtf);
		p4Top.add(searchbtn);
		p4.add(p4Top, BorderLayout.NORTH);
		p4.add(ic.searchList, BorderLayout.CENTER);				//검색결과 리스트 배치
		
		//탭을 순서대로 추가, 각 List는 전체, 영화, 책, 검색 탭 순
		pane.addTab("전체", ic.allList);
		pane.addTab("영화", ic.mList);
		pane.addTab("도서", ic.bList);
		pane.addTab("검색", p4);
		return pane;
	}
	
	//allList. mList, bList, searchList 각각의 리스너, 기능은 같음
	public class allListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			index = ic.allList.getSelectedIndex();				//현재 리스너에 선택된 아이템 인덱스 반환
			if(index != -1) {
				item = ic.all.get(index);						//인덱스로 벡터에서 객체 가져와 item에 저장
				//item 값에 따른 라벨값 지정
				jlb[0].setText("제목");
				jlb[1].setText(item.getName());
				jlb[3].setText(item.getMakePeaple());
				commentta.setText(item.getComments());
				summaryta.setText(item.getSummary());
				//선택한 객체가 Movie인 경우 라벨값
				if(item instanceof Movie) {
					jlb[2].setText("감독");
					jlb[4].setText("배우");
					jlb[5].setText(((Movie) item).getActor());
					jlb[6].setText("장르");
					jlb[7].setText(((Movie) item).getGenre());
					jlb[8].setText("등급");
					jlb[9].setText(((Movie) item).getRank());
					jlb[10].setText("개봉년도");
					jlb[11].setText(item.getYear());
					jlb[12].setText("별점");
					jlb[13].setText(item.getStar());
					//Movie일 때만 보이도록 함
					jlb[10].setVisible(true);
					jlb[11].setVisible(true);
					jlb[12].setVisible(true);
					jlb[13].setVisible(true);
				}
				//선택한 객체가 Book인 경우 라벨값
				else if(item instanceof Book){
					jlb[2].setText("저자");
					jlb[4].setText("출판사");
					jlb[5].setText(((Book) item).getPublisher());
					jlb[6].setText("출판년도");
					jlb[7].setText(item.getYear());
					jlb[8].setText("별점");
					jlb[9].setText(item.getStar());
					//Book인 경우에는 숨기도록 함
					jlb[10].setVisible(false);
					jlb[11].setVisible(false);
					jlb[12].setVisible(false);
					jlb[13].setVisible(false);
				}
				//이미지를 출력하기 위한 이미지 객체 생성 및 img 값 지정
				icon = new ImageIcon(item.getImgPath());
				img = icon.getImage();
			}
			else {}			//인덱스가 없을 때 아무것도 일어나지 않음
			//상세보기 페이지 재배치
			panelLook.remove(mp);
			panelLook.remove(info);
			panelLook.add(pi);
			panelLook.add(info);
		}
	}
	public class mListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			index = ic.mList.getSelectedIndex();				//현재 리스너에 선택된 아이템 인덱스 반환
			if(index != -1) {
				item = ic.m.get(index);							//인덱스로 벡터에서 객체 가져와 item에 저장
				//item 값에 따른 라벨값 지정
				info.setLayout(new GridLayout(7,2));
				jlb[0].setText("제목");
				jlb[1].setText(item.getName());
				jlb[2].setText("감독");
				jlb[3].setText(item.getMakePeaple());
				jlb[10].setText("개봉년도");
				jlb[11].setText(item.getYear());
				jlb[12].setText("별점");
				jlb[13].setText(item.getStar());
				commentta.setText(item.getComments());
				summaryta.setText(item.getSummary());
				//선택한 객체가 Movie인 경우 라벨값
				if(item instanceof Movie){
					jlb[4].setText("배우");
					jlb[5].setText(((Movie) item).getActor());
					jlb[6].setText("장르");
					jlb[7].setText(((Movie) item).getGenre());
					jlb[8].setText("등급");
					jlb[9].setText(((Movie) item).getRank());
					//Movie일 때만 보이도록 함
					jlb[10].setVisible(true);
					jlb[11].setVisible(true);
					jlb[12].setVisible(true);
					jlb[13].setVisible(true);
					//이미지를 출력하기 위한 이미지 객체 생성 및 img 값 지정
					icon = new ImageIcon(item.getImgPath());
					img = icon.getImage();
				}
			}
			else{}		//인덱스가 없을 때 아무것도 일어나지 않음
			//상세보기 페이지 재배치
			panelLook.remove(mp);
			panelLook.remove(info);
			panelLook.add(pi);
			panelLook.add(info);
		}
	}
	public class bListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			index = ic.bList.getSelectedIndex();				//현재 리스너에 선택된 아이템 인덱스 반환
			if(index != -1) {
				item = ic.b.get(index);							//인덱스로 벡터에서 객체 가져와 item에 저장
				//item 값에 따른 라벨값 지정
				jlb[0].setText("제목");
				jlb[1].setText(item.getName());
				jlb[2].setText("저자");
				jlb[3].setText(item.getMakePeaple());
				commentta.setText(item.getComments());
				summaryta.setText(item.getSummary());
				//선택한 객체가 Book인 경우 라벨값
				if(item instanceof Book) {
					jlb[4].setText("출판사");
					jlb[5].setText(((Book) item).getPublisher());
					jlb[6].setText("출판년도");
					jlb[7].setText(item.getYear());
					jlb[8].setText("별점");
					jlb[9].setText(item.getStar());
					//Book인 경우에는 숨기도록 함
					jlb[10].setVisible(false);
					jlb[11].setVisible(false);
					jlb[12].setVisible(false);
					jlb[13].setVisible(false);
					//이미지를 출력하기 위한 이미지 객체 생성 및 img 값 지정
					icon = new ImageIcon(item.getImgPath());
					img = icon.getImage();
				}
			}
			else {}		//인덱스가 없을 때 아무것도 일어나지 않음
			//상세보기 페이지 재배치
			panelLook.remove(mp);
			panelLook.remove(info);
			panelLook.add(pi);
			panelLook.add(info);
		}
	}
	public class searchListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			index = ic.searchList.getSelectedIndex();			//현재 리스너에 선택된 아이템 인덱스 반환
			if(index != -1) {
				item = ic.s.get(index);							//인덱스로 벡터에서 객체 가져와 item에 저장
				//item 값에 따른 라벨값 지정
				jlb[0].setText("제목");
				jlb[1].setText(item.getName());
				jlb[3].setText(item.getMakePeaple());
				commentta.setText(item.getComments());
				summaryta.setText(item.getSummary());
				//선택한 객체가 Movie인 경우 라벨값
				if(item instanceof Movie) {
					info.setLayout(new GridLayout(7,2));
					jlb[2].setText("감독");
					jlb[4].setText("배우");
					jlb[5].setText(((Movie) item).getActor());
					jlb[6].setText("장르");
					jlb[7].setText(((Movie) item).getGenre());
					jlb[8].setText("등급");
					jlb[9].setText(((Movie) item).getRank());
					jlb[10].setText("개봉년도");
					jlb[11].setText(item.getYear());
					jlb[12].setText("별점");
					jlb[13].setText(item.getStar());
					//Movie일 때만 보이도록 함
					jlb[10].setVisible(true);
					jlb[11].setVisible(true);
					jlb[12].setVisible(true);
					jlb[13].setVisible(true);
				}
				//선택한 객체가 Book인 경우 라벨값
				else if(item instanceof Book){
					jlb[2].setText("저자");
					jlb[4].setText("출판사");
					jlb[5].setText(((Book) item).getPublisher());
					jlb[6].setText("출판년도");
					jlb[7].setText(item.getYear());
					jlb[8].setText("별점");
					jlb[9].setText(item.getStar());
					//Book인 경우에는 숨기도록 함
					jlb[10].setVisible(false);
					jlb[11].setVisible(false);
					jlb[12].setVisible(false);
					jlb[13].setVisible(false);
				}
				//이미지를 출력하기 위한 이미지 객체 생성 및 img 값 지정
				icon = new ImageIcon(item.getImgPath());
				img = icon.getImage();
			}
			else {}		//인덱스가 없을 때 아무것도 일어나지 않음
			//상세보기 페이지 재배치
			panelLook.remove(mp);
			panelLook.remove(info);
			panelLook.add(pi);
			panelLook.add(info);
		}
	}
	class panelImg extends JPanel{			//객체의 이미지를 보여줄 때 사용할 패널
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);	
			repaint();						//다시 그리기
		}	
	}

	//추가, 수정, 삭제 리스너
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			//버튼에 값에 따라 if 문으로 나눔
			if(b.getText().equals("추가")) {			
				//입력값 초기화
				for(int i=0; i<3; i++) {
					ic.d.tf[i].setText("");
				}
				//추가 버튼을 누르면 다이얼로그창 초기화
				ic.d.movie.setSelected(true);
				ic.d.imgtf.setText("");
				ic.d.summaryta.setText("");
				ic.d.commentta.setText("");
				
				ic.d.slider.setValue(5);
				ic.d.genrecb.setSelectedIndex(0);
				ic.d.yearcb.setSelectedIndex(0);
				ic.d.gradecb.setSelectedIndex(0);
				
				//다이얼로그창 띄우기
				ic.d.setVisible(true);
				//추가하는 메소드 실행
				ic.plus();
			}
			else if(b.getText().equals("수정")) {	
				//버튼 값이 수정일 때 item값으로 입력값 세팅
				ic.d.tf[0].setText(item.getName());
				ic.d.tf[1].setText(item.getMakePeaple());
				ic.d.imgtf.setText(item.getImgPath());
				ic.d.summaryta.setText(item.getSummary());
				ic.d.commentta.setText(item.getComments());
				int star = Integer.parseInt(item.getStar());
				ic.d.slider.setValue(star);
				ic.d.yearcb.setSelectedItem(item.getYear());
				//item이 Movie일 때 설정
				if(item instanceof Movie) {	
					ic.d.movie.setSelected(true);
					ic.d.tf[2].setText(((Movie) item).getActor());
					ic.d.genrecb.setSelectedItem(((Movie) item).getGenre());
					ic.d.gradecb.setSelectedItem(((Movie) item).getRank());
				}
				//item이 Book일 때 설정
				else if (item instanceof Book) {
					ic.d.tf[2].setText(((Book) item).getPublisher());
					ic.d.book.setSelected(true);		
					ic.d.genrecb.setSelectedIndex(0);
					ic.d.gradecb.setSelectedIndex(0);
				}
				//다이얼로그창 띄우기
				ic.d.setVisible(true);
				ic.modify(item);			//수정 메소드 호출
				//상세보기 페이지에 수정된 item값 재설정
				jlb[0].setText("제목");
				jlb[1].setText(item.getName());
				jlb[3].setText(item.getMakePeaple());
				commentta.setText(item.getComments());
				summaryta.setText(item.getSummary());
				if(item instanceof Movie) {
					info.setLayout(new GridLayout(7,2));
					jlb[2].setText("감독");
					jlb[4].setText("배우");
					jlb[5].setText(((Movie) item).getActor());
					jlb[6].setText("장르");
					jlb[7].setText(((Movie) item).getGenre());
					jlb[8].setText("등급");
					jlb[9].setText(((Movie) item).getRank());
					jlb[10].setText("개봉년도");
					jlb[11].setText(item.getYear());
					jlb[12].setText("별점");
					jlb[13].setText(item.getStar());
					jlb[10].setVisible(true);
					jlb[11].setVisible(true);
					jlb[12].setVisible(true);
					jlb[13].setVisible(true);
				}
				else if(item instanceof Book){
					jlb[2].setText("저자");
					jlb[4].setText("출판사");
					jlb[5].setText(((Book) item).getPublisher());
					jlb[6].setText("출판년도");
					jlb[7].setText(item.getYear());
					jlb[8].setText("별점");
					jlb[9].setText(item.getStar());
					jlb[10].setVisible(false);
					jlb[11].setVisible(false);
					jlb[12].setVisible(false);
					jlb[13].setVisible(false);
				}
					
				icon = new ImageIcon(item.getImgPath());
				img = icon.getImage();
			}
			//버튼 값이 삭제 일 때
			else if(b.getText().equals("삭제")) {
				//showConfirmDialog 생성
				int deleteOP =JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
				if(deleteOP == JOptionPane.YES_OPTION) { //확인버튼을 눌렀을 때
					ic.delete(item);					//삭제 메소드 생성
					for(int i=0; i<jlb.length; i++)		//상세보기 JLabel 초기화
						jlb[i].setText("");
				}
			}
			//버튼 값이 검색일 때
			else if(b.getText().equals("검색")) {
				String str = searchtf.getText();		//검색창에서 받아온 값 저장
				if(searchcb.getSelectedIndex()==0) {	//제목 검색일 경우
					ic.searchTitle(str);				//제목 검색 메소드 호출
				}
				else {
					ic.searchStar(str);					//별점 검색 메소드 호출
				}
			}
		}
	}
		public static void main(String[] args) {
		new MyNotes();
	}
}