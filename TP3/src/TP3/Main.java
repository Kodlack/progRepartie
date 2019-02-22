package TP3;

public class Main{
	
	public static void main(String[] args){
		Monitor boiteLettres = new Monitor();
		Consumer cons = new Consumer(boiteLettres);
		
		Producer prod1 = new Producer(boiteLettres, "blabla");
		Producer prod2 = new Producer(boiteLettres, "truc");
		Producer prod3 = new Producer(boiteLettres, "machin");
		
		Thread t1 = new Thread(prod1);
		Thread c = new Thread(cons);
		Thread t2 = new Thread(prod2);
		Thread t3 = new Thread(prod2);
		
		
		t1.start();
		t2.start();
		t3.start();
		c.start();
	}
	
}
