package com.nagarjun.geekforgeek;

public class DeadLockDemo extends Thread {

	static Thread mainThread;

	@Override
	public void run() {
		System.out.print("Inside the run method.");
		System.out.println("Child Thread waiting for"
				+ " main thread completion");
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			System.out.println("Exception in the run method");
		}
	}

	public static void main(String[] args) {
		DeadLockDemo demo = new DeadLockDemo();
		DeadLockDemo.mainThread  = Thread.currentThread();
		demo.start();
		System.out.println("Main thread waiting for child completion");
		try {
			demo.join();
		} catch (InterruptedException e) {
			System.out.println("Exception in the main method");
		}
		
	}
}
