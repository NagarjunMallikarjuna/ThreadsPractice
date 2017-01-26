package com.nagarjun.ThreadExamples;

import java.util.Arrays;

public class AccountService {

	public static void transfer(final Account from, final Account to, int amount){
		
		//here in the below scenario not sure which will be called first, so there is 
		//very high probability of getting a deadlock and livelock in the code
		synchronized (from) {
			synchronized (to) {
				if(from.withdraw(amount)){
					to.deposit(amount);
				}
			}
		}
		
		//to avoid the above scenario we can use Arrays.sort method for sorting the 
		//values in the ascending order their values so that we can prevent deadlocking
		
		Account[] accounts = new Account[]{from, to};
		Arrays.sort(accounts);
		synchronized (accounts[0]) {
			synchronized (accounts[1]) {
				if(from.withdraw(amount)){
					to.deposit(amount);
				}
			}
		}
		
	}
}
