package ch02;

// 호출자 : 인터페이스 멤버 변수로 선언 
public class MyArticle {
	
	String article; 
	WriteArticle onWriteArticle;
	
	// 주소값 연결 : 생성자 에서 연결 하는 방법.
	public MyArticle(String article, WriteArticle onWriteArticle) {
		this.article = article; 
		this.onWriteArticle = onWriteArticle;
	}
	
	public void complete() {
		onWriteArticle.printArticle(article);
	}
	
}
