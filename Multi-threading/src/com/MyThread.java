package com;

public class MyThread implements  Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " is Running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyThread obj=new MyThread();
		Thread t1 = new Thread(obj, "Martin");
		Thread t2 = new Thread(obj, "John");
		t1.start();
		t2.start();

//		t1.setName("Neha");
//		//t1.run();
//		t1.start();

	}

}
