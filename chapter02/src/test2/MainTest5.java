package test2;

import java.util.Random;

public class MainTest5 {
	static String[] names = {
			"하만준", "정규동", "홍원일", "김소담",
			"김현아", "박지현", "정민수", "임희진", "임우성" 
	};
	
	public static void main(String[] args) {
		int selected = ranValue();		System.out.println(names[selected]);
	}

	public static int ranValue() {
		Random random = new Random();
		int value = random.nextInt(names.length);
		return value; 
		
	}
	
}
