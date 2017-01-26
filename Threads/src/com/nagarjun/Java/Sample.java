package com.nagarjun.Java;

import java.util.Arrays;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		for(int i=0; i<numbers.size();i++){
			System.out.println(numbers.get(i));
		}
	}
}
