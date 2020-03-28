package study;

public class Fibonacci {
    public static void main(String[] args) {
        FibonacciMulti mt = new FibonacciMulti();
        Thread thread = new Thread(mt);
        thread.start();
        System.out.println(fibonacci2(10));
    }

    private static int fibonacci2(int position) {
        if (position < 0) {
            return -1;
        }
        int current = 0;
        int next = 1;
        for (int i = 0; i < position; i++) {
            int tmp = current;
            current = next;
            next += tmp;
        }
        return current;
    }
}
