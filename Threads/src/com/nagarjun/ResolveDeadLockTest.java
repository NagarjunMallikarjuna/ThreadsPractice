package com.nagarjun;

public class ResolveDeadLockTest {
//it ends up in deadlock
	public static void main(String[] args) {
		ResolveDeadLockTest test = new ResolveDeadLockTest();
		
		final A a = test.new A();
		final B b = test.new B();
		
		Runnable block1 = new Runnable(){
			public void run(){
				synchronized (a) {
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized (b) {
						System.out.println("In block 1");
					}
				}
			}
		};
		
		Runnable block2 = new Runnable(){
			public void run(){
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
		private int i = 10;
		
		public int getI(){
			return i;
		}
		
		public void setI(int i){
			this.i=i;
		}
	}
	
	private class B{
		private int i = 20;
		
		public int getI(){
			return i;
		}
		public void setI(int i){
			this.i=i;
		}
		
	}
}

