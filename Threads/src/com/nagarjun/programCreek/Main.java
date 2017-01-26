package com.nagarjun.programCreek;

public class Main {

	public static void main(String[] args) {
		AdditionUsingThreads t1 = new AdditionUsingThreads();
		MultiplyUsingThreads t2 = new MultiplyUsingThreads();
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		double result = ((double)t1.value/t2.value);
		
		System.out.println(result);
	}
}
