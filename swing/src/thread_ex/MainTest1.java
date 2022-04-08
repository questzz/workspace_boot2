package thread_ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MiniAmongUs extends JFrame implements ActionListener {

	BufferedImage backgroundImage;
	BufferedImage pinkImage;
	BufferedImage grayImage;
	CustomJpanel customJpanel;

	JPanel panel1;
	JPanel panel2;
	JButton button1;
	JButton button2;

	final int HERO_SIZE_1 = 100;

	int grayImageX = 200;
	int grayImageY = 200;
	int pinkImageX = 0;
	int pinkImageY = 400;

	public MiniAmongUs() {
		initData();
		setInitLayout();
		addEventListener();
		Thread thread = new Thread(customJpanel);
		thread.start();
	}

	private void initData() {
		setTitle("미니어몽어스");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {
			backgroundImage = ImageIO.read(new File("background_1.png"));
			pinkImage = ImageIO.read(new File("among1.png"));
			grayImage = ImageIO.read(new File("among2.png"));
		} catch (IOException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}
		//
		panel1 = new JPanel();
		panel1.setBackground(Color.yellow);

		panel2 = new JPanel();
		panel2.setBackground(Color.blue);

		button1 = new JButton("멈춤");
		button2 = new JButton("동작");

		customJpanel = new CustomJpanel();

	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		// setLayout(new GridLayout(2, 1));

		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

//		panel1.setPreferredSize(new Dimension(600, 500));
//		panel2.setPreferredSize(new Dimension(600, 100));
		customJpanel.setPreferredSize(new Dimension(600, 500));
		panel1.add(customJpanel);

		panel2.add(button1);
		panel2.add(button2);
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		
	}


	public void addEventListener() {

		button1.addActionListener(this);
		button2.addActionListener(this);
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				
				
				int code = e.getKeyCode();
				System.out.println("111111");
				if (code == KeyEvent.VK_UP) {
					grayImageY -= 10;
				} else if (code == KeyEvent.VK_DOWN) {
					grayImageY += 10;
				} else if (code == KeyEvent.VK_LEFT) {
					grayImageX -= 10;
				} else if (code == KeyEvent.VK_RIGHT) {
					grayImageX += 10;
				}
				// 필수!! (이미지를 다시 그려라)
				repaint();
				requestFocusInWindow();

			}
		});

	}

	// 내부 클래스
	private class CustomJpanel extends JPanel implements Runnable {
		boolean flag = true;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 500, 500, null);
			g.drawImage(pinkImage, pinkImageX, pinkImageY, HERO_SIZE_1, HERO_SIZE_1, null);
			g.drawImage(grayImage, grayImageX, grayImageY, HERO_SIZE_1, HERO_SIZE_1, null);
		}

		private void checkHeroPosition() {
//			System.out.println("pinkImageX " + pinkImageX);
//			System.out.println("pinkImageY " + grayImageY);
//			System.out.println("grayImageX " + grayImageX);
//			System.out.println("grayImageY " + grayImageY);
			if ((pinkImageX == grayImageX) && (pinkImageY == grayImageY)) {
				System.out.println("x, y 좌표값이 같음 !!");
				pinkImage = null;
				flag = false;
			}
//			 if ((pinkImageY == grayImageY)) {
//				 System.out.println("y 좌표 값이 같음 !! ");
//			 }
		}

		@Override
		public void run() {
			boolean direction = true;
			while (flag) {
//			while (true) {
				if (direction) {
					pinkImageX += 10;
				} else {
					pinkImageX -= 10;
				}

				if (pinkImageX == 500) {
					direction = false;
				}

				if (pinkImageX == 0) {
					direction = true;
				}

				repaint();
				checkHeroPosition();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}// end of run

	} // end of inner class

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		requestFocusInWindow();
	}

} // end of class

public class MainTest1 {
	public static void main(String[] args) {
		new MiniAmongUs();
	}
}
