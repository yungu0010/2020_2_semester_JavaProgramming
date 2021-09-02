import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

class MenuActionListener implements ActionListener{
		ItemCollections ic = new ItemCollections();			//메소드 실행을 위한 선언 
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();				//선택 메뉴의 이름 저장
			if (cmd.equals("종료")) {							
				//showConfirmDialog 생성
				int exit =JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(exit == JOptionPane.YES_OPTION)			//예 선택 시 종료
					System.exit(0);
			}
			else if(cmd.equals("시스템 정보")) {
				//showMessageDialog 생성, Information아이콘 설정
				JOptionPane.showMessageDialog(null, "MyNotes 시스템 v1.0입니다", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(cmd.equals("불러오기")) {
				ic.open();									//불러오기 메소드 실행
			}
			//저장 안됨
			else if(cmd.equals("저장하기")) {
				ic.save();									//저장하기 메소드 실행
			}
		}
}