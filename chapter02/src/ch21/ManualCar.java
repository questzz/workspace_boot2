package ch21;

public class ManualCar extends Car {

	@Override
	void drive() {
		System.out.println("사람이 운전을 합니다.");
		System.out.println("사람이 핸들을 조작 합니다.");
	}

	@Override
	void stop() {
		System.out.println("브레이크를 밟아서 정지 합니다");
	}

	@Override
	public void wiper() {
		System.out.println(" wiper을 사람이 동작 시킵니다. ");
		
	}
	
	

	
}
