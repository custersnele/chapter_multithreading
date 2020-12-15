package be.pxl.ja.states;

public class DemoStateNew extends Thread {

	@Override
	public void run() {
		System.out.println("Line A (" + Thread.currentThread().getName() + ")");
		System.out.println("Line B (" + Thread.currentThread().getName() + ")");
		System.out.println("Line C (" + Thread.currentThread().getName() + ")");
		System.out.println("Line D (" + Thread.currentThread().getName() + ")");
		System.out.println("Line E (" + Thread.currentThread().getName() + ")");
	}

	public static void main(String[] args) {
		DemoStateNew demo = new DemoStateNew();
		System.out.println(demo.getState());
		demo.start();
		System.out.println(demo.getState());
		System.out.println("Line 1 (" + Thread.currentThread().getName() + ")");
		System.out.println("Line 2 (" + Thread.currentThread().getName() + ")");
		System.out.println("Line 3 (" + Thread.currentThread().getName() + ")");
	}
}

