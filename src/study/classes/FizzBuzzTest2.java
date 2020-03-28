package study.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FizzBuzzTest2 {
	// JUnit5での新しい書き方
	// 普通のテストだとケースを増やすたびにメソッドが増えていってしまう
	// そこで以下のようにすれば異なる値を同時に渡すことができるようになる

	@ParameterizedTest
	@CsvSource({
		"3, 'Fizz'", // 3が引数のinputに、"Fizz"がexpectedに自動的に入ってくる
		"6, 'Fizz'",
		"9, 'Fizz'"
	})
	void testFizzBuzz1(int input, String expected) {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(input);
		assertEquals(expected, actual);
	}
	@ParameterizedTest
	@CsvSource({
		"5, 'Buzz'",
		"10, 'Buzz'",
		"20, 'Buzz'"
	})
	void testFizzBuzz2(int input, String expected) {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(input);
		assertEquals(expected, actual);
	}
	@ParameterizedTest
	@CsvSource({
		"15, 'FizzBuzz'",
		"30, 'FizzBuzz'",
		"45, 'FizzBuzz'"
	})
	void testFizzBuzz3(int input, String expected) {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(input);
		assertEquals(expected, actual);
	}
	@ParameterizedTest
	@CsvSource({
		"4, '4'",
		"7, '7'",
		"8, '8'"
	})
	void testFizzBuzz4(int input, String expected) {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(input);
		assertEquals(expected, actual);
	}
}
