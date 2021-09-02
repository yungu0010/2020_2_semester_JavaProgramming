import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class ItemCollections extends JFrame{
	//객체를 저장할 벡터, 각 탭마다 전체, 영화, 책, 검색 벡터 따로 생성
	static Vector<Item> all = new Vector<>();
	static Vector<Movie> m = new Vector<>();
	static Vector<Book> b = new Vector<>();
	static Vector<Item> s = new Vector<>();
	//사용할 다이얼로그 선언
	MyModalDialog d = new MyModalDialog(this, "");
	
	//벡터를 보여줄 JList, 각 탭마다 전체, 영화, 책, 검색 리스트 따로 생성
	static JList<Item> allList = new JList<>();
	static JList<Item> mList = new JList<>();
	static JList<Item> bList = new JList<>();
	static JList<Item> searchList = new JList<>();
	Movie movie;
	Book book;
	
	//파일 다이얼로그 선언
	private JFileChooser chooser = new JFileChooser();
	//파일 입출력시 사용
	FileOutputStream fos;
	FileInputStream fis;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	File file;
	
	//삭제
	public void delete(Item item) {
		if(item instanceof Movie) {			//item이 Movie일 때 m벡터에서 객체 삭제
			m.remove(item);
		}
		else if (item instanceof Book) {	//item이 Book일 때 b벡터에서 객체 삭제
			b.remove(item);
		}
		//all벡터에서 item 객체 삭제
		all.remove(item);
		//각 리스트 정보 업데이트
		allList.setListData(all);
		mList.setListData(m);
		bList.setListData(b);
		
	}
	
	//추가
	public void plus() {
		if(d.movie.isSelected()) {			//다이얼로그의 영화 버튼이 선택되어있을 때
			//영화 객체 생성
			movie = new Movie(d.name, d.makePeaple, d.year, d.imgPath, d.summary, d.comment, d.star, d.actor, d.genre, d.grade);
			//all과 m벡터에 영화 객체 추가
			m.add(movie);
			all.add(movie);
		}
		else if (d.book.isSelected()) {		//다이얼로그의 책 버튼이 선택되어있을 때
			//책 객체 생성
			book = new Book(d.name, d.makePeaple, d.year, d.imgPath, d.summary, d.comment, d.star, d.publisher);
			//all과 b벡터에 책 객체 추가
			b.add(book);
			all.add(book);
		}
		//각 리스트 정보 업데이트
		allList.setListData(all);
		mList.setListData(m);
		bList.setListData(b);
	}
	
	//수정
	public void modify(Item item) {
		//item의 값을 다이얼로그의 입력값으로 설정
		item.setName(d.tf[0].getText());
		item.setMakePeaple(d.tf[1].getText());
		item.setImgPath(d.imgtf.getText());
		item.setSummary(d.summaryta.getText());
		item.setComments(d.commentta.getText());
		String star = Integer.toString(d.slider.getValue());
		item.setStar(star);
		item.setYear(d.yearcb.getSelectedItem().toString());
		
		if(item instanceof Movie) {	//item이 Movie일 때 item 정보 설정
			((Movie) item).setActor(d.tf[2].getText());
			//장르,등급,개봉년도 수정
			((Movie) item).setGenre(d.genrecb.getSelectedItem().toString());
			((Movie) item).setRank(d.gradecb.getSelectedItem().toString());
		}
		else if (item instanceof Book) {	//item이 Book일 때 item 정보 설정
			((Book) item).setPublisher(d.tf[2].getText());
		}
		//각 리스트 정보 업데이트
		allList.setListData(all);
		mList.setListData(m);
		bList.setListData(b);
	}
	
	//제목 검색
	public void searchTitle(String str) {
		s.removeAllElements();		//s벡터의 모든 값 삭제
		for(int i =0; i<all.size(); i++) {			//전체 벡터 크기 동안 반복
			if(all.get(i).getName().contains(str))	//벡터의 이름이 str값을 포함하고 있으면
				s.add(all.get(i));					//s벡터에 추가
		}
		searchList.setListData(s);					//리스트의 정보 벡터s로  업데이트
	}
	//별점 검색
	public void searchStar(String str) {
		int star = Integer.parseInt(str);			//입력값 정수로 변환
		int istar;
		s.removeAllElements();						//s벡터의 모든 값 삭제
		for(int i =0; i<all.size(); i++) {			//전체 벡터 크기 동안 반복
			istar = Integer.parseInt(all.get(i).getStar());	//전체 벡터 안에 있는 객체의 별점값 저장
			if(istar>=star) {						//검색 값보다 크면
				s.add(all.get(i));					//s벡터에 추가
			}
		}
		searchList.setListData(s);					//리스트의 정보 벡터s로 업데이트
	}
	
	//불러오기
	public void open() {
		chooser.setCurrentDirectory(new File(".\\"));	//파일 다이얼로그의 경로는 현재 경로로
		//모든 벡터 초기화
		all.removeAllElements();
		m.removeAllElements();
		b.removeAllElements();
		s.removeAllElements();
		//showOpenDialog 생성
		int ret = chooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();			//파일 다이얼로그에서 선택된 값을 file에 저장
			try {
				//파일 불러오기
				fis = new FileInputStream(file);		
				ois = new ObjectInputStream(new FileInputStream(".\\" + file.getName()));
				Vector<Item> v = (Vector<Item>)ois.readObject();	//불러온 객체를 벡터 v에 저장
				for(int i=0; i<v.size(); i++) {
					all.add(v.get(i));								//벡터 v의 객체를 all에 모두 추가
					if(v.get(i) instanceof Movie) {					//객체가 Movie일 때 m에도 추가
						m.add((Movie) all.get(i));
					}
					else											//객체가 Book일 때 b에도 추가
						b.add((Book) all.get(i));
				}
				//각 리스트에 알맞는 벡터로 정보 업데이트
				allList.setListData(all);
				mList.setListData(m);
				bList.setListData(b);
				searchList.setListData(s);
			} catch (FileNotFoundException e1) {					//FileNotFoundException예외 처리
				e1.printStackTrace();
			} catch (IOException e1) {								//IOException 예외 처리
				e1.printStackTrace();
			}catch (ClassNotFoundException e1) {					//ClassNotFoundException 예외처리
				e1.printStackTrace();
			}
		}
		else if(ret != JFileChooser.APPROVE_OPTION) {	//파일을 선택하지 않았을 때 경고창 생성
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
	
	//저장
	public void save(){
		chooser.setCurrentDirectory(new File(".\\"));			//파일 다이얼로그의 경로는 현재 경로로
		chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
		int ret = chooser.showSaveDialog(null);
		file = chooser.getSelectedFile();						//파일 다이얼로그에서 선택된 값을 file에 저장
		if (ret == chooser.APPROVE_OPTION) {
			try {
				fos = new FileOutputStream(".\\" + file.getName());
				try {
					oos = new ObjectOutputStream(fos);			//파일 저장하기
					oos.writeObject(all);						//all객체를 모두 파일에 저장
					oos.flush();
					fos.close();
					oos.close();
				} catch (IOException e) {						//IOException 예외처리
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {					//FileNotFoundException 예외처리
				e.printStackTrace();
			}
			
		}
		else if (ret != JFileChooser.APPROVE_OPTION) {	//파일을 선택하지 않았을 때 경고창 생성
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
}