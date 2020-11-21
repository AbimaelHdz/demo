package com.example.demo;

import java.time.LocalDate;

public class Test {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalDate date1 = LocalDate.of(2017, 1, 13);  
		System.out.println(date1);
		System.out.println(LocalDate.of(2017, 1, 12));
	}

}
