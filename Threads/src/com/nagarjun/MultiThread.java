package com.nagarjun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiThread implements Runnable{

	private static BufferedReader br = null;
	private List<String> lst;
	
	static{
		try {
			br = new BufferedReader(new FileReader("F://Hello.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String line = null;
		int count = 0;
		while(true){
			this.lst = new ArrayList<String>();
			synchronized (br) {
				try{
					while((line=br.readLine())!=null){
						if(count<15){
							lst.add(line);
							count++;
						}else{
							lst.add(line);
							count=0;
							break;
						}
					}
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
			try{
				Thread.sleep(1000);
				display(this.lst);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			if(line==null){
				break;
			}
		}
	}
	
	public void display(List<String> list){
		for(String lst: list){
			System.out.println(lst);
		}
		System.out.println(list.size());
	}

}
