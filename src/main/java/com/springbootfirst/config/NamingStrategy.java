package com.springbootfirst.config;

import org.springframework.data.domain.Sort.Direction;

public class NamingStrategy {

	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++) {
//			String str = "INSERT INTO classes (classes_name) VALUES('" + 1111 + i + "');";
//			System.out.println(str);
//		}
		
		System.out.println(Direction.fromString("Asc"));
	}
}
