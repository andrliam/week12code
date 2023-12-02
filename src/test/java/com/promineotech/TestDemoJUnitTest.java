package com.promineotech;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {

			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);

		}
		else {
			assertThatThrownBy( () -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
		assertThat(testDemo.addPositive(3,3)).isEqualTo(6);
		assertThat(testDemo.addPositive(15,45)).isEqualTo(60);
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				//Passing tests
				arguments(2, 4, 6, false),
				arguments(1, 1, 2, false),
				arguments(1127, 13728, 14855, false),
				arguments(13, 2, 15, false),
				
				
				
				//Non passing test
				arguments(0, 4, 4, true),
				arguments(3, 0, 3, true),
				arguments(-1, -2, -3, true)

		);
	}
	
	@Test
	void assertThatOddIntIsCorrect() {
		
		assertThat(testDemo.isOddInteger(3)).isEqualTo(true);
		assertThat(testDemo.isOddInteger(1)).isEqualTo(true);
		assertThat(testDemo.isOddInteger(7)).isEqualTo(true);
		assertThat(testDemo.isOddInteger(49)).isEqualTo(true);
		
		assertThat(testDemo.isOddInteger(2)).isEqualTo(false);
		assertThat(testDemo.isOddInteger(4)).isEqualTo(false);
		assertThat(testDemo.isOddInteger(6)).isEqualTo(false);
		assertThat(testDemo.isOddInteger(224)).isEqualTo(false);
		
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect(){
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
	
}
