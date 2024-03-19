package view;

import controller.ThreadPing;

public class Main {

	public static void main(String[] args) {
		Thread ping1 = new ThreadPing(1);
		ping1.start();
		Thread ping2 = new ThreadPing(2);
		ping2.start();
		Thread ping3 = new ThreadPing(3);
		ping3.start();
}
}