package be.pxl.ja.synchronisation;


import java.util.Arrays;

public class EatingCookies {

	public static void main(String[] args) {
		CookieBox cookieBox = new CookieBox(50);
		Child[] children = { new Child("Bram", cookieBox),
				new Child("Sophie", cookieBox),
				new Child("Elke", cookieBox),
				new Child("Robin", cookieBox),
				new Child("Sammy", cookieBox),
				new Child("Max", cookieBox) };
        for (Child child : children) {
            child.start();
        }
        for (Child child : children) {
            try {
                child.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		System.out.println("Total amount of cookies: " +
				Arrays.stream(children)
						.mapToInt(Child::getNumberOfCookies)
						.sum());
	}
}
