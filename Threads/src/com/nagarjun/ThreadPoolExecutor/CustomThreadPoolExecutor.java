package com.nagarjun.ThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor{

	public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue){
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	@Override
	protected void beforeExecute(Thread t, Runnable r){
		super.beforeExecute(t,r);
		System.out.println("Perform before execute operations");
	}
	
	protected void afterExecute(Thread r, Throwable t){
		super.afterExecute(r, t);
		if(t!=null){
			System.out.println("Perform exception handler logic");
		}
		System.out.println("Perform afterExecute() logic");
	}
}
