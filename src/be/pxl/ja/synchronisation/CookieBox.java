package be.pxl.ja.synchronisation;

public class CookieBox {

	private int numberOfCookies;

	public CookieBox(int numberOfCookies) {
		this.numberOfCookies = numberOfCookies;
	}

	public boolean neemKoekje() {
			if (numberOfCookies > 0) {
				numberOfCookies--;
				return true;
			}
			return false;
	}
}
