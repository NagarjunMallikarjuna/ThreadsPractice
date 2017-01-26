package com.nagarjun.ThreadExamples;

public class Account {

	private int balance;
	
	public Account(final int initialBalance){
		
	}
	
	public synchronized void deposit(final int amount){
		if(amount>0){
			balance += amount;
		}
	}
	
	public synchronized boolean withdraw(final int amount){
		if(amount>0 && balance>=amount){
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public int getBalance(){
		return balance;
	}
}


//synchronized method helps us to cross the memory barrier.
