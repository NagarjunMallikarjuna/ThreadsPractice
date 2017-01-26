package com.nagarjun.ThreadPoolExecutor;

public class DemoThread implements Runnable{

	private String name = null;
	
	public DemoThread(String name){
		this.name=name;
	}
	
	public String  getName(){
		return name;
	}
	
	@Override
	public void run() {
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e ){
			e.printStackTrace();
		}
	}

}
