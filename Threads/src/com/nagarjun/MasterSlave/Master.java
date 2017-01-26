package com.nagarjun.MasterSlave;

public class Master {

	private int slaveCount = 0;
	private Slave[] slaves = new Slave[slaveCount];
	
	public void run(){
		for(int i=0; i<slaveCount; i++){
			slaves[i] = new Slave();
		}
		
		for(int i=0; i<slaveCount; i++){
			slaves[i].start();
		}
		
		for(int i=0; i<slaveCount; i++){
			try{
				slaves[i].join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				System.out.println(slaves[i].getName()+ " has died");
			}
		}
		System.out.println("The master will now die....");
	}
}
