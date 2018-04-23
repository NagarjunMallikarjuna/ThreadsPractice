package com.nagarjun.geekforgeek;

public class ObjLvlLck implements Runnable{

	@Override
	public void run() {
		this.Lock();
	}
	
	public void Lock(){
		System.out.println(Thread.currentThread().getName()+" starts");
		synchronized (this) {
			System.out.println("Name: "+Thread.currentThread().getName());
			System.out.println("Proiority: "+Thread.currentThread().getPriority());
		}
	}
	
	public static void main(String[] args) {
		ObjLvlLck lvlck = new ObjLvlLck();
		Thread t1 = new Thread(lvlck);
		Thread t2 = new Thread(lvlck);
		ObjLvlLck lvlck1 = new ObjLvlLck();
		Thread t3 = new Thread(lvlck1);
		t1.setName("t1");
		t1.setPriority(1);
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
