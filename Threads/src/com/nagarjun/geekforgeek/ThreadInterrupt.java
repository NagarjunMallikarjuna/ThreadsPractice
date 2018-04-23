package com.nagarjun.geekforgeek;

public class ThreadInterrupt extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Child thread executing");
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThreadInterrupt thrInt = new ThreadInterrupt();
		thrInt.start();
		thrInt.interrupt();
		System.out.println("Main  thread executed");
	}
}
