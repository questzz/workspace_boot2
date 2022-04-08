package thread_ex;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMiniGame extends JFrame {
	
	BufferedImage image1; 
	BufferedImage image2;
	BufferedImage image3;
	
	JPanel panel1; 
	JPanel panel2;
	
	int icon2X = 0; 
	int icon2y = 0;
	int icon3x = 0; 
	int icon3y = 0; 
	
	
	int image3XPosition = 0; 
	
	public MyMiniGame() {
		initData();
		setInitLayout();
		addEventListener();
		
		// 생성자에서 Thread start 처리 
	}
	
	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 파일 가져오기 todo 
		
		
	}
	private void setInitLayout() {
		
	}
	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 여기서는 이미지 2번을 키 이벤트를 받아서 동작 시켜 주세요
			}
		});
	}
	
	private class CustomJpanel extends JPanel implements Runnable {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지를 그리기 3개 TODO 
		}
		
		@Override
		public void run() {
			boolean direction = true; //오른쪽 ++  
			// 이미지 3번을 좌 우 
			// while(true) {} <<-- 이미지 하나를 >>>>>> <<<<<<<
			while(true) {
				
				if (direction) {
					image3XPosition += 10; 
				} else {
					image3XPosition -= 10;
				}
				
				if(image3XPosition == 500) {
					direction = false; 
				}
				
				if(image3XPosition == 100) {
					direction = true; 
				}
				
				repaint();
			}
			
			// x좌표값을 +
			
			// max 확인 하고
			
			// x좌표값을 -
			
			// 그림을 다시 그려 주세요 
			
			// thread.sleep(???); 
			
		}
		
	}
	
}

















