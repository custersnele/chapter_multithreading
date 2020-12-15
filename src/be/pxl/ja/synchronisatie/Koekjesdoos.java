package be.pxl.ja.synchronisatie;

public class Koekjesdoos {

	private Integer aantalKoekjes;

	public Koekjesdoos(int aantalKoekjes) {
		this.aantalKoekjes = aantalKoekjes;
	}

	public boolean neemKoekje() {
			if (aantalKoekjes > 0) {
				aantalKoekjes--;
				return true;
			}
			return false;
	}
}
