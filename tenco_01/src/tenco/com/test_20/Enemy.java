package tenco.com.test_20;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Enemy extends JLabel implements Moveable {

	private BubbleFrame mContext;
	
	// 위치 상태
	private int x;
	private int y;
	
	// 플레이어의 방향 
	private EnemyWay enemyWay; 

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 적군 속도 상태
	private final int SPEED = 2;
	private final int JUMPSPEED = 1;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	private ImageIcon enumyR;
	private ImageIcon enumyL;
	
	private boolean isLive = true; 
	
	
	public Enemy(BubbleFrame mContext) {
		this.mContext = mContext;
		initObject();
		initSetting();
		//right();
		//initBackgroundPlayerService();
	}

	private void initBackgroundPlayerService() {
		//new Thread(new BackgroundPlayerService(this)).start();
	}

	private void initObject() {
		enumyR = new ImageIcon("images/enemyR.png");
		enumyL = new ImageIcon("images/enemyL.png");
	}

	private void initSetting() {
		x = 500;
		y = 180;

		left = false;
		right = false;
		up = false;
		down = false;
		isLive = true; 
		
		leftWallCrash = false;
		rightWallCrash = false;
		
		enemyWay = EnemyWay.LEFT;

		setIcon(enumyL);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 이벤트 핸들러
	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;
		
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					setIcon(enumyL);
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10); // 0.01초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	@Override
	public void right() {
		enemyWay = EnemyWay.RIGHT;
		right = true;

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					setIcon(enumyR);
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void up() {
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				up = false;
				down();
			}
		}).start();
	}

	@Override
	public void down() {
		down = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();
	}
	
} // end of class
