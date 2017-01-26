package com.nagarjun;

public class ActualResolvedDeadLockTest {

	public static void main(String[] args) {
		ActualResolvedDeadLockTest test = new ActualResolvedDeadLockTest();
		final A a = test.new A();
		final B b = test.new B();
		
		Runnable block1 = new Runnable(){

			@Override
			public void run() {
				synchronized (b) {
					try{
							Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized (a) {
						System.out.println("in block 1");
					}
				}
				
			}
			
		};
		
		Runnable block2 = new Runnable(){

			@Override
			public void run() {
				synchronized (b) {
					synchronized (a) {
						System.out.println("in block 2");
					}
				}
			}
			
		};
		
		new Thread(block1).start();
		new Thread(block2).start();
		
		
	}
	
	private class A{
		private int i=20;
		public void setI(int i){
			this.i=i;
		}
		public int getI(){
			return i;
		}
	}
	
	private class B{
		private int i=20;
		public void setI(int i){
			this.i=i;
		}
		public int getI(){
			return i;
		}
	}
	
}
