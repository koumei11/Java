package study;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	public String hello() {
		return "Hello World!";
	}
	public String evenOrOdd(int num) {
		switch (num%2) {
			case 0:
				return "This is Even!";
			case 1:
				return "This is Odd!";
			default:
				return "Aha!";
		}
	}
}
