package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {

		if (a > 0 && b > 0) {
			return a + b;
		}

		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public boolean isOddInteger(int n) {
		return n % 2 != 0;
	}
	
	public int randomNumberSquared() {
		int randInt = getRandomInt();
		return randInt*randInt;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}
}
