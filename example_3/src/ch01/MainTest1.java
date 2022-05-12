package ch01;

public class MainTest1 {

	public static void main(String[] args) {
		
		//IAdd iAdd =  익명 구현 객체 -->  객체 = iAdd.add(10, 20)  return 값은 30 
		IAdd iAdd = new IAdd() {
			@Override
			public int add(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(iAdd.add(10, 20));
		
		// 익명구현 객체를 --> 표현식(반복적인 코드의 간소화) 
		IAdd iAddLambda = (x , y) -> {return x + y;};
		
		System.out.println(iAddLambda.add(10, 20));
		
		// 결론 : 
		// 기본 OOP 문법 : 인터페이스를 --> 익명 구현 객체 ---> 사용 
		// 람다 표현식 : 인터페이스를 --> 람다 표현식 ---> 사용 
		
		
	}

}
