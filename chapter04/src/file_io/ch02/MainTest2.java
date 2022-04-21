package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * 입력 스트림 
 * 파일에서 한 바이트 씩 데이터를 읽기 - 1
 * try-with-resources : try(...) 오토 클로즈 제 
 */
public class MainTest2 {

	public static void main(String[] args) {
		System.out.println("시작 : 파일에서 데이터를 읽어서 화면에 출력 ");
		// System.in // 키보드 (스트림연결)
//		FileInputStream fis = null; 
		int i;
		try(FileInputStream fis = new FileInputStream("boot_a.txt")) {
			while( (i = fis.read()) != -1 ) {
				System.out.println((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//			int i; 
//			fis = new FileInputStream("boot_a.txt");
//			while( (i = fis.read()) != -1 ) {
//				System.out.println((char)i);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		System.out.println("끝");
	}

}
