package com.nagarjun.Runtime;

public class MemoryTest {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println("Total memory: "+r.totalMemory());
		System.out.println("Free memory: "+r.freeMemory());
		
		for(int i=0; i<1000; i++){
			new MemoryTest();
		}
		System.out.println("After creating 1000 instance, free memory : "+r.freeMemory());
		System.gc();
		System.out.println("After gc() free memory: "+r.freeMemory());
	}
}
