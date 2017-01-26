package com.nagarjun;

//start create a new thread while run doesnt create the any thread and simply execute in the current thread like a normal method call.

public class StartVsRunCall {

	public static void main(String[] args) {
		Thread startThread = new Thread(new Task("start"));
		Thread runThread = new Thread(new Task("run"));
		startThread.start();
		runThread.run();
	}

	private static class Task implements Runnable{
		private String caller;
		public Task(String caller){
			this.caller=caller;
		}
		@Override
		public void run() {
			System.out.println("Caller:: "+caller+ " and code on this thread is executed by :" + Thread.currentThread().getName());
		}
	}
}
