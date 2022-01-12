package com.poi.ApachePOI.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	
	private String name;
	private String address;
	private String age;
	private String dob;
	//private List<String> auditData = new ArrayList<String>();
	
//	public Employee(String name,String address, Integer age, String dob) {
//		this.name = name;
//		this.address = address;
//		this.age = age;
//		this.dob = dob;
//	}
}
