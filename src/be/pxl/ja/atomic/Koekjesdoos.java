package be.pxl.ja.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Koekjesdoos {

	private AtomicInteger aantalKoekjes;

	public Koekjesdoos(int aantalKoekjes) {
		this.aantalKoekjes = new AtomicInteger(aantalKoekjes);
	}

	public boolean neemKoekje() {
		int result = aantalKoekjes.getAndDecrement();
		return result > 0;
	}
}
