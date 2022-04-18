package tenco.com.test_19;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private List<Bubble> bubbles = new ArrayList<Bubble>();

	public BackgroundPlayerService(Player player) {
		this.player = player;
		this.bubbles = player.getBubbles();
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {

			// 1 버블 충돌 체크
			for (int i = 0; i < bubbles.size(); i++) {
				Bubble targetBubble = bubbles.get(i);
				if (targetBubble.getState() == 1) {

					if ((Math.abs(player.getX() - targetBubble.getX()) < 10)
							&& (Math.abs(player.getY() - targetBubble.getY()) > 0)
							&& (Math.abs(player.getY() - targetBubble.getY()) < 50))  {
						new Thread(new Runnable() {
							@Override
							public void run() {
								targetBubble.removeBubble();
							}
						}).start();
						break;
					}
				}
			}

			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);

			// 바닥 충돌 확인
			if (bottomColor != -2) {
				player.setDown(false);
			} else { // -2 일때 실행 됨 ... 바닥 색깔이 하얀색 !!
				if (!player.isUp() && !player.isDown()) { // 내려가다가 끝 까지 내려감...
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
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
