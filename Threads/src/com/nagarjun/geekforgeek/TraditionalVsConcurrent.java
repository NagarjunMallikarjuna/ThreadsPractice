package com.nagarjun.geekforgeek;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TraditionalVsConcurrent extends Thread{
	static CopyOnWriteArrayList<Integer> lst = new CopyOnWriteArrayList<Integer>();
	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lst.add(1);
	}
	
	public static void main(String[] args) {
		lst.add(2);
		lst.add(3);
		lst.add(4);
		
		TraditionalVsConcurrent t = new TraditionalVsConcurrent();
		t.start();
		Iterator<Integer> itr = lst.iterator();
		while(itr.hasNext()){
			int output = itr.next();
			System.out.println(output);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//https://www.geeksforgeeks.org/tag/java-multithreading/