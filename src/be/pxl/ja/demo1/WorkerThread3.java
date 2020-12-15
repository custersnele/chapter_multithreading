package be.pxl.ja.demo1;

public class WorkerThread3 {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("Line A (" + Thread.currentThread().getName() + ")");
			System.out.println("Line B (" + Thread.currentThread().getName() + ")");
			System.out.println("Line C (" + Thread.currentThread().getName() + ")");
			System.out.println("Line D (" + Thread.currentThread().getName() + ")");
			System.out.println("Line E (" + Thread.currentThread().getName() + ")");
		}).start();
		System.out.println("Line 1 (" + Thread.currentThread().getName() + ")");
		System.out.println("Line 2 (" + Thread.currentThread().getName() + ")");
		System.out.println("Line 3 (" + Thread.currentThread().getName() + ")");
	}
}
