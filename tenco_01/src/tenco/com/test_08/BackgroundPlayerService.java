package tenco.com.test_08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 메인 쓰레드 바쁨 --> 키보드 이벤트 처리 
// 백그라운드에서 계속 관찰 
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// 도전 과제 ! 던지거나 처리 
		// 색상 확인 
		while(true) {
			
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY()));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY()));
			System.out.println("============================");
			System.out.println("왼쪽 색상 : " + leftColor);
			System.out.println("오른쪽 색상 : " + rightColor);
			System.out.println("============================");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
