package be.pxl.ja.synchronisatie;


import java.util.Arrays;

public class KoekjesEten {

	public static void main(String[] args) {
		Koekjesdoos koekjesdoos = new Koekjesdoos(50);
		Kind[] kinderen = { new Kind("Bram", koekjesdoos),
				new Kind("Sophie", koekjesdoos),
				new Kind("Elke", koekjesdoos),
				new Kind("Robin", koekjesdoos),
				new Kind("Sammy", koekjesdoos),
				new Kind("Max", koekjesdoos) };
		for (int i = 0; i < kinderen.length; i++) {
			kinderen[i].start();
		}
		for (int i = 0; i < kinderen.length; i++) {
			try {
				kinderen[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("De kinderen aten: " +
				Arrays.stream(kinderen)
						.mapToInt(kind -> kind.getAantalKoekjes())
						.sum());
	}
}
