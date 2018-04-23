package com.nagarjun.geekforgeek;

public class ThreadJoin extends Thread{

	public static void main(String[] args) {
		ThreadJoin thr1 = new ThreadJoin();
		ThreadJoin thr2 = new ThreadJoin();
		thr1.start();
		try {
			thr1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thr2.start();
	}
	@Override
	public void run() {
		System.out.println("Geeks");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("for geeks");
	}
	
	
}
