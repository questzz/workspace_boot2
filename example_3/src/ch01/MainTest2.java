package ch01;

public class MainTest2 {

	public static void main(String[] args) {
		
		ICalc iCalcAdd = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				return a + b + c;
			}
		};
		System.out.println(iCalcAdd.calc(1, 1, 1));
		
		ICalc iCalcMinus = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				return a - b - c;
			}
		};
		System.out.println(iCalcMinus.calc(1, 1, 1));
		
 
		ICalc iCalcMulti = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				// TODO Auto-generated method stub
				return a * b * c;
			}
		};
		System.out.println(iCalcMulti.calc(1, 1, 2));
		
		
		// 람다 표현식으로 만들어 보기
		
	}

}
