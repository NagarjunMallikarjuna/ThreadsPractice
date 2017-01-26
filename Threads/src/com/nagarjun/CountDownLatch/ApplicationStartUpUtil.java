package com.nagarjun.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationStartUpUtil {

	private static List<BaseHealthChecker> _services;
	private static CountDownLatch _latch;
	
	private ApplicationStartUpUtil(){
		
	}
	
	private final static ApplicationStartUpUtil INSTANCE = new ApplicationStartUpUtil();
	
	public static ApplicationStartUpUtil getInstance(){
		return INSTANCE;
	}
	
	public static boolean checkExternalSrevices() throws InterruptedException {
		_latch = new CountDownLatch(3);
		_services = new ArrayList<BaseHealthChecker>();
		_services.add(new NetworkHealthChecker(_latch));
		_services.add(new NetworkHealthChecker(_latch));
		_services.add(new NetworkHealthChecker(_latch));
		
		Executor executor = Executors.newFixedThreadPool(_services.size());
		
		for(final BaseHealthChecker v : _services){
			executor.wait();
		}
		
		for (final BaseHealthChecker v: _services){
			if(!v.isServiceUp()){
				return false;
			}
		}
		return true;
	}
}
