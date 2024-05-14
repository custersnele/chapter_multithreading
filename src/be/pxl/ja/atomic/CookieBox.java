package be.pxl.ja.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CookieBox {

	private AtomicInteger numberOfCookies;

	public CookieBox(int numberOfCookies) {
		this.numberOfCookies = new AtomicInteger(numberOfCookies);
	}

	public boolean takeCookie() {
		int result = numberOfCookies.getAndDecrement();
		return result > 0;
	}
}
