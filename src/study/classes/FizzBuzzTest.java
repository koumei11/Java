package study.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

	// JUnitテストの作り方はテスト対象のファイルをクリック→新規→その他→Javaの中にあるJUnitのJUnitテストケースをクリック
	// →ソースフォルダで作る場所を指定。デフォルトは同じフォルダになっている。次へをクリック→テストしたいメソッドにチェックを入れて完了する

	@Test
	void testFizzBuzz1() {
		FizzBuzz f = new FizzBuzz();
		// 実際returnされるもの
		String actual = f.fizzBuzz(15);
		// 想定値
		String expected = "FizzBuzz";
		assertEquals(expected, actual);
	}
	void testFizzBuzz2() {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(3);
		String expected = "Fizz";
		assertEquals(expected, actual);
	}
	void testFizzBuzz3() {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(5);
		String expected = "Buzz";
		assertEquals(expected, actual);
	}
	void testFizzBuzz4() {
		FizzBuzz f = new FizzBuzz();
		String actual = f.fizzBuzz(7);
		String expected = "7";
		assertEquals(expected, actual);
	}
}
