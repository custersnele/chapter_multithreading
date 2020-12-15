package be.pxl.ja.states;

import java.io.IOException;

public class DemoStateBlocked extends Thread {

	private static int value = 0;
	private Thread parent;

	public DemoStateBlocked(Thread parent) {
		this.parent = parent;
	}

	@Override
	public void run() {
		commonResource();
		System.out.println(parent.getState());
	}

	private static synchronized void commonResource() {
		for (int i = 0; i < 100; i++) {
			value++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(value);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new DemoStateBlocked(Thread.currentThread());
		Thread t2 = new DemoStateBlocked(Thread.currentThread());
		t1.start();
		t2.start();
		Thread.sleep(2);
		System.out.printf("%n%s %s%n", t1.getState(), t2.getState());
		t2.join();
	}

}
