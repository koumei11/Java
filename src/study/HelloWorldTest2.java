package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HelloWorldTest2 {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@ParameterizedTest
	@CsvSource({
		"10, 'This is Even!'",
		"22, 'This is Even!'",
		"56, 'This is Even!'"
	})
	void testEvenOrOdd1(int input, String expected) {
		HelloWorld h = new HelloWorld();
		String actual = h.evenOrOdd(input);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({
		"15, 'This is Odd!'",
		"23, 'This is Odd!'",
		"55, 'This is Odd!'"
	})
	void testEvenOrOdd2(int input, String expected) {
		HelloWorld h = new HelloWorld();
		String actual = h.evenOrOdd(input);
		assertEquals(expected, actual);
	}
}
