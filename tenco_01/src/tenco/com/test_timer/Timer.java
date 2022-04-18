package tenco.com.test_timer;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;

import javax.swing.JLabel;

public class Timer extends JLabel {
	
	public Timer() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setText("12:20:20");
		setBounds(200, 200, 200, 80);
		//setBackground(Color.YELLOW);
		setFont(new  Font("맑은 고딕", Font.PLAIN, 30));
		setForeground(Color.BLUE);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					
					String currentTime = LocalTime.now().toString();
					
					// 09:44:12 .981536300
					System.out.println(currentTime);
					currentTime = currentTime.split("[.]")[0];
					try {
						Thread.sleep(1000);
						setText(currentTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	private void setInitLayout() {
		
	}
	
	private void addEventListener() {
		
	}
	
	
	

}
