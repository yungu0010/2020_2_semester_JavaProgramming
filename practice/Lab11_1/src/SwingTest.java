import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SwingTest extends JFrame{
	JTextArea lblOrder;
	JRadioButton rbAme, rbLa, rbTall, rbGrande, rbVenti;
	JCheckBox cbSy, cbSh;
	JButton btnOrder;
	String rs;
	public SwingTest() {
		setTitle("스윙 컴포넌트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10, 10));
		MyListener ml = new MyListener(); 
		
		JPanel panelTop = new JPanel();
		JLabel lblTop = new JLabel("커피 주문");   
		lblTop.setFont(new Font("돋움", Font.BOLD, 20));
		panelTop.add(lblTop);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(0, 1, 10, 10));
		panelLeft.add(new JLabel("커피 종류"));
		panelLeft.add(new JLabel("커피 사이즈"));
		panelLeft.add(new JLabel("추가 옵션"));
		
		JPanel panelRight = new JPanel();
		lblOrder = new JTextArea("주문 결과는 여기에 출력됩니다. ");
		lblOrder.setEditable(false);
		panelRight.add(lblOrder);
		//panelRight.add(new JScrollPane(lblOrder));
		JPanel panelBottom = new JPanel();
		btnOrder = new JButton("주문하기");
		btnOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//주문하기 버튼을 누르면 각각이 가지고 있는 상태정보를 이용하여 결과라벵레 출력
				lblOrder.setText("<주문결과> \n" + rs + "\n주문이 완료되었습니다.");
			}
		});
		panelBottom.add(btnOrder);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(0, 1, 10, 10));
		JPanel panelType = new JPanel();
		ButtonGroup type = new ButtonGroup();
		rbAme = new JRadioButton("아메리카노", true);
		rbAme.addItemListener(ml);
		rbLa = new JRadioButton("카페라떼");
		rbLa.addItemListener(ml);
		type.add(rbAme);
		type.add(rbLa);
		panelType.add(rbAme);
		panelType.add(rbLa);
		
		JPanel panelSize = new JPanel();
		ButtonGroup size = new ButtonGroup();
		rbTall = new JRadioButton("Tall", true);
		rbTall.addItemListener(ml);
		rbGrande = new JRadioButton("Grande");
		rbGrande.addItemListener(ml);
		rbVenti = new JRadioButton("Venti");
		rbVenti.addItemListener(ml);
		size.add(rbTall);
		size.add(rbGrande);
		size.add(rbVenti);
		panelSize.add(rbTall);
		panelSize.add(rbGrande);
		panelSize.add(rbVenti);
		
		JPanel panelOpt = new JPanel();
		cbSy = new JCheckBox("시럽 추가");
		cbSy.addItemListener(ml);
		cbSh = new JCheckBox("샷 추가");
		cbSh.addItemListener(ml);
		panelOpt.add(cbSh);
		panelOpt.add(cbSy);
		
		panelCenter.add(panelType);
		panelCenter.add(panelSize);
		panelCenter.add(panelOpt);
		
		c.add(panelTop, BorderLayout.NORTH);
		c.add(panelLeft, BorderLayout.WEST);
		c.add(panelCenter, BorderLayout.CENTER);
		c.add(panelRight, BorderLayout.EAST);
		c.add(panelBottom, BorderLayout.SOUTH);
		setSize(500, 300);
		setVisible(true);
		
	}
	class MyListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(rbAme.isSelected())
				rs = rbAme.getText() + " ";
			else if (rbLa.isSelected()) 
				rs = rbLa.getText() + " ";
			rs+="\n";
			if(rbTall.isSelected())
				rs += rbTall.getText() + " ";
			else if(rbGrande.isSelected())
				rs += rbGrande.getText() + " ";
			else if(rbVenti.isSelected())
				rs += rbVenti.getText() + " ";
			rs+="\n";
			if(cbSy.isSelected())
				rs += cbSy.getText() + " ";
			if(cbSh.isSelected())
				rs += cbSh.getText();
			lblOrder.setText("<주문 진행중> \n " + rs);
		}
		
	}

	public static void main(String[] args) {
		new SwingTest();

	}

}
