package com.nagarjun.MasterSlave;

public class Slave extends Thread{

	private boolean done = false;
	
	public void halt(){
		done = true;
	}
	
	protected boolean task(){
		return true;
	}
	
	public void run(){
		while(!done){
			done = task();
			try{
				Thread.sleep(10000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
