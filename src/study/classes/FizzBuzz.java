package study.classes;

public class FizzBuzz {

	// クラスメソッド
	public static void main(String[] args) {
		FizzBuzz f = new FizzBuzz();
		for (int i = 0; i < 100; i++) {
			// クラスメソッドからインスタンスメソッドは呼び出せないのでインスタンスを作ってから呼び出す
			// もしくはインスタンスメソッドにstaticをつけてクラスメソッドとする
			System.out.println(f.fizzBuzz(i));
		}
	}

	// インスタンスメソッド
	public String fizzBuzz(int num) {
		test();
		if ((num % 3 == 0) && (num % 5 == 0)) {
			return "FizzBuzz";
		}
		if (num % 3 == 0) {
			return "Fizz";
		}
		if (num % 5 == 0) {
			return "Buzz";
		}
		return Integer.toString(num);
	}

	public void test() {
		System.out.println("TEST");
	}

	public static void fg() {
		FizzBuzz f = new FizzBuzz();
		System.out.println(f.fizzBuzz(100));
	}
}
