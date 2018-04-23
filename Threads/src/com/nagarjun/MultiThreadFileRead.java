package com.nagarjun;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MultiThreadFileRead extends Thread {
	InputStream in;

	MultiThreadFileRead(String name) throws Exception {
		in = new FileInputStream(name);
		this.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (i != -1) {
			try {
				i = in.read();
				System.out.print((char) i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException, InterruptedException {
		int n = 2;
		System.out.print("Enter the number of files: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		MultiThreadFileRead fr[] = new MultiThreadFileRead[n];
		long tim;
		tim = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			fr[i].join();
		}
	}
}
