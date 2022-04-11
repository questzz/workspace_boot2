package tenco.com.test_13;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 벽에 부딪치는 테스트 
// 메인 쓰레드는 바쁨 -- 키보드 이벤트 처리 
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
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);
			
			// 바닥 충돌 확인 
			if (bottomColor != -2) {
				player.setDown(false);
			} else { // -2 일때 실행 됨 ... 바닥 색깔이 하얀색 !! 
				// 코드 추가 
				// 점프 하는 순간 down 메서드가 호출 ;; 
				if(!player.isUp() && !player.isDown()) { // 내려가다가 끝 까지 내려감...
					// 버그 (무한 호출) : 백그라운드서비스는 계속 실행 됨!!!!!
					// Player에서 donw == false 일 경우에만 한번 실행되게 수정해야 함.
					// 일관성 있게 bubbleFrame 에서 코드를 처리 하자.
					player.down();
				} 
			}

			// 외벽 충돌 확인
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			try {
				// 캐릭터가 이동 될 때 값을 못 찾는 경우가 있다. 
				// 이동 속도 보다 더 빠르게 움직여야 해결 가능 
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
