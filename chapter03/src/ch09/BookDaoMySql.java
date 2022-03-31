package ch09;

import java.util.ArrayList;

import ch08.Book;

public class BookDaoMySql {
	
	ArrayList<Book> books;
	
	// 인터페이스를 활용해서 기능 구현 
	// ArrayList 사용 
	
	// 샘플 코드 <-- 인터페이스 설계 후 처리 !!!!  
	public void insert(Book book) {
		books.add(book);
	}
	
	
}
