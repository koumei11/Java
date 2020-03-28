package study;

import java.util.stream.IntStream;

public class Test {
    /*
     * 1以上の整数nが与えられた時1からnまでの整数のうち5で割り切れない数の合計
     */
    public static void main(String[] args) {
        System.out.println(count1(20));
        System.out.println(count3(20));
        System.out.println(count4(20));
        System.out.println(39/5);
    }
    // 通常の解答
    public static int count1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(i % 5 != 0) {
                sum += i;
            }
        }
        return sum;
    }
    // streamを使ったver
    public static int count3(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> i % 5 != 0)
                .sum();
    }
    // 効率のいい書き方
    public static int count4(int n)
    {
        // 全体の和 - 5の倍数の和
        return (n+1)*n/2 - (n/5+1)*(n/5)*5/2;
    }
}
