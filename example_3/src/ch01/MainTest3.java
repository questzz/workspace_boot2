package ch01;

public class MainTest3 {

	public static void main(String[] args) {
		
		ICalc iCalcAdd = (a, b, c) -> {
			return a + b + c;
		};
		
		ICalc iCalcAdd2 = (a, b, c) -> {return a + b + c;};
		
		//실행문이 한 문장인 경우 중괄호와 return 키워드를 생략할 수 있다.
		ICalc iCalcAdd3 = (a, b, c) -> a + b + c;
		
		// 문제 1 
		//  iCalcMinus1, iCalcMinus2, iCalcMinus3

		// 문제 2
		//  iCalcMulti1, iCalcMulti2, iCalcMulti3
		
	}

}
