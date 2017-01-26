package com.nagarjun.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoExecutor {

	public static void main(String[] args) {
		Integer threadCounter = 0;
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10, 20, 5000, TimeUnit.MICROSECONDS, blockingQueue);
		
		executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println("DemoTask rejected: "+((DemoThread) r).getName());
				System.out.println("waiting for second");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Lets add another time: "+((DemoThread)r).getName());
				executor.execute(r);
			}
		});
		
		executor.prestartAllCoreThreads();
		
		while(true){
			threadCounter++;
			System.out.println("Adding demotask : "+threadCounter);
			executor.execute(new DemoThread(threadCounter.toString()));
			
			if(threadCounter==100)
				break;
		}
	}
}
