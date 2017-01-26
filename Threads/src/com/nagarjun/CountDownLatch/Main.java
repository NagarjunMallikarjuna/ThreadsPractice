package com.nagarjun.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		boolean result =false;
		try{
			result = ApplicationStartUpUtil.checkExternalSrevices();
		}catch(Exception e){
			System.out.println("External services validation !! result was :: "+result);
		}
	}
}
