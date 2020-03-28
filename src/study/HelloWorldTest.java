package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testHello() {
		HelloWorld h = new HelloWorld();
		String actual = h.hello();
		String expected = "Hello World!";
		assertEquals(expected, actual);
	}

}
