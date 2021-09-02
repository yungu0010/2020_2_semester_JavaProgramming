import java.awt.Font;
import java.util.Calendar;
import javax.swing.JLabel;

class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 15));	//폰트 설정
			setHorizontalAlignment(JLabel.CENTER);				//가운데 맞춤
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		
		public String makeClockText() {
			Calendar c = Calendar.getInstance();
			//현재 시간 정보 저장
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int date = c.get(Calendar.DATE);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			//원하는 출력 형태로 문자열 붙이기
			String clockText = Integer.toString(year);
			clockText = clockText.concat("년 ");
			clockText = clockText.concat(Integer.toString(month));
			clockText = clockText.concat("월 ");
			clockText = clockText.concat(Integer.toString(date));
			clockText = clockText.concat("일 ");
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(hour));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			return clockText;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){return;}
				setText(makeClockText());
			}
		}
	}