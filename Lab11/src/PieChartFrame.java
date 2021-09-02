import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class PieChartFrame extends JFrame{
        JPanel p = new JPanel();		//값을 입력할 부분의 panel
        MyPanel panel = new MyPanel();	//파이차트가 그려질 부분의 panel
        //값을 입력하는 부분의 JLabel
        JLabel apple = new JLabel("apple");
        JLabel cherry = new JLabel("cherry");
        JLabel strawberry = new JLabel("strawberry");
        JLabel prune = new JLabel("prune");
        //JTextField의 크기는 10
        JTextField atf = new JTextField(10);
        JTextField ctf = new JTextField(10);
        JTextField stf = new JTextField(10);
        JTextField ptf = new JTextField(10);
        //라벨의 기본값을 25로 지정
        JLabel alb = new JLabel("25");
        JLabel clb = new JLabel("25");
        JLabel slb = new JLabel("25");
        JLabel plb = new JLabel("25");

        public PieChartFrame(){
                setTitle("파이 차트 그리기");							//프레임의 이름 설정
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//close 버튼을 눌렀을 때 실제 프로그램이 종료
                Container c = getContentPane();
                
                c.setLayout(new BorderLayout(0,20));				//레이아웃 설정
                p.setBackground(Color.LIGHT_GRAY);				//배경색 지정
                
                //값을 입력할 부분에 컴포넌트 순서대로 추가
                p.add(apple);			
                p.add(atf);
                p.add(cherry);
                p.add(ctf);
                p.add(strawberry);
                p.add(stf);
                p.add(prune);
                p.add(ptf);
                
                //텍스트필드에 액션리스너 등록
                atf.addActionListener(new MyActionListener());
                ctf.addActionListener(new MyActionListener());
                stf.addActionListener(new MyActionListener());
                ptf.addActionListener(new MyActionListener());
                
                //라벨의 글씨 색상 설정
                alb.setForeground(Color.RED);
                clb.setForeground(Color.BLUE);
                slb.setForeground(Color.MAGENTA);
                plb.setForeground(Color.YELLOW);
                
                //파이차트를 그릴 panel에 컴포넌트 추가
                panel.add(new JLabel("apple"));
                panel.add(alb);
                panel.add(new JLabel("%"+"          "));		//값 뒤에 %와 간격을 보여줄 공백이 적힌 JLabel 추가
                panel.add(new JLabel("cherry"));
                panel.add(clb);
                panel.add(new JLabel("%"+"          "));
                panel.add(new JLabel("strawberry"));
                panel.add(slb);
                panel.add(new JLabel("%"+"          "));
                panel.add(new JLabel("prune"));
                panel.add(plb);
                panel.add(new JLabel("%"+"          "));
                
                
                c.add(p, BorderLayout.NORTH);					//p를 NORTH위치에 추가
                c.add(panel, BorderLayout.CENTER);				//panel을 CENTER위치에 추가
                setSize(800,400);								//프레임 크기 설정
                setVisible(true);								//프레임을 화면에 출력
        }

      //JPanel을 상속받은 패널 구현
        class MyPanel extends JPanel{
        	public void paintComponent(Graphics g){
        		super.paintComponent(g);
                int A = Integer.parseInt(alb.getText());		//라벨의 값을 integer로 변환하여 저장, A,C,S,P는 과일의 첫글자
                int C = Integer.parseInt(clb.getText());
                int S = Integer.parseInt(slb.getText());
                int P = Integer.parseInt(plb.getText());

                int sum = A+C+S+P;								//각도 계산을 위한 합
                //파이차트를 그리기 위한 각도 계산, 오차범위를 없애기 위해 Math.round 사용
                int aAngle = (int)Math.round((double)(A*360)/(double)sum);		
                int cAngle = (int)Math.round((double)(C*360)/(double)sum);
                int	sAngle = (int)Math.round((double)(S*360)/(double)sum);
                int pAngle = (int)Math.round((double)(P*360)/(double)sum);
                g.setColor(Color.RED);							//색 설정
                g.fillArc(290, 50, 250, 250, 0,  aAngle);		//계산한 각도를 가지고 호 채우기
                g.setColor(Color.BLUE);							
                g.fillArc(290, 50, 250, 250, aAngle, cAngle);	//이전에 그려진 호의 끝점을 시작점으로 함
                g.setColor(Color.MAGENTA);						
                g.fillArc(290, 50, 250, 250, aAngle+cAngle, sAngle);		//이전에 그려진 호의 끝점을 시작점으로 함
                g.setColor(Color.YELLOW);						
                g.fillArc(290, 50, 250, 250, aAngle+cAngle+sAngle,pAngle);	//이전에 그려진 호의 끝점을 시작점으로 함
                repaint();										//다시 그리기
        	}
        }

        class MyActionListener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
        		//텍스트필드의 값을 정수로 변환하여 저장
        		int apple_var = Integer.parseInt(atf.getText());
                int cherry_var = Integer.parseInt(ctf.getText());
                int strawberry_var = Integer.parseInt(stf.getText());
                int prune_var = Integer.parseInt(ptf.getText());
                //값의 합 계산
                int sum = apple_var + cherry_var + strawberry_var + prune_var;
                
                //텍스트 필드 입력값으로 백분율을 계산, 오차범위를 조정하기 위한 반올림 연산
                int a =(int)Math.round((double)(apple_var*100)/(double)sum);
                int c =(int)Math.round((double)(cherry_var*100)/(double)sum);
                int s=(int)Math.round((double)(strawberry_var*100)/(double)sum);
                int p=(int)Math.round((double)(prune_var*100)/(double)sum);
                
                //백분율 값을 라벨의 문자열로 저장
                alb.setText(Integer.toString(a));
                clb.setText(Integer.toString(c));
                slb.setText(Integer.toString(s));
                plb.setText(Integer.toString(p));
                }
        }
        public static void main(String[] args) {
    		new PieChartFrame();

    	}

    }