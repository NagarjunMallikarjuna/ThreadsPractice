package com.nagarjun;

public class ThreadReadDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MultiThread(),"A");
		Thread t2 = new Thread(new MultiThread(),"B");
		t1.start();
		t2.start();
	}
}
