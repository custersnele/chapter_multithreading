package be.pxl.ja.executor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReadFromUrl {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Callable<String> readData = () -> {
			URL url = new URL("http://www.google.com");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuilder result = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				result.append(line).append("\n");
			}
			return result.toString();
		};
		Future<String> data = executorService.submit(readData);
		System.out.println("Counting down...");
		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
		}
		try {
			String bookData = data.get();
			System.out.println(bookData);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
