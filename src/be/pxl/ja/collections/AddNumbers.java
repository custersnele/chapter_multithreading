package be.pxl.ja.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddNumbers extends Thread {

	private int id;
	private List<Integer> numbers;

	public AddNumbers(int id, List<Integer> myList) {
		this.id = id;
		this.numbers = myList;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			numbers.add(id + i);
		}
	}

	public static void main(String[] args) {
		List<Integer> values = Collections.synchronizedList(new ArrayList<>());
		AddNumbers t1 = new AddNumbers(1000, values);
		AddNumbers t2 = new AddNumbers(10000, values);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(values.size());

	}

}
