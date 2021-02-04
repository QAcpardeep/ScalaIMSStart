package com.qa.utils;

import java.util.Scanner;

public class Utils {

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		Long longInput = null;
		do {
			String input = getString();
			try {
				longInput = Long.parseLong(input);
			} catch (NumberFormatException nfe) {
				System.out.println("Error - Please enter a number");
			}
		} while (longInput == null);
		return longInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Double getDouble() {
		Double doubleInput = null;
		do {
			String input = getString();
			try {
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				System.out.println("Error - Please enter a number");
			}
		} while (doubleInput == null);
		return doubleInput;
	}

}
