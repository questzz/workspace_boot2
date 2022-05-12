package ch03;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class MainTest3 {

	public static void main(String[] args) {
		Gson gson = new Gson(); 
		Student[] students = new Student[3];
		
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 20, "서울");
		Student student3 = new Student("세종대왕", 20, "세종시");

		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
				
		String studentArr = gson.toJson(students);
		System.out.println(studentArr);
		
		// Object --> 형식이 있는 문자열 (json) 
		
//		String jsonStrArr = gson.toJson(student1);
//		System.out.println(jsonStr);
		
		
		// ArrayList<Object> --> jsonArray[object]
		ArrayList<Student> list = new ArrayList<Student>(); 
		list.add(student1);
		list.add(student2);
		list.add(student3);
//		
//		System.out.println(list);
		
		// list --> string 
		String jsonArrayStr = gson.toJson(list);
		System.out.println("--------------------");
		System.out.println(jsonArrayStr);
		
//		System.out.println("============================");
		// 자바에서 사용하는 object ----> 문자열로 변환(json) : 
		// 서버측에 데이터를 보낼때 서버가 이해할 수 있는 문자열(json) 
		
		////////////////////////////////////////////////////////////////////
		// 서버에서 json 던져 준다면 우리가 java 사용하기 위해서 class 로 변환 해야 한다 
		// dto 개념을 배웠음 !!! 
		
		
//		System.out.println(jsonStr);
//		// 파싱하는 방법 - 1  
//		Student objS1 = gson.fromJson(jsonStr, Student.class);
//		System.out.println(objS1.address);
//		System.out.println(objS1.name);
//		System.out.println(objS1.age);
//		
		System.out.println("---------------------");
		// 파싱하는 방법 - 2
//		Student[] objA1 = gson.fromJson(studentArr, Student[].class);
//		for (Student student : objA1) {
//			System.out.println(student);
//		}
		
		// jsonArrayStr 
		// 파싱하는 방법 - 3
		// ArrayList 로 만들고 싶다면 !!! 
		// 타입을 명시함 !!! 
		Type studentType = new TypeToken<ArrayList<Student>>(){}.getType();
		ArrayList<Student> arrayList = gson.fromJson(jsonArrayStr, studentType);
		
		for (Student student : arrayList) {
			System.out.println(student);
		}
		
		
//		System.out.println(objA1);
		
		
		// 파싱하는 방법 3 
		// 1 : object 
		// 2 : 배열 
		// 3 : ArrayList 
		
		
	}

}





