package com.nagarjun;

/**
 * 
 * @author Nagarjun
 *1. The join method allows one thread to wait for the completion of another
 *2. If t is a thread object whose thread is currently executing, t.join(), causes
 *the thread to pause execution until the thread terminates
 *3. Overloads of join allows the programmer to specify a waiting period.
 */
public class ForThreadJoin extends Thread {

	public static void main(String[] args) throws InterruptedException {

		ParallelStack j1 = new ParallelStack();
		ParallelStack j2 = new ParallelStack();

		// Creation of the thread
		Thread t1 = new Thread(j1, "Thrd-1");
		Thread t2 = new Thread(j2, "Thrd-2");
		// Setting the thread for joining
		j1.setThrd(t1);
		j2.setThrd(t2);

		// Starting the thread
		t1.start();
		t2.start();

	}

	public static class ParallelStack implements Runnable {
		private Thread thrd;

		public void run() {
			while (thrd != null) {
				synchronized (thrd) {
					try {
						System.out.println(thrd.currentThread().getId());
						for (int i = 0; i < 3; i++) {
							System.out
									.println(Thread.currentThread().getName());
						}
						thrd.join();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void setThrd(Thread thrd) {
			this.thrd = thrd;
		}
	}

}
