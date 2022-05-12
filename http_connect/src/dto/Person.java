package dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
@ToString
public class Person {
	private String name; 
	private int age;
	private String address;
	
	
}
