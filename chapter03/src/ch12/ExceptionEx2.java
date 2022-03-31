package ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx2 {

	public static void main(String[] args) {
		
		FileInputStream fis;
		
		try {
			// 예외가 발생 할 수 있는 코드 
			fis = new FileInputStream("a.txt");
			//return;
		} catch (FileNotFoundException e) {
			// 예외를 어떻게 처리 해야 하는지 작성하는 부분 
			e.printStackTrace();
			System.out.println("파일이 없습니다.");
		} finally {
			// 심지어 return 키워드를 만나도 실행 되는 영역 입니다.
			System.out.println("반시 실행 되는 영역 입니다.");
		}
		
		System.out.println("코드가 실행이 되나요?");

	}

}
