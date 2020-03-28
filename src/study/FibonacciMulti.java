package study;

public class FibonacciMulti implements Runnable {

    private static int fibonacci1(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        return fibonacci1(position - 1) + fibonacci1(position - 2);
    }

    @Override
    public void run() {
        System.out.println(fibonacci1(20));
    }
}
