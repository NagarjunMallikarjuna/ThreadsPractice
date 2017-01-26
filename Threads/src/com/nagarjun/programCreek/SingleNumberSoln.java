package com.nagarjun.programCreek;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumberSoln {

	public static void main(String[] args) {
		int[] a ={1,2,3,1,2};
		int res = singleNumber(a);
		System.out.println(res);
	}
	
	/*public static int singleNumber(int[] A){
		int x = 0;
		for(int a:A){
			x = x^a;
		}
		return x;
	}*/
	
	public static int singleNumber(int[] A){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int n: A){
			if(!set.add(n))
				set.remove(n);
		}
		Iterator<Integer> it = set.iterator();
		return it.next();
	}
}
