package com.nagarjun.ThreadExecutor;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

	ExecutorService executor = Executors.newFixedThreadPool(3);
	
	public void start() throws IOException{
		int i=0;
		while(!executor.isShutdown())
			executor.submit(new MyThread(i++));
	}
	
	public void shutdown()throws InterruptedException{
		executor.shutdown();
		executor.awaitTermination(30, TimeUnit.SECONDS);
		executor.shutdownNow();
	}
	
	public static void main(String[] argv)throws Exception {
		new MainClass().start();
	}
	
}
