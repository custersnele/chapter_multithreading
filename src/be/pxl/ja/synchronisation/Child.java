package be.pxl.ja.synchronisation;


public class Child extends Thread {

	private int numberOfCookies;
	private CookieBox cookieBox;
	private String name;

	public Child(String name, CookieBox cookieBox) {
		this.cookieBox = cookieBox;
		this.name = name;
	}

	@Override
	public void run() {
		while (cookieBox.neemKoekje()) {
			numberOfCookies++;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " had " + numberOfCookies + " cookies");
	}

	public int getNumberOfCookies() { return numberOfCookies; }
}
