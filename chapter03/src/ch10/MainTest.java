package ch10;

import ch08.Book;

public class MainTest {

	public static void main(String[] args) {
		
		BookClient bookClient = new BookClient();
		// 기능이 완성 되었다면 
		Book book =  bookClient.createBookObj();
		
		bookClient.deleteBook("홍길동전");
		
		
		BookDaoMySql bookDaoMySql = new BookDaoMySql();  
		bookDaoMySql.addBook(book);
		
		// 실행에 흐름 !!! 
		// 1. 조회 2, 생성, 3, 삭제, 4 수정 
		
	}

}
