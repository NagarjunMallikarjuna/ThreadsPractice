package com.nagarjun.Java;

public class PrintEvenOrOddTester {

	public static void main(String[] args) {
		Printer print = new Printer();
		Thread t1 = new Thread(new TaskEvenOdd(10, print, false));
		Thread t2 = new Thread(new TaskEvenOdd(10, print, true));
		t1.start();
		t2.start();
	}
}

class TaskEvenOdd implements Runnable {

	private int max;
	private Printer print;
	private boolean isEvenNumber;

	public TaskEvenOdd(int max, Printer print, boolean isEvenNumber) {
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		int number = isEvenNumber == true ? 2 : 1;
		while (number <= max) {
			if(isEvenNumber){
				print.printEven(number);
			}else{
				print.printOdd(number);
			}
		}
	}
}

class Printer {
	boolean isOdd = false;

	synchronized void printEven(int number) {
		while (isOdd == false) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Even: " + number);
		isOdd = false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		while (isOdd == true) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Odd: " + number);
		isOdd = true;
		notifyAll();
	}
}