package thread_ex;

class Citizen extends Thread {
	President president = new President();

	public void askforaHandshake() {
		// 악수청하기
		System.out.println("시민이 악수를 청합니다.");

	}
}// end of class

class Adult extends Citizen {

	public Adult(President president) {
		int power = 7;
	}

	public void askforaHandshake() {
		// 악수청하기
		System.out.println("어른이 악수를 청합니다.");
		president.beAskedforaHandshake(this, 7);

	}

	@Override
	public void run() {
		askforaHandshake();
	}

}// end of class

class Kid extends Citizen {

	public Kid(President president) {
		int power = 3;
	}

	public void askforaHandshake() {
		// 악수청하기
		System.out.println("아이가 악수를 청합니다.");
		president.beAskedforaHandshake(this, 3);

	}

	@Override
	public void run() {
		askforaHandshake();
	}

} // end of class

class President {
	private int hp = 10;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void beAskedforaHandshake(Citizen citizen, int power) {
		int currentHp = getHp();
		System.out.println("대통령이 악수요청을 받았습니다.");

		if (citizen instanceof Adult) {
			System.out.println("당신은 어른이네요..");
			try {
				Thread.sleep(4000);

			} catch (Exception e) {

				e.printStackTrace();
			}
			setHp(currentHp - power);
			System.out.println("어른과 악수했습니다.");
			System.out.println("악수후 hp" + getHp());
		} else if (citizen instanceof Kid) {
			System.out.println("당신은 아이군요!!");
			try {
				Thread.sleep(200);

			} catch (Exception e) {
				e.printStackTrace();
			}
			setHp(currentHp - power);
			System.out.println("아이와 악수했습니다.");

			System.out.println("악수후 hp" + getHp());
		}

	}

} // end of class

public class shakeHand_withRightHand {
	public static void main(String[] args) {
		President president = new President();
		Citizen adult = new Adult(president);
		Citizen kid = new Kid(president);

		adult.start();
		kid.start();

	} // end of main
}
